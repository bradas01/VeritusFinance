package AnalistaFinanceiro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaGerenciarCategorias extends JFrame {

    private JTable tabelaCategorias;
    private DefaultTableModel modeloTabela;

    public TelaGerenciarCategorias() {
        super("Gerenciar Categorias");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Categorias"), BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(new String[]{"Nome da Categoria"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaCategorias = new JTable(modeloTabela);
        this.add(new JScrollPane(tabelaCategorias), BorderLayout.CENTER);
        carregarDadosNaTabela();

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnExcluir = new JButton("Excluir");
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnExcluir);

        JPanel painelSul = new JPanel(new BorderLayout());
        painelSul.add(painelBotoes, BorderLayout.NORTH);
        try {
            painelSul.add(new JLabel(new ImageIcon(getClass().getResource("/imagens/categorias_banner.png"))), BorderLayout.CENTER);
        } catch (Exception e) {}
        this.add(painelSul, BorderLayout.SOUTH);


        btnAdicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Nome da nova categoria:", "Adicionar", JOptionPane.PLAIN_MESSAGE);
            if (nome != null && !nome.trim().isEmpty()) {
                TelaPrincipal.listaDeCategorias.add(new Categoria(nome.trim()));
                carregarDadosNaTabela();
            }
        });

        btnExcluir.addActionListener(e -> {
            int linha = tabelaCategorias.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione uma categoria para excluir.");
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "Tem certeza?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                TelaPrincipal.listaDeCategorias.remove(linha);
                carregarDadosNaTabela();
            }
        });
    }

    private void carregarDadosNaTabela() {
        modeloTabela.setRowCount(0);
        TelaPrincipal.listaDeCategorias.forEach(cat -> modeloTabela.addRow(new Object[]{cat.getNome()}));
    }
}
