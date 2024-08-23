package br.tc.tcema.temporealteste;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class SendEventsService {
    private final CounterService counterServiceCall;
    CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public void sendEvents(SseEmitter emitter) throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            CompletableFuture<Void> counter = counterServiceCall.callCounter(emitter, i);
        }
    }

    public void sendEvent2() {
        System.out.println("scheaduler called");

        for (SseEmitter emitter : emitters) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("iteration number: " + i);
                    emitter.send(i);
                    Thread.sleep(1000);
                }
                emitter.complete();
                emitters.remove(emitter);
            } catch (Exception e) {

            }
        }
    }

}
