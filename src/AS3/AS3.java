package AS3;

import java.util.Random;
import java.util.Scanner;

public class AS3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tamanho da tabela: ");
        int tamanhoDaTabela = sc.nextInt();
        TabelaHash tabela = new TabelaHash(tamanhoDaTabela);

        tabela.popular();
        System.out.println();

        tabela.imprimir();
        System.out.println();

        System.out.println("Colisões: " + tabela.getColisoes());

        System.out.print("Digite um elemento: ");
        int elementoUsuario = sc.nextInt();
        while(elementoUsuario != -1)
        {
            var existe = tabela.busca(elementoUsuario);
            if(existe)
                System.out.println("Existe");
            else
                System.out.println("Não existe");

            System.out.print("Digite um elemento: ");
            elementoUsuario = sc.nextInt();
        }
    }
}
