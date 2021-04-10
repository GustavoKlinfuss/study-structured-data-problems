package AF2;

public class AF2 {
    public static void main(String[] args) throws Exception {
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
        f.insere(2);
        f.insere(2);
        f.remove();
        f.remove();
        f.remove();
        f.remove();
        f.remove();
        f.remove();
        f.insere(2);
        f.insere(2);
        f.insere(3);
        f.insere(2);
        f.insere(2);
        f.insere(2);
        f.imprime();

        f.remove();
        f.remove();
        f.remove();
    }

    private static void imprimirRemovido(int removido) throws Exception {
        System.out.println(" Removido: | " + removido + " |");
    }
}
