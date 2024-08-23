package br.tc.tcema.temporealteste;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class SSEEmitterConfig {

    @Bean(name = "sseEmitter")
    public Executor sseEmitter() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("SSE Thread - ");
        executor.initialize();
        return executor;
    }
}
