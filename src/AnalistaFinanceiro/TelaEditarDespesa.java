package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        this.add(TelaPrincipal.createHeaderPanel("Editar Despesa"), BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        try {
            ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/edit_despesa_banner.png"));
            gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER; gbc.insets = new Insets(5,5,15,5);
            painelFormulario.add(new JLabel(icone), gbc);
            gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(5,5,5,5);
        } catch (Exception e) {}

        gbc.gridy = 1; gbc.gridx = 0; painelFormulario.add(new JLabel("Descrição:"), gbc);
        gbc.gridy = 1; gbc.gridx = 1; txtDescricao = new JTextField(despesa.getDescricao(), 20); painelFormulario.add(txtDescricao, gbc);

        gbc.gridy = 2; gbc.gridx = 0; painelFormulario.add(new JLabel("Valor (R$):"), gbc);
        gbc.gridy = 2; gbc.gridx = 1; txtValor = new JTextField(String.valueOf(despesa.getValor()), 20); painelFormulario.add(txtValor, gbc);

        gbc.gridy = 3; gbc.gridx = 0; painelFormulario.add(new JLabel("Data (dd/MM/yyyy):"), gbc);
        gbc.gridy = 3; gbc.gridx = 1; txtData = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(despesa.getData()), 20); painelFormulario.add(txtData, gbc);

        gbc.gridy = 4; gbc.gridx = 0; painelFormulario.add(new JLabel("Categoria:"), gbc);
        gbc.gridy = 4; gbc.gridx = 1; comboCategorias = new JComboBox<>(); TelaPrincipal.listaDeCategorias.forEach(comboCategorias::addItem); comboCategorias.setSelectedItem(despesa.getCategoria()); painelFormulario.add(comboCategorias, gbc);

        this.add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
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
