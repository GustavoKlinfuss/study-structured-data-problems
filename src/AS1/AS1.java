package AS1;

public class AS1 {
    public static void main(String[] args) throws Exception {
        PilhaDinamica p = new PilhaDinamica();
        p.empilha(5);
        p.empilha(4);
        p.empilha(3);

        p.imprimePilha();

        int d1 = p.desempilha();
        int d2 = p.desempilha();

        System.out.println(" Desempilhado 1: " + d1);
        System.out.println(" Desempilhado 2: " + d2);

        ValidadorDeExpressoesDinamico ev = new ValidadorDeExpressoesDinamico();

        String exp1 = "({1-2) + 3}";
        String exp2 = "{(8+[5*3] )-10}";
        String exp3 = "(5(5*4[6-1]))";
        String exp4 = "((5[5*4[6-1]))*10)";
        String exp5 = "{{3*(2+5)}";
        String exp6 = "}";

        boolean ev1 = ev.validarExpressao(exp1);
        boolean ev2 = ev.validarExpressao(exp2);
        boolean ev3 = ev.validarExpressao(exp3);
        boolean ev4 = ev.validarExpressao(exp4);
        boolean ev5 = ev.validarExpressao(exp5);
        boolean ev6 = ev.validarExpressao(exp6);

        System.out.println(exp1 + "  ->  " + ev1);
        System.out.println(exp2 + "  ->  " + ev2);
        System.out.println(exp3 + "  ->  " + ev3);
        System.out.println(exp4 + "  ->  " + ev4);
        System.out.println(exp5 + "  ->  " + ev5);
        System.out.println(exp6 + "  ->  " + ev6);


        System.out.println("-------------# Fila #-------------");
        FilaDinamica f = new FilaDinamica();

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
        var m = new MergeDinamico();

        var a = new FilaDinamica();
        var b = new FilaDinamica();

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

        FilaDinamica c = m.mergeDeFilasOrdenadas(a, b);
        System.out.print("Fila c: ");
        c.imprime();
    }

    private static void imprimirRemovido(int removido) {
        System.out.println(" Removido: | " + removido + " |");
    }

}
