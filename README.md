# 💰 Analista Financeiro

Aplicação Java desktop desenvolvida com **Java Swing** para gerenciamento de despesas pessoais. O sistema permite cadastrar categorias, adicionar despesas, definir metas mensais, visualizar dashboards e gerar relatórios em HTML estilizados.

## 🖼️ Visão Geral

O **Analista Financeiro** oferece uma interface amigável para o controle financeiro pessoal com funcionalidades essenciais como:

- Cadastro e edição de despesas
- Gerenciamento de categorias
- Visualização de despesas em tabelas HTML integradas
- Dashboard com resumos e insights
- Definição de metas mensais
- Configurações e preferências
- Tela de ajuda com orientações básicas

## 📦 Estrutura do Projeto

```bash
src/
└── AnalistaFinanceiro/
    ├── TelaPrincipal.java
    ├── TelaAdicionarDespesa.java
    ├── TelaEditarDespesa.java
    ├── TelaVisualizarDespesas.java
    ├── TelaDashboard.java
    ├── TelaOrcamento.java
    ├── TelaConfiguracoes.java
    ├── TelaAjuda.java
    ├── Categoria.java
    ├── Despesa.java
    └── Configuracoes.java
✅ Funcionalidades
📊 Dashboard: Visualização de totais, quantidade de despesas e categoria mais onerosa.

📝 Adição e edição de despesas com campos para descrição, valor, data e categoria.

📆 Visualização HTML das despesas com data formatada e estilo escuro.

📁 Categorias: Totalmente gerenciáveis pelo usuário.

⚙️ Configurações: Habilitar/desabilitar notificações de resumo.

🧾 Ajuda: Guia para primeiros passos e uso da aplicação.

🧪 Tecnologias Utilizadas
Java SE 8+

Java Swing

HTML para visualização de dados

Padrão de Projeto Singleton (para Configuracoes)

Collections (List, Map, Stream API)

📸 Capturas de Tela
(Você pode adicionar aqui imagens da interface, como dashboard, editor de despesas, etc.)

🚀 Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/analista-financeiro.git
Importe o projeto em sua IDE (ex: IntelliJ IDEA ou Eclipse).

Compile e execute a classe TelaPrincipal.java.

💡 Sugestões Futuras
Exportação de relatórios em PDF

Armazenamento em arquivo local ou banco de dados

Sincronização com nuvem (ex: Google Drive)

Dark/Light Theme toggle

👨‍💻 Autor
Enzo Bradaschia
Desenvolvido como projeto de controle financeiro pessoal com foco em UX e boas práticas de interface.
