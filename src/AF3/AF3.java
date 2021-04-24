package AF3;

public class AF3 {
    public static void main(String[] args) throws Exception {
        ListaEncadeada lista = new ListaEncadeada();

        System.out.println("########  Lista Encadeada  #######");
        lista.insereUltimo(7);
        lista.removeUltimo();
        lista.inserePrimeiro(7);
        lista.inserePrimeiro(6);
        lista.insereOrdenado(4);
        lista.insereOrdenado(3);
        lista.inserePrimeiro(2);
        lista.insereUltimo(9);
        lista.insereOrdenado(1);
        lista.insereOrdenado(8);
        lista.imprime();

        Node removido1 = lista.removePrimeiro();
        Node removido2 = lista.removeUltimo();
        Node removido3 = lista.removePrimeiro();
        System.out.printf("Removidos: %s, %s e %s%nNova lista: ", removido1._info, removido2._info, removido3._info);
        lista.imprime();

        Node nodeRetornado = lista.getNode(4);
        lista.insereDepois(nodeRetornado, 5);
        lista.imprime();

        Node removido4 = lista.remove(nodeRetornado);
        System.out.println("Removido: " + removido4._info);
        lista.imprime();

        lista.insereOrdenado(4);
        lista.insereOrdenado(10);
        lista.insereOrdenado(7);
        lista.imprime();

        lista.inserePrimeiro(15);
        lista.insereUltimo(-15);
        lista.imprime();

        Node removido5 = lista.removeUltimo();
        Node removido6 = lista.removePrimeiro();
        Node removido7 = lista.removeUltimo();
        lista.insereOrdenado(9);
        Node nodeRetornado2 = lista.getNode(7);
        Node removido8 = lista.remove(nodeRetornado2);
        lista.imprime();

        lista.removePrimeiro();
        lista.removeUltimo();
        lista.removePrimeiro();
        lista.removeUltimo();
        lista.imprime();
        lista.removePrimeiro();
        lista.removeUltimo();
        lista.removePrimeiro();
        lista.imprime();
    }
}
