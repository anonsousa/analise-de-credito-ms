package com.antoniosousa.analisecredito.service.strategy.impl;

import com.antoniosousa.analisecredito.domain.Proposta;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoInferiorDezAnosImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }

}
