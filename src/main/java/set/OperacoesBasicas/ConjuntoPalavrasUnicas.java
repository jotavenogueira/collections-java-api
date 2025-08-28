package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavras(String palavra) {
        palavrasUnicasSet.add(palavra);
    }
    public void removerPalavra(String palavra){
        if(!palavrasUnicasSet.isEmpty()){
            if(palavrasUnicasSet.contains(palavra)){
                palavrasUnicasSet.remove(palavra);
            }else System.out.println("Palavra não contida no conjunto!");
        } else System.out.println("Conjunto vazio!");
    }
    public String verificarPalavra(String palavra){
        if(!palavrasUnicasSet.isEmpty()){
            if(palavrasUnicasSet.contains(palavra)){
                return "A palavra está contida no conjunto";
            }else return "A palavra não está contida no conjunto";
        } else
            throw new RuntimeException("O conjunto está vazio");
    }

    public void exibirPalavrasUnicas(){
       if(!palavrasUnicasSet.isEmpty()){
           System.out.println(this.palavrasUnicasSet);
       } else
           System.out.println("Conjunto vazio");

    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavrasUnicas = new ConjuntoPalavrasUnicas();
        Scanner ler = new Scanner(System.in);
        int aux;

        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar palavra");
            System.out.println("2- Remover palavra");
            System.out.println("3- Verificar palavra");
            System.out.println("4- Exibir palavras");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    ler.nextLine();
                    System.out.println("Escreva a palavra que voce deseja adicionar: ");
                    palavrasUnicas.adicionarPalavras(ler.nextLine());
                    break;
                case 2:
                    ler.nextLine();
                    System.out.println("Escreva a palavra que você deseja remover: ");
                    palavrasUnicas.removerPalavra(ler.nextLine());
                    break;
                case 3:
                    ler.nextLine();
                    System.out.println(palavrasUnicas.verificarPalavra(ler.nextLine()));
                    break;
                case 4:
                    palavrasUnicas.exibirPalavrasUnicas();
                    break;


                case 0:
                    break;

            }
        }while (aux != 0);
    }
}
