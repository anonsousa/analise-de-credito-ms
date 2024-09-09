package com.antoniosousa.analisecredito.service.strategy.impl;

import com.antoniosousa.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
