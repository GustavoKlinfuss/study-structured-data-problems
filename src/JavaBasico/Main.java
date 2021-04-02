package JavaBasico;

public class Main {
    public static void main(String[] args) {
        // TESTE PAISES
        Pais brasil = new Pais("BRA", "Brasil", 8000000);
        Pais venezuela = new Pais("VNZ", "Venezuela", 8000000);
        Pais chile = new Pais("CHL", "Chile", 8000000);
        Pais argentina = new Pais("ARG", "Argentina", 8000000);
        Pais uruguai = new Pais("URU", "Uruguai", 8000000);
        Pais paraguai = new Pais("PAR", "Paraguai", 8000000);

        chile.setNome("República do chile");
        chile.setCodigoIso("CHI");
        chile.setDimensao(4000000);
        chile.setPopulacao(25000000);
        Pais[] fronteirasChile = new Pais []{argentina, paraguai};
        chile.setFronteiras(fronteirasChile);

        chile.printInfo();

        Pais[] fronteirasBrasil = new Pais[] {argentina, uruguai, paraguai, venezuela};
        Pais[] fronteirasArgentina = new Pais[] {chile, uruguai, paraguai};

        brasil.setFronteiras(fronteirasBrasil);
        argentina.setFronteiras(fronteirasArgentina);

        Pais[] vizinhosComuns = brasil.getVizinhosComuns(argentina);

        System.out.println("Os países que são vizinhos do Brasil e da Argentina são:");
        for (Pais vizinhoComum: vizinhosComuns) {
            System.out.println(" - " + vizinhoComum.getNome() + " (" + vizinhoComum.getCodigoIso() + ")");
        }

        // TESTE CONTINENTES

        Continente america = new Continente("América do Sul");

        america.adicionarPais(brasil);
        america.adicionarPais(argentina);
        america.adicionarPais(chile);

        System.out.println(america.getNome());
        System.out.println("Dimensão: " + america.getDimensao());
        System.out.println("População: " + america.getPopulacao());
        System.out.println("Densidade Populacional: " + america.getDensidadePopulacao());
        System.out.println("Pais mais populoso: " + america.getMaisPopuloso().getNome());
        System.out.println("Pais menos populoso: " + america.getMenosPopuloso().getNome());
        System.out.println("Maior país: " + america.getMaiorPais().getNome());
        System.out.println("Menor país: " + america.getMenorPais().getNome());
        System.out.println("Razão terrirorial entre maior e menor país: " + america.getRazaoMaiorMenor());
    }
}
