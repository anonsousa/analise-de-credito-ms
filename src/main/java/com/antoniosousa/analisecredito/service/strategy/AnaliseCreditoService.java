package com.antoniosousa.analisecredito.service.strategy;

import com.antoniosousa.analisecredito.domain.Proposta;
import com.antoniosousa.analisecredito.exceptions.StrategyException;
import com.antoniosousa.analisecredito.service.strategy.impl.CalculoPonto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Autowired
    private NotificacaoRabbitService notificacaoRabbitService;

    @Value("${rabbitmq.exchange.proposta.concluida}")
    private String exchangePropostaConcluida;

    public void analisar(Proposta proposta) {
        try {
            int pontos =  calculoPontoList.stream()
                    .mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovada(pontos > 350);

        } catch (StrategyException ex) {

            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());

        }

        notificacaoRabbitService.notify(exchangePropostaConcluida, proposta);

    }
}
