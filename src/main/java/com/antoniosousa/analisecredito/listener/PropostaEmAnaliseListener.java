package com.antoniosousa.analisecredito.listener;


import com.antoniosousa.analisecredito.domain.Proposta;
import com.antoniosousa.analisecredito.service.strategy.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaEmAnaliseListener {


    private final AnaliseCreditoService analiseCreditoService;

    public PropostaEmAnaliseListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${rabbit.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }

}
