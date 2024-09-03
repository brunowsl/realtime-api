package br.tc.tcema.temporealteste;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/demonstrativo")
@RequiredArgsConstructor
public class CheckProgressFromDemonstrativoController {

    private final ProgressoDemonstrativoRepository progressoDemonstrativoRepository;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamEvents(Long demonstrativoId) {
        SseEmitter emitter = new SseEmitter(0L);
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
        sseMvcExecutor.execute(() -> {
            try {

                ProgressoDemonstrativoSchema byDemonstrativoId;

                do {
                    byDemonstrativoId = progressoDemonstrativoRepository.findByDemonstrativoId(demonstrativoId);
                    emitter.send(String.valueOf(byDemonstrativoId.getProgresso()));
                    Thread.sleep(1000);
                } while (byDemonstrativoId.getProgresso() < 100);

                emitter.complete();

            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }


}
