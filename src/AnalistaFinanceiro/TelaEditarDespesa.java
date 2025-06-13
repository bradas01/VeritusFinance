package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TelaEditarDespesa extends JFrame {

    private JTextField txtDescricao, txtValor, txtData;
    private JComboBox<Categoria> comboCategorias;
    private int indiceDespesa;

    public TelaEditarDespesa(int indice) {
        super("Editar Despesa");
        this.indiceDespesa = indice;
        Despesa despesa = TelaPrincipal.listaDeDespesas.get(indice);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.add(TelaPrincipal.createHeaderPanel("Editar Despesa"), BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painelFormulario.add(lblDescricao, gbc);

        txtDescricao = new JTextField(despesa.getDescricao(), 20);
        txtDescricao.setBackground(new Color(60, 63, 65));
        txtDescricao.setForeground(Color.WHITE);
        txtDescricao.setCaretColor(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 1;
        painelFormulario.add(txtDescricao, gbc);

        JLabel lblValor = new JLabel("Valor (R$):");
        lblValor.setForeground(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painelFormulario.add(lblValor, gbc);

        txtValor = new JTextField(String.valueOf(despesa.getValor()), 20);
        txtValor.setBackground(new Color(60, 63, 65));
        txtValor.setForeground(Color.WHITE);
        txtValor.setCaretColor(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelFormulario.add(txtValor, gbc);

        JLabel lblData = new JLabel("Data (dd/MM/yyyy):");
        lblData.setForeground(Color.WHITE);
        gbc.gridy = 3;
        gbc.gridx = 0;
        painelFormulario.add(lblData, gbc);

        txtData = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(despesa.getData()), 20);
        txtData.setBackground(new Color(60, 63, 65));
        txtData.setForeground(Color.WHITE);
        txtData.setCaretColor(Color.WHITE);
        gbc.gridy = 3;
        gbc.gridx = 1;
        painelFormulario.add(txtData, gbc);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setForeground(Color.WHITE);
        gbc.gridy = 4;
        gbc.gridx = 0;
        painelFormulario.add(lblCategoria, gbc);

        comboCategorias = new JComboBox<>();
        comboCategorias.setBackground(new Color(60, 63, 65));
        comboCategorias.setForeground(Color.WHITE);
        TelaPrincipal.listaDeCategorias.forEach(comboCategorias::addItem);
        comboCategorias.setSelectedItem(despesa.getCategoria());
        gbc.gridy = 4;
        gbc.gridx = 1;
        painelFormulario.add(comboCategorias, gbc);

        this.add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.setBackground(new Color(30, 30, 30));

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(60, 63, 65));
        btnSalvar.setForeground(Color.WHITE);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(60, 63, 65));
        btnCancelar.setForeground(Color.WHITE);

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        this.add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvarAlteracoes());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarAlteracoes() {
        try {
            Despesa despesaEditada = TelaPrincipal.listaDeDespesas.get(indiceDespesa);
            despesaEditada.setDescricao(txtDescricao.getText());
            despesaEditada.setValor(Double.parseDouble(txtValor.getText()));
            despesaEditada.setData(new SimpleDateFormat("dd/MM/yyyy").parse(txtData.getText()));
            despesaEditada.setCategoria((Categoria) comboCategorias.getSelectedItem());

            JOptionPane.showMessageDialog(this, "Despesa atualizada com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
