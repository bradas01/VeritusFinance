package AnalistaFinanceiro;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaDashboard extends JFrame {

    public TelaDashboard() {
        super("Dashboard Resumo");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.add(TelaPrincipal.createHeaderPanel("Dashboard"), BorderLayout.NORTH);

        JPanel painelConteudo = new JPanel(new GridLayout(4, 1, 10, 10));
        painelConteudo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelConteudo.setBackground(new Color(30, 30, 30));

        double totalGasto = TelaPrincipal.listaDeDespesas.stream().mapToDouble(Despesa::getValor).sum();
        int totalDespesas = TelaPrincipal.listaDeDespesas.size();
        String categoriaCara = calcularCategoriaMaisCara();

        painelConteudo.add(criarLabel(String.format("Total Gasto: R$ %.2f", totalGasto), Font.PLAIN, 22, Color.WHITE));
        painelConteudo.add(criarLabel("Despesas Registradas: " + totalDespesas, Font.PLAIN, 22, Color.WHITE));
        painelConteudo.add(criarLabel("Categoria com Maior Gasto: " + categoriaCara, Font.PLAIN, 22, Color.WHITE));

        this.add(painelConteudo, BorderLayout.CENTER);
    }

    private JLabel criarLabel(String texto, int estilo, int tamanho, Color cor) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(new Font("Segoe UI", estilo, tamanho));
        label.setForeground(cor);
        return label;
    }

    private String calcularCategoriaMaisCara() {
        if (TelaPrincipal.listaDeDespesas.isEmpty()) return "N/A";

        Map<String, Double> gastosPorCategoria = new HashMap<>();
        for (Despesa d : TelaPrincipal.listaDeDespesas) {
            String nomeCat = d.getCategoria().getNome();
            gastosPorCategoria.put(nomeCat, gastosPorCategoria.getOrDefault(nomeCat, 0.0) + d.getValor());
        }

        return gastosPorCategoria.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
