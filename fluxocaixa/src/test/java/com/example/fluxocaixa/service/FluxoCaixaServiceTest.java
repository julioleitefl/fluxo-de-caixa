package com.example.fluxocaixa.service;

import com.example.fluxocaixa.model.Lancamento;
import com.example.fluxocaixa.repository.LancamentoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FluxoCaixaServiceTest {

    @InjectMocks
    FluxoCaixaService fluxoCaixaService;

    @Mock
    LancamentoRepository lancamentoRepository;

    @Test
    public void obterLancamentosTest() {
        Lancamento lancamento1 = new Lancamento(1, "DEBITO", 500.0);
        Lancamento lancamento2 = new Lancamento(2, "CREDITO", 1000.0);
        when(lancamentoRepository.findAll()).thenReturn(Arrays.asList(lancamento1, lancamento2));

        List<Lancamento> result = fluxoCaixaService.obterLancamentos();

        assertEquals(2, result.size());
        verify(lancamentoRepository, times(1)).findAll();
    }

    // outros testes podem ser adicionados aqui
}
