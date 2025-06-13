package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaAdicionarDespesa extends JFrame {

    private JTextField txtDescricao, txtValor, txtData;
    private JComboBox<Categoria> comboCategorias;

    public TelaAdicionarDespesa() {
        super("Adicionar Nova Despesa");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.add(TelaPrincipal.createHeaderPanel("Nova Despesa"), BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setForeground(Color.WHITE);
        gbc.gridy = 1; gbc.gridx = 0; painelFormulario.add(lblDescricao, gbc);
        txtDescricao = new JTextField(20);
        txtDescricao.setBackground(new Color(45, 45, 45));
        txtDescricao.setForeground(Color.WHITE);
        txtDescricao.setCaretColor(Color.WHITE);
        gbc.gridy = 1; gbc.gridx = 1; painelFormulario.add(txtDescricao, gbc);

        JLabel lblValor = new JLabel("Valor (R$):");
        lblValor.setForeground(Color.WHITE);
        gbc.gridy = 2; gbc.gridx = 0; painelFormulario.add(lblValor, gbc);
        txtValor = new JTextField(20);
        txtValor.setBackground(new Color(45, 45, 45));
        txtValor.setForeground(Color.WHITE);
        txtValor.setCaretColor(Color.WHITE);
        gbc.gridy = 2; gbc.gridx = 1; painelFormulario.add(txtValor, gbc);

        JLabel lblData = new JLabel("Data (dd/MM/yyyy):");
        lblData.setForeground(Color.WHITE);
        gbc.gridy = 3; gbc.gridx = 0; painelFormulario.add(lblData, gbc);
        txtData = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 20);
        txtData.setBackground(new Color(45, 45, 45));
        txtData.setForeground(Color.WHITE);
        txtData.setCaretColor(Color.WHITE);
        gbc.gridy = 3; gbc.gridx = 1; painelFormulario.add(txtData, gbc);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setForeground(Color.WHITE);
        gbc.gridy = 4; gbc.gridx = 0; painelFormulario.add(lblCategoria, gbc);
        comboCategorias = new JComboBox<>();
        comboCategorias.setBackground(new Color(45, 45, 45));
        comboCategorias.setForeground(Color.WHITE);
        TelaPrincipal.listaDeCategorias.forEach(comboCategorias::addItem);
        gbc.gridy = 4; gbc.gridx = 1; painelFormulario.add(comboCategorias, gbc);

        this.add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.setBackground(new Color(30, 30, 30));
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        this.add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvarDespesa());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvarDespesa() {
        try {
            String descricao = txtDescricao.getText();
            double valor = Double.parseDouble(txtValor.getText());
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(txtData.getText());
            Categoria categoria = (Categoria) comboCategorias.getSelectedItem();

            if (descricao.trim().isEmpty() || categoria == null) {
                JOptionPane.showMessageDialog(this, "Descrição e Categoria são obrigatórios.", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TelaPrincipal.listaDeDespesas.add(new Despesa(descricao, valor, data, categoria));
            JOptionPane.showMessageDialog(this, "Despesa salva com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar. Verifique os dados (valor e data).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
