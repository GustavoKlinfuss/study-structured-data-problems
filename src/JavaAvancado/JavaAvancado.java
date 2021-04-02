package JavaAvancado;

public class JavaAvancado {
    public static void main(String[] args) {
        Data dt = new Data(2, 10, 1997);
        dt.definirFormato("dd/mm/aa");
        dt.imprimir();


        Data dt2 = new Data(14, 12, 1998);
        dt2.imprimir();
    }
}
