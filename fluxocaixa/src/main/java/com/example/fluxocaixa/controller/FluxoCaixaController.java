package com.example.fluxocaixa.controller;

import com.example.fluxocaixa.model.Lancamento;
import com.example.fluxocaixa.service.FluxoCaixaService;
import com.example.fluxocaixa.service.RelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class FluxoCaixaController {

    private final FluxoCaixaService fluxoCaixaService;
    private final RelatorioService relatorioService;

    public FluxoCaixaController(FluxoCaixaService fluxoCaixaService, RelatorioService relatorioService) {
        this.fluxoCaixaService = fluxoCaixaService;
        this.relatorioService = relatorioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento criarLancamento(@RequestBody Lancamento lancamento) {
        return fluxoCaixaService.criarLancamento(lancamento);
    }

    @GetMapping
    public List<Lancamento> obterLancamentos() {
        return fluxoCaixaService.obterLancamentos();
    }

    // Implementar endpoint para o saldo diário consolidado

    @GetMapping("/relatorio")
    public void gerarRelatorio() {
        relatorioService.gerarRelatorio();
    }
}
