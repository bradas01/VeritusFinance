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

        this.add(TelaPrincipal.createHeaderPanel("Bem-vindo!"), BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 1;
        gbc.gridx = 0;
        painelCentral.add(new JLabel("Usuário:"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        JTextField txtUsuario = new JTextField("admin", 15);
        painelCentral.add(txtUsuario, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        painelCentral.add(new JLabel("Senha:"), gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        JPasswordField txtSenha = new JPasswordField("1234");
        painelCentral.add(txtSenha, gbc);

        this.add(painelCentral, BorderLayout.CENTER);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnEntrar);
        this.add(painelBotao, BorderLayout.SOUTH);

        btnEntrar.addActionListener(e -> {
            new TelaPrincipal().setVisible(true);
            this.dispose();
        });
    }
}
