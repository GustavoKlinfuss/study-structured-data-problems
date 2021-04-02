package AF1;

public class AF1 {
    public static void main(String[] args) throws Exception {
        Pilha p = new Pilha(3);
        p.empilha(5);
        p.empilha(4);
        p.empilha(3);

        int d1 = p.desempilha();
        int d2 = p.desempilha();
        int topo = p.topo();

        System.out.println(" Desempilhado 1: " + d1);
        System.out.println(" Desempilhado 2: " + d2);
        System.out.println(" Topo: " + topo);

        Expressao ev = new Expressao();

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
    }
}
