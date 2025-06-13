package AnalistaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TelaPrincipal extends JFrame {

    public static ArrayList<Categoria> listaDeCategorias = new ArrayList<>();
    public static ArrayList<Despesa> listaDeDespesas = new ArrayList<>();

    public TelaPrincipal() {
        super("Analista Financeiro - Principal");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(44, 47, 51));

        // Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(35, 39, 42));
        menuBar.setForeground(Color.WHITE);

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSair = new JMenuItem("Sair");
        JMenuItem itemSobre = new JMenuItem("Sobre");

        menuArquivo.add(itemSair);
        menuAjuda.add(itemSobre);
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        this.setJMenuBar(menuBar);

        JPanel painelTitulo = createHeaderPanel("Menu Principal");
        this.add(painelTitulo, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(4, 2, 20, 20));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));
        painelBotoes.setOpaque(false);

        // Botões sem ícones
        JButton btnAdicionarDespesa = createStyledButton("Adicionar Despesa");
        JButton btnVisualizarDespesas = createStyledButton("Visualizar Despesas");
        JButton btnGerenciarCategorias = createStyledButton("Gerenciar Categorias");
        JButton btnDashboard = createStyledButton("Dashboard Resumo");
        JButton btnRelatorio = createStyledButton("Gerar Relatório");
        JButton btnOrcamento = createStyledButton("Definir Orçamento");
        JButton btnConfig = createStyledButton("Configurações");
        JButton btnAjudaTela = createStyledButton("Ajuda do Sistema");

        painelBotoes.add(btnAdicionarDespesa);
        painelBotoes.add(btnVisualizarDespesas);
        painelBotoes.add(btnGerenciarCategorias);
        painelBotoes.add(btnDashboard);
        painelBotoes.add(btnRelatorio);
        painelBotoes.add(btnOrcamento);
        painelBotoes.add(btnConfig);
        painelBotoes.add(btnAjudaTela);

        this.add(painelBotoes, BorderLayout.CENTER);

        JPanel painelImagemSul = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelImagemSul.setOpaque(false);
        painelImagemSul.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        this.add(painelImagemSul, BorderLayout.SOUTH);

        // Ações
        btnAdicionarDespesa.addActionListener(e -> new TelaAdicionarDespesa().setVisible(true));
        btnVisualizarDespesas.addActionListener(e -> new TelaVisualizarDespesas().setVisible(true));
        btnGerenciarCategorias.addActionListener(e -> new TelaGerenciarCategorias().setVisible(true));
        btnDashboard.addActionListener(e -> new TelaDashboard().setVisible(true));
        btnRelatorio.addActionListener(e -> new TelaRelatorio().setVisible(true));
        btnOrcamento.addActionListener(e -> new TelaOrcamento().setVisible(true));
        btnConfig.addActionListener(e -> new TelaConfiguracoes().setVisible(true));
        btnAjudaTela.addActionListener(e -> new TelaAjuda().setVisible(true));
        itemSair.addActionListener(e -> System.exit(0));
        itemSobre.addActionListener(e -> new TelaSobre().setVisible(true));
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(114, 137, 218));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(88, 101, 242), 1),
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(153, 170, 181));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(114, 137, 218));
            }
        });

        return button;
    }

    public static JPanel createHeaderPanel(String title) {
        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        painelTitulo.setBackground(new Color(35, 39, 42));
        painelTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(88, 101, 242)));

        try {
            ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/imagens/logo.png"));
            Image imagem = icone.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            painelTitulo.add(new JLabel(new ImageIcon(imagem)));
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: /imagens/logo.png");
        }

        JLabel lblTitulo = new JLabel(title);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        painelTitulo.add(lblTitulo);

        return painelTitulo;
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        if (listaDeCategorias.isEmpty()) {
            listaDeCategorias.add(new Categoria("Alimentação"));
            listaDeCategorias.add(new Categoria("Transporte"));
            listaDeCategorias.add(new Categoria("Moradia"));
            listaDeDespesas.add(new Despesa("Almoço", 25.50, new Date(), listaDeCategorias.get(0)));
            listaDeDespesas.add(new Despesa("Gasolina", 150.00, new Date(), listaDeCategorias.get(1)));
        }

        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
