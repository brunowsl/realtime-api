package br.tc.tcema.temporealteste;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/emitter")
@RequiredArgsConstructor
public class EmitterController {
    private final SendEventsService sseService;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamSSE() throws IOException, InterruptedException {

        SseEmitter emitter = new SseEmitter(0L);
        sseService.emitters.add(emitter);

        Thread thread = new Thread(() -> {
            try {
                sseService.sendEvents(emitter);
                emitter.complete();
            } catch (Exception e) {

            }
        });
        thread.start();

        return emitter;
    }
}
