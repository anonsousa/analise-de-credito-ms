package com.antoniosousa.analisecredito.service.strategy.impl;

import com.antoniosousa.analisecredito.domain.Proposta;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorValorSolicitadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorValorSolicitado(Proposta proposta) {
        return proposta.getUsuario().getRenda().compareTo(proposta.getValorSolicitado()) > 0;
    }
}
