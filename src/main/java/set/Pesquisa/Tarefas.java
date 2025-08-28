package main.java.set.Pesquisa;

public class Tarefas {
    private String descricao;
    private boolean concluida;

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "descricao='" + descricao + '\'' +
                ", concluida=" + concluida +
                '}';
    }

    public Tarefas(String descricao) {
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
