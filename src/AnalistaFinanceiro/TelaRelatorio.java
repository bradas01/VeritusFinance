package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class TelaRelatorio extends JFrame {

    private JEditorPane editorPane;

    public TelaRelatorio() {
        super("Relatório de Despesas");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Relatório Financeiro"), BorderLayout.NORTH);

        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");

        double total = TelaPrincipal.listaDeDespesas.stream().mapToDouble(Despesa::getValor).sum();
        double media = total / (TelaPrincipal.listaDeDespesas.isEmpty() ? 1 : TelaPrincipal.listaDeDespesas.size());

        String despesasHtml = TelaPrincipal.listaDeDespesas.stream()
                .map(d -> String.format(
                        "<tr>" +
                                "<td style='padding: 4px; border-bottom: 1px solid #ddd;'>%s</td>" +
                                "<td style='padding: 4px; border-bottom: 1px solid #ddd;'>%s</td>" +
                                "<td style='padding: 4px; border-bottom: 1px solid #ddd;'>%s</td>" +
                                "<td style='padding: 4px; border-bottom: 1px solid #ddd; text-align: right;'>R$ %.2f</td>" +
                                "</tr>",
                        new SimpleDateFormat("dd/MM/yyyy").format(d.getData()),
                        d.getCategoria().getNome(),
                        d.getDescricao(),
                        d.getValor()
                ))
                .collect(Collectors.joining(""));

        String bannerHtml = "";
        try {
            bannerHtml = "<div style='text-align:center; margin-bottom: 20px;'><img src='" + getClass().getResource("/imagens/relatorio_banner.png") + "'></div>";
        } catch(Exception e) {}

        editorPane.setText(
                "<html>" +
                        "<body style='font-family: Arial, sans-serif; margin: 20px;'>" +
                        bannerHtml +
                        "<div style='background-color: #f0f8ff; padding: 15px; border-radius: 8px;'>" +
                        "<h2 style='color: #005a9e;'>Resumo Geral</h2>" +
                        "<p><b>Total de Despesas:</b> " + TelaPrincipal.listaDeDespesas.size() + " registros</p>" +
                        "<p><b>Valor Total Gasto:</b> <span style='color: red; font-weight: bold;'>R$ " + String.format("%.2f", total) + "</span></p>" +
                        "<p><b>Média de Gasto por Despesa:</b> R$ " + String.format("%.2f", media) + "</p>" +
                        "</div>" +
                        "<h2 style='color: #005a9e; margin-top: 30px;'>Lista de Despesas</h2>" +
                        "<table style='width: 100%; border-collapse: collapse;'>" +
                        "<tr style='background-color: #005a9e; color: white;'>" +
                        "<th style='padding: 8px; text-align: left;'>Data</th>" +
                        "<th style='padding: 8px; text-align: left;'>Categoria</th>" +
                        "<th style='padding: 8px; text-align: left;'>Descrição</th>" +
                        "<th style='padding: 8px; text-align: right;'>Valor</th>" +
                        "</tr>" +
                        despesasHtml +
                        "</table>" +
                        "</body>" +
                        "</html>"
        );

        this.add(new JScrollPane(editorPane), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnExportarCSV = new JButton("Gerar CSV");
        JButton btnImprimir = new JButton("Imprimir Relatório");
        painelBotoes.add(btnExportarCSV);
        painelBotoes.add(btnImprimir);
        this.add(painelBotoes, BorderLayout.SOUTH);

        btnImprimir.addActionListener(e -> imprimirRelatorio());
        btnExportarCSV.addActionListener(e -> exportarParaCSV());
    }

    private void imprimirRelatorio() {
        try {
            boolean completo = editorPane.print();
            if (completo) {
                JOptionPane.showMessageDialog(this, "Impressão enviada com sucesso!", "Imprimir", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Impressão cancelada.", "Imprimir", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(this, "Não foi possível iniciar a impressão: " + pe.getMessage(), "Erro de Impressão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportarParaCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório CSV");
        fileChooser.setSelectedFile(new File("relatorio_despesas.csv"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
            }

            try (FileWriter fw = new FileWriter(fileToSave);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write("Data,Categoria,Descricao,Valor");
                bw.newLine();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (Despesa d : TelaPrincipal.listaDeDespesas) {
                    String linha = String.format("\"%s\",\"%s\",\"%s\",\"%.2f\"",
                            sdf.format(d.getData()),
                            d.getCategoria().getNome().replace("\"", "\"\""),
                            d.getDescricao().replace("\"", "\"\""),
                            d.getValor());
                    bw.write(linha);
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(this,
                        "Relatório CSV gerado com sucesso!\nSalvo em: " + fileToSave.getAbsolutePath(),
                        "Exportação Concluída",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
