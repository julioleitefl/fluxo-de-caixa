package com.example.fluxocaixa.service;

import com.example.fluxocaixa.model.Lancamento;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    FluxoCaixaService fluxoCaixaService;

    public void gerarRelatorio() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio.pdf"));

            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Paragraph para = new Paragraph("Relatorio do Fluxo de Caixa", font);
            document.add(para);
            document.add(Chunk.NEWLINE);

            List<Lancamento> lancamentos = fluxoCaixaService.obterLancamentos();

            for(Lancamento lancamento : lancamentos) {
                Paragraph p = new Paragraph("Data: " + lancamento.getData()
                        + ", Tipo: " + lancamento.getTipo()
                        + ", Valor: " + lancamento.getValor(), font);
                document.add(p);
            }

            document.close();

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
