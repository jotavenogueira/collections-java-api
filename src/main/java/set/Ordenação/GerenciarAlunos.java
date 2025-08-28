package main.java.set.Ordenação;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciarAlunos {
    private Set<Aluno> alunosSet;

    public GerenciarAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public Set<Aluno> getGerenciarAlunosSet() {
        return alunosSet;
    }

    @Override
    public String toString() {
        return "GerenciarAlunos{" +
                "gerenciarAlunosSet=" + alunosSet +
                '}';
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        this.alunosSet.add(new Aluno(nome, matricula, media));
    }
    public void removerAluno(Long matricula){
        Aluno alunoParaRemover = null;
        if (!alunosSet.isEmpty()) {
            for (Aluno a : alunosSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunosSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }

    }

    public void exibirPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
        if(!alunosSet.isEmpty()){
            System.out.println(alunosPorNome);
        } else {
            System.out.println("O conjunto está vazio");
        }
    }
    public void exibirPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
        if (!alunosSet.isEmpty()) {
            alunosPorNota.addAll(alunosSet);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        GerenciarAlunos gerenciadorAlunos = new GerenciarAlunos();
        Scanner ler = new Scanner(System.in);
        int aux;

        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar aluno");
            System.out.println("2- Remover aluno");
            System.out.println("3- Ordenar por nome");
            System.out.println("4- Ordenar por nota");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    ler.nextLine();
                    System.out.println("Escreva o nome, matricula e média do aluno que voce deseja adicionar: ");
                    String nome = ler.nextLine();
                    Long matricula = ler.nextLong();
                    double media = ler.nextDouble();
                    gerenciadorAlunos.adicionarAluno(nome,matricula,media);
                    break;
                case 2:
                    ler.nextLine();
                    System.out.println("Escreva a matricula do aluno que você deseja remover: ");
                    gerenciadorAlunos.removerAluno(ler.nextLong());
                    break;
                case 3:
                    gerenciadorAlunos.exibirPorNome();
                    break;
                case 4:
                    gerenciadorAlunos.exibirPorNota();
                    break;
                case 0:
                    break;

            }
        }while (aux != 0);
    }
 }
