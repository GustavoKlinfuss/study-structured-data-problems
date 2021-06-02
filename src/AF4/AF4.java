package AF4;

public class AF4 {
    public static void main(String[] args) {
        int[] dados = new int[]{0, 4, 5, 8, 10, 15, 37};

        int a = buscaBinaria(dados, 0, 0, dados.length-1);
        int b = buscaBinaria(dados, 4, 0, dados.length-1);
        int c = buscaBinaria(dados, 5, 0, dados.length-1);
        int d = buscaBinaria(dados, 8, 0, dados.length-1);
        int e = buscaBinaria(dados, 10, 0, dados.length-1);
        int f = buscaBinaria(dados, 15, 0, dados.length-1);
        int g = buscaBinaria(dados, 37, 0, dados.length-1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }

    public static int buscaBinaria(int[] dados, int x, int indexInicio, int indexFim) {
        int indexMetade = (indexFim-indexInicio)/2 + indexInicio;

        if(dados.length == 1 && dados[0] == x)
            return indexInicio;
        if(x == dados[indexMetade])
            return indexMetade;
        if(dados[indexMetade] > x)
            return buscaBinaria(dados, x, indexInicio, indexMetade);
        return buscaBinaria(dados, x, indexMetade+1, indexFim);
    }
}
