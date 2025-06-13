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
        this.getContentPane().setBackground(new Color(30, 30, 30));  // Fundo escuro

        this.add(TelaPrincipal.createHeaderPanel("Orçamento"), BorderLayout.NORTH);

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(new Color(30, 30, 30));  // Fundo painel escuro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel painelInput = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        painelInput.setBackground(new Color(30, 30, 30));  // Fundo painelInput escuro

        JLabel label = new JLabel("Meta de Gastos Mensal (R$):");
        label.setForeground(Color.WHITE); // Texto claro para tema escuro
        painelInput.add(label);

        JTextField txtOrcamento = new JTextField(10);
        txtOrcamento.setBackground(new Color(60, 63, 65));  // Fundo campo texto escuro
        txtOrcamento.setForeground(Color.WHITE);           // Texto claro no campo
        txtOrcamento.setCaretColor(Color.WHITE);
        painelInput.add(txtOrcamento);

        painelPrincipal.add(painelInput, gbc);

        this.add(painelPrincipal, BorderLayout.CENTER);

        JButton btnDefinir = new JButton("Definir Meta");
        btnDefinir.setBackground(new Color(60, 63, 65));
        btnDefinir.setForeground(Color.WHITE);

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(30, 30, 30));
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
