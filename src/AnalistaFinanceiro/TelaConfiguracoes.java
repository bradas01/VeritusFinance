package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaConfiguracoes extends JFrame {

    private JCheckBox checkNotificacoes;
    private Configuracoes configs;

    public TelaConfiguracoes() {
        super("Configurações");
        this.configs = Configuracoes.getInstance();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Configurações"), BorderLayout.NORTH);

        JPanel painelConteudo = new JPanel(new GridBagLayout());
        painelConteudo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();

        try {
            gbc.gridy = 0; gbc.insets = new Insets(5,5,15,5);
            painelConteudo.add(new JLabel(new ImageIcon(getClass().getResource("/imagens/config_banner.png"))), gbc);
        } catch (Exception e) {}

        gbc.gridy = 1;
        checkNotificacoes = new JCheckBox("Ativar notificações de resumo diário");
        checkNotificacoes.setFont(new Font("Arial", Font.PLAIN, 14));
        checkNotificacoes.setHorizontalAlignment(SwingConstants.CENTER);
        checkNotificacoes.setSelected(configs.isNotificacoesAtivadas());

        painelConteudo.add(checkNotificacoes, gbc);

        this.add(painelConteudo, BorderLayout.CENTER);

        JButton btnSalvar = new JButton("Salvar Configurações");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel painelBotao = new JPanel();
        painelBotao.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        painelBotao.add(btnSalvar);
        this.add(painelBotao, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvarConfiguracoes());
    }

    private void salvarConfiguracoes() {
        boolean novoEstado = checkNotificacoes.isSelected();
        configs.setNotificacoesAtivadas(novoEstado);

        String feedback = novoEstado ? "Notificações ativadas." : "Notificações desativadas.";
        JOptionPane.showMessageDialog(this, "Configurações salvas! " + feedback);
        this.dispose();
    }
}
