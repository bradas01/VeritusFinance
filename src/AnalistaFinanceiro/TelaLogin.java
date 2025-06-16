package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        super("Login - Analista Financeiro");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.add(TelaPrincipal.createHeaderPanel("Bem-vindo!"), BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painelCentral.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField("admin", 15);
        txtUsuario.setBackground(new Color(45, 45, 45));
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 1;
        painelCentral.add(txtUsuario, gbc);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painelCentral.add(lblSenha, gbc);

        JPasswordField txtSenha = new JPasswordField("1234");
        txtSenha.setBackground(new Color(45, 45, 45));
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelCentral.add(txtSenha, gbc);

        this.add(painelCentral, BorderLayout.CENTER);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEntrar.setBackground(new Color(70, 130, 180));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(30, 30, 30));
        painelBotao.add(btnEntrar);
        this.add(painelBotao, BorderLayout.SOUTH);

        btnEntrar.addActionListener(e -> {
            new TelaPrincipal().setVisible(true);
            this.dispose();
        });
    }
}
