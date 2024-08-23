package br.tc.tcema.temporealteste;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.CompletableFuture;

@Service
public class CounterService {

    @Async("sseEmitter")
    public CompletableFuture<Void> callCounter(SseEmitter emitter, int i) throws InterruptedException {
        try {
            Thread.sleep(1000);
            emitter.send(i);
            System.out.println("emitted: " + i);
        } catch (Exception e) {

        }
        return CompletableFuture.completedFuture(null);
    }
}
