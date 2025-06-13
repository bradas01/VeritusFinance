package AnalistaFinanceiro;

public class Configuracoes {

    private boolean notificacoesAtivadas;
    private static final Configuracoes instance = new Configuracoes();

    private Configuracoes() {
        this.notificacoesAtivadas = true;
    }

    public static Configuracoes getInstance() {
        return instance;
    }

    public boolean isNotificacoesAtivadas() {
        return notificacoesAtivadas;
    }

    public void setNotificacoesAtivadas(boolean notificacoesAtivadas) {
        this.notificacoesAtivadas = notificacoesAtivadas;
    }
}
