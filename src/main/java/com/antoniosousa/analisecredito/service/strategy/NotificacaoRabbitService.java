package com.antoniosousa.analisecredito.service.strategy;

import com.antoniosousa.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notify(String exchange, Proposta proposta) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }

}
