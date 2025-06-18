# 💰 Analista Financeiro

Aplicação Java desktop desenvolvida com **Java Swing** para gerenciamento de despesas pessoais. O sistema permite cadastrar categorias, adicionar despesas, definir metas mensais, visualizar dashboards e gerar relatórios com visual moderno em HTML.

---

## 🖥️ Funcionalidades

* 📊 **Dashboard**: Resumo visual das finanças pessoais.
* 📝 **Adicionar & Editar Despesas**: Campos para descrição, valor, data e categoria.
* 📁 **Gerenciamento de Categorias**: Criação e seleção personalizadas.
* 🗂️ **Visualização de Despesas em HTML**: Interface estilizada com tabela responsiva.
* 🎯 **Definir Orçamento Mensal**: Estabeleça uma meta de gastos.
* 🔔 **Configurações**: Ativação de notificações de resumo.
* ❓ **Ajuda**: Guia introdutório para uso da aplicação.

---

## 📂 Estrutura do Projeto

```
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
```

---

## 🔧 Tecnologias Utilizadas

* **Java SE 8+**
* **Java Swing** (JFrame, JPanel, GridBagLayout, etc.)
* **JEditorPane + HTML/CSS inline** para visualização
* **Stream API & Collections** (List, forEach, map, collect)

---

## ▶️ Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/analista-financeiro.git
   ```

2. Importe o projeto em sua IDE favorita (ex: IntelliJ IDEA, Eclipse).

3. Compile e execute a classe `TelaPrincipal.java`.

---

## 🧠 Sugestões Futuras

* Exportação de relatórios em PDF
* Persistência em banco de dados local (SQLite, H2)
* Login de usuários com diferentes perfis
* Alternância entre temas claro e escuro
* Backup automático

---

## 👤 Autor

**Enzo Bradaschia**
> Projeto desenvolvido como ferramenta de apoio à organização financeira pessoal, com foco em clareza visual, simplicidade de uso e boa arquitetura de código.

---

