package com.antoniosousa.analisecredito.service.strategy.impl;

import com.antoniosousa.analisecredito.domain.Proposta;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 100;
    }

    private boolean outrosEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
