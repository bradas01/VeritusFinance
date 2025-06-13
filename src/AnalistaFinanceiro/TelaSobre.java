package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaSobre extends JFrame {

    public TelaSobre() {
        super("Sobre o Software");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        this.add(TelaPrincipal.createHeaderPanel("Sobre"), BorderLayout.NORTH);

        JEditorPane areaTexto = new JEditorPane();
        areaTexto.setContentType("text/html");
        areaTexto.setEditable(false);
        areaTexto.setOpaque(false);
        areaTexto.setForeground(Color.LIGHT_GRAY);
        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaTexto.setText(
                "<html>" +
                        "<body style='font-family: Segoe UI; font-size: 14px; color: #DDDDDD; background-color: #1e1e1e; padding: 20px;'>" +
                        "<h2>Analista Financeiro v1.0</h2>" +
                        "<p>Desenvolvido como projeto para o 2º Bimestre.</p>" +
                        "<p><strong>Autores:</strong><br>" +
                        "Enzo Bradaschia<br>" +
                        "Enzo Linaldi<br>" +
                        "Guilherme Gomes</p>" +
                        "<p>Senac 2025</p>" +
                        "</body></html>"
        );

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBackground(new Color(30, 30, 30));
        painelCentral.add(areaTexto, BorderLayout.CENTER);
        this.add(painelCentral, BorderLayout.CENTER);

        JButton btnOk = new JButton("OK");
        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(30, 30, 30));
        painelBotao.add(btnOk);
        this.add(painelBotao, BorderLayout.SOUTH);
        btnOk.addActionListener(e -> dispose());
    }
}
