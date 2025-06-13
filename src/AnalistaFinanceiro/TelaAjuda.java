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
        this.getContentPane().setBackground(new Color(30, 30, 30)); // fundo escuro

        this.add(TelaPrincipal.createHeaderPanel("Ajuda"), BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setOpaque(false);
        areaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(15, 15, 15, 15));
        areaTexto.setForeground(Color.WHITE);  // texto claro para contraste
        areaTexto.setText(
                "1. Gerenciar Categorias: Antes de tudo, crie as categorias de seus gastos (Ex: 'Comida', 'Transporte').\n\n" +
                        "2. Adicionar Despesa: Vá em 'Adicionar Nova Despesa', preencha os detalhes e selecione a categoria correspondente.\n\n" +
                        "3. Visualizar Despesas: Nesta tela, você pode ver todas as suas despesas, além de editar ou excluir um registro selecionado.\n\n" +
                        "4. Dashboard: Tenha uma visão rápida e resumida de suas finanças.\n\n" +
                        "5. Relatório: Gere um relatório completo e detalhado de todos os seus gastos."
        );

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBackground(new Color(30, 30, 30));
        painelCentral.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        this.add(painelCentral, BorderLayout.CENTER);
    }
}
