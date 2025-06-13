package AnalistaFinanceiro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TelaVisualizarDespesas extends JFrame {

    private JTable tabelaDespesas;
    private DefaultTableModel modeloTabela;

    public TelaVisualizarDespesas() {
        super("Visualizar Despesas");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Minhas Despesas"), BorderLayout.NORTH);

        String[] colunas = {"Descrição", "Valor (R$)", "Data", "Categoria"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaDespesas = new JTable(modeloTabela);
        tabelaDespesas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelaDespesas.setRowHeight(25);
        JTableHeader header = tabelaDespesas.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tabelaDespesas);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(scrollPane, BorderLayout.CENTER);

        carregarDadosNaTabela();

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnAtualizar = new JButton("Atualizar");
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnAtualizar);

        JPanel painelSul = new JPanel(new BorderLayout());
        painelSul.add(painelBotoes, BorderLayout.NORTH);
        try {
            painelSul.add(new JLabel(new ImageIcon(getClass().getResource("/imagens/view_despesas_banner.png"))), BorderLayout.CENTER);
        } catch (Exception e) {}
        this.add(painelSul, BorderLayout.SOUTH);

        btnExcluir.addActionListener(e -> excluirDespesa());
        btnEditar.addActionListener(e -> editarDespesa());
        btnAtualizar.addActionListener(e -> carregarDadosNaTabela());
    }

    private void carregarDadosNaTabela() {
        modeloTabela.setRowCount(0);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        for (Despesa despesa : TelaPrincipal.listaDeDespesas) {
            modeloTabela.addRow(new Object[]{
                    despesa.getDescricao(),
                    despesa.getValor(),
                    formatador.format(despesa.getData()),
                    despesa.getCategoria().getNome()
            });
        }
    }

    private void excluirDespesa() {
        int linha = tabelaDespesas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma despesa para excluir.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            TelaPrincipal.listaDeDespesas.remove(linha);
            carregarDadosNaTabela();
        }
    }

    private void editarDespesa() {
        int linha = tabelaDespesas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma despesa para editar.");
            return;
        }
        new TelaEditarDespesa(linha).setVisible(true);
    }
}
