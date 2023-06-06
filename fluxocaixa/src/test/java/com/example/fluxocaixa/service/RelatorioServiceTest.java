package com.example.fluxocaixa.service;

import com.example.fluxocaixa.model.Lancamento;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class RelatorioServiceTest {

    @InjectMocks
    RelatorioService relatorioService;

    @Mock
    FluxoCaixaService fluxoCaixaService;

    @Test
    public void gerarRelatorioTest() {
        Lancamento lancamento1 = new Lancamento(1, "DEBITO", 500.0);
        Lancamento lancamento2 = new Lancamento(2, "CREDITO", 1000.0);
        when(fluxoCaixaService.obterLancamentos()).thenReturn(Arrays.asList(lancamento1, lancamento2));

        relatorioService.gerarRelatorio();

        verify(fluxoCaixaService, times(1)).obterLancamentos();
    }

    // outros testes podem ser adicionados aqui
}

