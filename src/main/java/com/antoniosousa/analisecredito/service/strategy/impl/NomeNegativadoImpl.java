package com.antoniosousa.analisecredito.service.strategy.impl;

import com.antoniosousa.analisecredito.constantes.MensagemConstante;
import com.antoniosousa.analisecredito.domain.Proposta;
import com.antoniosousa.analisecredito.exceptions.StrategyException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Order(1)
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {

        if (nomeNegativado()) {
            throw new StrategyException(String.format(MensagemConstante.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }
        return 100;

    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }


}
