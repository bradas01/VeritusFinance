package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaOrcamento extends JFrame {

    public TelaOrcamento() {
        super("Definir Orçamento Mensal");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Orçamento"), BorderLayout.NORTH);

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel painelInput = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        painelInput.add(new JLabel("Meta de Gastos Mensal (R$):"));
        JTextField txtOrcamento = new JTextField(10);
        painelInput.add(txtOrcamento);

        painelPrincipal.add(painelInput, gbc);

        this.add(painelPrincipal, BorderLayout.CENTER);

        JButton btnDefinir = new JButton("Definir Meta");

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnDefinir);
        this.add(painelBotao, BorderLayout.SOUTH);

        btnDefinir.addActionListener(e -> {
            try {
                double meta = Double.parseDouble(txtOrcamento.getText());
                JOptionPane.showMessageDialog(this, String.format("Meta de R$ %.2f definida com sucesso!", meta));
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
