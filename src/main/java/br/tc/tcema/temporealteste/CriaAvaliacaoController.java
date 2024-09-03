package br.tc.tcema.temporealteste;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/avaliacao")
@RestController
@RequiredArgsConstructor
public class CriaAvaliacaoController {

    private final CriaAvaliacaoService criaAvaliacaoService;

    @PostMapping("/criar")
    public void criarAvaliacao(Long demonstrativoId) throws InterruptedException {
        criaAvaliacaoService.execute(demonstrativoId);
    }

}
