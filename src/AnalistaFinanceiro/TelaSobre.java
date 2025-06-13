package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaSobre extends JFrame {

    public TelaSobre() {
        super("Sobre o Software");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        this.add(TelaPrincipal.createHeaderPanel("Sobre"), BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setOpaque(false);
        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(20, 20, 20, 20));
        areaTexto.setText(
                "Analista Financeiro v1.0\n\n" +
                        "Desenvolvido como projeto para o 2º Bimestre.\n\n" +
                        "Autores:\n" +
                        "[Nome do Integrante 1]\n" +
                        "[Nome do Integrante 2]\n" +
                        "[etc...]\n\n" +
                        "Senac 2025"
        );

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(areaTexto, BorderLayout.CENTER);
        try {
            painelCentral.add(new JLabel(new ImageIcon(getClass().getResource("/imagens/sobre_banner.png"))), BorderLayout.SOUTH);
        } catch (Exception e) {}
        this.add(painelCentral, BorderLayout.CENTER);

        JButton btnOk = new JButton("OK");
        JPanel painelBotao = new JPanel();
        painelBotao.add(btnOk);
        this.add(painelBotao, BorderLayout.SOUTH);
        btnOk.addActionListener(e -> dispose());
    }
}
