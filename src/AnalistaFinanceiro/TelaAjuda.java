package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaAjuda extends JFrame {

    public TelaAjuda() {
        super("Ajuda");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(TelaPrincipal.createHeaderPanel("Ajuda"), BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(15, 15, 15, 15));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setBackground(new Color(45, 45, 45));
        areaTexto.setOpaque(true);

        areaTexto.setText(
                "1. Gerenciar Categorias: Antes de tudo, crie as categorias de seus gastos (Ex: 'Comida', 'Transporte').\n\n" +
                        "2. Adicionar Despesa: Vá em 'Adicionar Nova Despesa', preencha os detalhes e selecione a categoria correspondente.\n\n" +
                        "3. Visualizar Despesas: Nesta tela, você pode ver todas as suas despesas, além de editar ou excluir um registro selecionado.\n\n" +
                        "4. Dashboard: Tenha uma visão rápida e resumida de suas finanças.\n\n" +
                        "5. Relatório: Gere um relatório completo e detalhado de todos os seus gastos."
        );

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.getViewport().setBackground(new Color(45, 45, 45));

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(scroll, BorderLayout.CENTER);

        try {
            painelCentral.add(new JLabel(new ImageIcon(getClass().getResource("/imagens/help_banner.png"))), BorderLayout.SOUTH);
        } catch (Exception e) {
            // Caso a imagem não seja encontrada, simplesmente ignora
        }

        this.add(painelCentral, BorderLayout.CENTER);
    }
}
