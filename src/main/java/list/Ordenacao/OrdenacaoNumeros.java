package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoNumeros {
    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public List<Integer> getListaNumeros() {
        return listaNumeros;
    }

    @Override
    public String toString() {
        return "OrdenacaoNumeros{" +
                "listaNumeros=" + listaNumeros +
                '}';
    }

    public void adicionarNumero(int numero){
        this.listaNumeros.add(numero);

    }
    public List<Integer> ordenarAscendente() {
    List<Integer> ordemAscendente = new ArrayList<>(this.listaNumeros);
    if(!this.listaNumeros.isEmpty()){
        Collections.sort(ordemAscendente);
        return ordemAscendente;
    } else {
        throw new RuntimeException("Lista vazia!");
    }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> ordemAscendente = new ArrayList<>(this.listaNumeros);
        if(!this.listaNumeros.isEmpty()){
            ordemAscendente.sort(Collections.reverseOrder());
            return ordemAscendente;
        } else {
            throw new RuntimeException("Lista vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros listaNum = new OrdenacaoNumeros();
        Scanner ler = new Scanner(System.in);
        int aux;

        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar número");
            System.out.println("2- Ordenar Ascendente");
            System.out.println("3- Ordenar Descendente");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    System.out.println("Escreva o número que voce deseja adicionar: ");
                    listaNum.adicionarNumero(ler.nextInt());
                    break;
                case 2:
                    System.out.println(listaNum.ordenarAscendente());
                    break;
                case 3:
                    System.out.println(listaNum.ordenarDescendente());
                    break;
                case 0:
                    break;

            }
        }while (aux != 0);

    }
}
