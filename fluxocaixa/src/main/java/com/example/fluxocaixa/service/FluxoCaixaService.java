package com.example.fluxocaixa.service;

import com.example.fluxocaixa.model.Lancamento;
import com.example.fluxocaixa.repository.LancamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FluxoCaixaService {
    
    private final Logger logger = LoggerFactory.getLogger(FluxoCaixaService.class);
    private final LancamentoRepository lancamentoRepository;

    public FluxoCaixaService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento criarLancamento(Lancamento lancamento) {
        logger.info("Criando lançamento...");
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> obterLancamentos() {
        logger.info("Obtendo lançamentos...");
        return lancamentoRepository.findAll();
    }

    public double calcularSaldoConsolidado() {
        logger.info("Calculando saldo consolidado...");
        double saldo = 0;
        List<Lancamento> lancamentos = obterLancamentos();

        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getTipo().equalsIgnoreCase("DEBITO")) {
                saldo -= lancamento.getValor();
            } else if (lancamento.getTipo().equalsIgnoreCase("CREDITO")) {
                saldo += lancamento.getValor();
            }
        }

        return saldo;
    }
}
