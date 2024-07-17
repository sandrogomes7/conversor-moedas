package principal;

import java.io.IOException;
import java.util.Scanner;

import modelos.GerarConversao;
import modelos.HistoricoConversoes;
import modelos.Menu;

public class Principal {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Menu.exibir();

            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            if (opcao == 10) {
                System.out.println("Saindo...");
                break;
            } else if (opcao < 1 || opcao > 10) {
                System.out.println("\nOpção inválida!");
                continue;
            }

            GerarConversao conversao;
            switch (opcao) {
                case 1:
                    conversao = new GerarConversao("USD", "BRL");
                    conversao.imprimirConversao();
                    break;
                case 2:
                    conversao = new GerarConversao("BRL", "USD");
                    conversao.imprimirConversao();
                    break;
                case 3:
                    conversao = new GerarConversao("EUR", "BRL");
                    conversao.imprimirConversao();
                    break;
                case 4:
                    conversao = new GerarConversao("BRL", "EUR");
                    conversao.imprimirConversao();
                    break;
                case 5:
                    conversao = new GerarConversao("KRW", "BRL");
                    conversao.imprimirConversao();
                    break;
                case 6:
                    conversao = new GerarConversao("BRL", "KRW");
                    conversao.imprimirConversao();
                    break;
                case 7:
                    conversao = new GerarConversao("ARS", "BRL");
                    conversao.imprimirConversao();
                    break;
                case 8:
                    conversao = new GerarConversao("BRL", "ARS");
                    conversao.imprimirConversao();
                    break;
                case 9:
                    HistoricoConversoes.exibirHistorico();
                    break;
            }
            System.out.println();
        }
        sc.close();
    }
}
