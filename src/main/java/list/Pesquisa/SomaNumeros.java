package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros(  ) {
        this.numeros = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "SomaNumeros{" +
                "numeros=" + numeros +
                '}';
    }

    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        if(!numeros.isEmpty()){
            for(Integer n : numeros){
                soma += n;
            }
            return soma;
        } else {
            throw new RuntimeException ("Lista de numeros vazia!");
        }
    }
    public int encontrarMaior(){
        int maior = Integer.MIN_VALUE;
        if(!numeros.isEmpty()){
            for(Integer n : numeros){
                if(maior <= n)
                    maior = n;
            }
            return maior;
        } else
            throw new RuntimeException("Lista de números vazia!");
    }

    public int encontrarMenor(){
        int menor = Integer.MAX_VALUE;
        if(!numeros.isEmpty()){
            for(Integer n : numeros){
                if(menor >= n)
                    menor = n;
            }
            return menor;
        } else
            throw new RuntimeException("Lista de números vazia!");
    }

    public void exibirNumeros(){
        if(!numeros.isEmpty()) {
            System.out.println(this.numeros);
        } else
            System.out.println("Lista de números vazia!");
    }


    public static void main(String[] args) {
        SomaNumeros listaNum = new SomaNumeros();
        Scanner ler = new Scanner(System.in);

        int aux;
        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar número");
            System.out.println("2- Calcular soma");
            System.out.println("3- Encontrar maior número");
            System.out.println("4- Encontrar menor número");
            System.out.println("5- Exibir números");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    ler.nextLine();
                    System.out.println("Escreva o número que voce deseja adicionar: ");
                    listaNum.adicionarNumero(ler.nextInt());
                    break;
                case 2:
                    System.out.printf("O total dos elementos da lista é; %d\n",listaNum.calcularSoma());
                    break;
                case 3:
                    System.out.println("O maior número é: " + listaNum.encontrarMaior());
                    break;
                case 4:
                    System.out.println("O menor número é: " + listaNum.encontrarMenor());
                case 5:
                    listaNum.exibirNumeros();
                    break;
                case 0:
                    break;

            }
        }while (aux != 0);

    }
}
