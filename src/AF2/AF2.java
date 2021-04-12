package AF2;

public class AF2 {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------# Fila #-------------");
        Fila f = new Fila(7);

        f.insere(1);
        f.insere(6);
        imprimirRemovido(f.remove());
        f.insere(3);
        f.insere(1);
        f.insere(4);
        f.insere(1);
        f.imprime();

        f.insere(1);
        f.insere(3);
        imprimirRemovido(f.remove());

        f.insere(-342);
        f.imprime();

        f.remove();
        f.remove();
        f.imprime();

        f.insere(0);
        f.insere(0);
        f.remove();
        f.remove();
        f.remove();
        f.imprime();

        f.insere(2);
        f.remove();
        f.insere(2);
        f.imprime();

        f.remove();
        f.remove();
        f.remove();

        // MERGE
        System.out.println("-------------# Merge #-------------");
        var m = new Merge();

        var a = new Fila(20);
        var b = new Fila(20);

        a.insere(12);
        a.insere(35);
        a.insere(52);
        a.insere(64);
        b.insere(5);
        b.insere(15);
        b.insere(23);
        b.insere(55);
        b.insere(75);

        System.out.print("Fila a: ");
        a.imprime();
        System.out.print("Fila b: ");
        b.imprime();

        Fila c = m.mergeDeFilasOrdenadas(a, b);
        System.out.print("Fila c: ");
        c.imprime();
    }

    private static void imprimirRemovido(int removido) {
        System.out.println(" Removido: | " + removido + " |");
    }
}
