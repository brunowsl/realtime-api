package br.tc.tcema.temporealteste;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CriaAvaliacaoService {

    private final ProgressoDemonstrativoRepository progressoDemonstrativoRepository;
    private final DemonstrativoRepository demonstrativoRepository;

    public void execute() throws InterruptedException {
        val id = new Random();

        val demonstrativo = new DemonstrativoSchema(1L);

        val progressoDemonstrativo = new ProgressoDemonstrativoSchema(id.nextLong(), demonstrativo.getId(), 0);
        ProgressoDemonstrativoSchema save = progressoDemonstrativoRepository.save(progressoDemonstrativo);

        Thread.sleep(1000);
        save.setProgresso(12);
        progressoDemonstrativoRepository.save(save);

        Thread.sleep(1000);
        save.setProgresso(25);
        progressoDemonstrativoRepository.save(save);

        Thread.sleep(1000);
        save.setProgresso(50);
        progressoDemonstrativoRepository.save(save);

        Thread.sleep(1000);
        save.setProgresso(75);
        progressoDemonstrativoRepository.save(save);

        Thread.sleep(1000);
        save.setProgresso(90);
        progressoDemonstrativoRepository.save(save);

        Thread.sleep(1000);
        save.setProgresso(100);
        progressoDemonstrativoRepository.save(save);
    }
}
