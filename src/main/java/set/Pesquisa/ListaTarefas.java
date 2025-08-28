package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefas> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public Set<Tarefas> getTarefasSet() {
        return tarefasSet;
    }

    @Override
    public String toString() {
        return "ListaTarefas{" +
                "tarefasSet=" + tarefasSet +
                '}';
    }

    public void adicionarTarefa(String descricao){
        this.tarefasSet.add(new Tarefas(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefas tarefaParaRemover = null;
        if (!tarefasSet.isEmpty()) {
            for (Tarefas t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefasSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas(){
        if(!tarefasSet.isEmpty()){
            System.out.println(tarefasSet);
        } else
            System.out.println("Sem tarefas!");
    }

    public int contarTarefas(){
        return tarefasSet.size();
    }

    public Set<Tarefas> obterTarefasConcluidas(){
        Set<Tarefas> tarefasConcluidas = new HashSet<>();
        for(Tarefas t: tarefasSet){
            if(t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefas> obterTarefasPendentes(){
        Set<Tarefas> tarefasPendentes = new HashSet<>();
        for (Tarefas t : tarefasSet){
            if(!t.isConcluida()){
                tarefasPendentes.add(t);
            }
        } return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
    if(!tarefasSet.isEmpty()){
        for (Tarefas t : tarefasSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
                System.out.println("Tarefa marcada como concluida com sucesso!");
            }
        }
    } else System.out.println("Sem tarefas");
    }

    public void marcarTarefaPendente(String descricao){
        if(!tarefasSet.isEmpty()){
            for (Tarefas t : tarefasSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(false);
                    System.out.println("Tarefa marcada como pendente com sucesso!");
                }
            }
        } else System.out.println("Sem tarefas");
    }

    public void limparTarefas(){
        tarefasSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        Scanner ler = new Scanner(System.in);
        int aux;

        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar tarefa");
            System.out.println("2- Remover tarefa");
            System.out.println("3- Exibir tarefas");
            System.out.println("4- Contar tarefas");
            System.out.println("5- Ver tarefas concluidas");
            System.out.println("6- Ver tarefas pendentes");
            System.out.println("7- Marcar tarefa concluida");
            System.out.println("8- Marcar tarefa pendente");
            System.out.println("9- Limpar tarefas");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    ler.nextLine();
                    System.out.println("Escreva a tarefa que voce deseja adicionar: ");
                    String descricao = ler.nextLine();
                    listaTarefas.adicionarTarefa(descricao);
                    break;
                case 2:
                    ler.nextLine();
                    System.out.println("Escreva a tarefa que você deseja remover: ");
                    descricao = ler.nextLine();
                    listaTarefas.removerTarefa(descricao);
                    break;
                case 3:
                    listaTarefas.exibirTarefas();
                    break;
                case 4:
                    System.out.println(listaTarefas.contarTarefas());
                    break;
                case 5:
                    System.out.println(listaTarefas.obterTarefasConcluidas());
                    break;
                case 6:
                    System.out.println(listaTarefas.obterTarefasPendentes());
                    break;
                case 7:
                    ler.nextLine();
                    System.out.println("Escreva a tarefa que você deseja marcar como concluida: ");
                    descricao = ler.nextLine();
                    listaTarefas.marcarTarefaConcluida(descricao);
                    break;
                case 8:
                    ler.nextLine();
                    System.out.println("Escreva a tarefa que você deseja marcar como pendente: ");
                    descricao = ler.nextLine();
                    listaTarefas.marcarTarefaPendente(descricao);
                    break;
                case 9:
                    listaTarefas.limparTarefas();
                    break;
                case 0:
                    break;

            }
        }while (aux != 0);
    }
}
