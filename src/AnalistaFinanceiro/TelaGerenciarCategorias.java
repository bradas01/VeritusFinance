package AnalistaFinanceiro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.add(TelaPrincipal.createHeaderPanel("Categorias"), BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(new String[]{"Nome da Categoria"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaCategorias = new JTable(modeloTabela);
        tabelaCategorias.setBackground(new Color(30, 30, 30));
        tabelaCategorias.setForeground(Color.WHITE);
        tabelaCategorias.setGridColor(Color.DARK_GRAY);
        tabelaCategorias.setRowHeight(25);
        tabelaCategorias.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTableHeader header = tabelaCategorias.getTableHeader();
        header.setBackground(new Color(45, 45, 45));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tabelaCategorias);
        scrollPane.getViewport().setBackground(new Color(30, 30, 30));
        this.add(scrollPane, BorderLayout.CENTER);

        carregarDadosNaTabela();

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBackground(new Color(30, 30, 30));
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnExcluir = new JButton("Excluir");
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnExcluir);

        JPanel painelSul = new JPanel(new BorderLayout());
        painelSul.setBackground(new Color(30, 30, 30));
        painelSul.add(painelBotoes, BorderLayout.NORTH);
        if (TelaPrincipal.listaDeCategorias.isEmpty()) {

        }
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
