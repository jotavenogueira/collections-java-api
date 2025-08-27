package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("Lista de itens vazia!");
        }
    }

    public double calcularValorTotal() {
        double total = 0d;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                double valorItem = i.getPreco() * i.getQuantidade();
                total += valorItem;
            }
            return total;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(this.itemList);
            } else {
            System.out.println("Lista de itens vazia");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Scanner ler = new Scanner(System.in);
        int aux;
        do{
            System.out.println("===================");
            System.out.println("Escolha a sua opção:");
            System.out.println("1- Adicionar Item");
            System.out.println("2- Remover Item");
            System.out.println("3- Consultar total");
            System.out.println("4- Exibir itens");
            System.out.println("0- Sair");
            aux = ler.nextInt();

            switch (aux){
                case 1:
                    ler.nextLine();
                    System.out.println("Escreva o nome, preço e quantidade do item que voce deseja adicionar: ");
                    var nome = ler.nextLine();
                    var preco = ler.nextDouble();
                    var quantidade = ler.nextInt();
                    carrinhoDeCompras.adicionarItem(nome, preco, quantidade);
                    break;
                case 2:
                    ler.nextLine();
                    System.out.println("Escreva o nome do item que você deseja remover: ");
                    carrinhoDeCompras.removerItem(ler.nextLine());
                    break;
                case 3:
                    System.out.printf("O total do seu carrinho é: R$%.2f\n", carrinhoDeCompras.calcularValorTotal());
                    break;
                case 4:
                    carrinhoDeCompras.exibirItens();
                case 0:
                    break;

            }
        }while (aux != 0);
    }
}
