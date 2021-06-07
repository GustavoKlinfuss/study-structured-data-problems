package AS2;

public class AS2 {
    public static void main(String[] args) {
        var arvore = new AVL();

        arvore.inserir(10);
        arvore.inserir(12);
        arvore.inserir(4);
        arvore.inserir(7);
        arvore.inserir(19);
        arvore.inserir(3);
        arvore.inserir(5);
        arvore.inserir(13);
        arvore.inserir(20);
        arvore.inserir(17);
        arvore.inserir(9);
        arvore.inserir(11);
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();

//        var obtido = arvore.encontrar(18);
//        System.out.println("NODE OBTIDO: " + obtido.getInfo());
        arvore.remover(3);
        arvore.preOrdem();
        arvore.remover(7);
        arvore.preOrdem();
        arvore.remover(4);
        arvore.preOrdem();
        arvore.remover(9);
        arvore.preOrdem();

        arvore.inserir(4);
        arvore.inserir(21);
        arvore.inserir(16);
        arvore.inserir(18);
        arvore.inserir(15);

        arvore.preOrdem();
        arvore.remover(19);
        arvore.preOrdem();

//        System.out.println("\n------------------------------- ÁRVORE 2 ------------------------------------");
//        AVL avl = new AVL();
//
//        avl.inserir(65);
//        avl.preOrdem();
//        avl.inserir(95);
//        avl.preOrdem();
//        avl.inserir(125);
//        avl.preOrdem();
//        avl.inserir(35);
//        avl.preOrdem();
//        avl.inserir(5);
//        avl.preOrdem();
//        avl.inserir(2);
//        avl.preOrdem();
//
//        avl.inserir(10);
//        avl.inserir(1);
//        avl.inserir(3);
//        avl.preOrdem();
//
//        avl.remover(35);
//
//        avl.preOrdem();
//        avl.inOrdem();
//        avl.posOrdem();
    }
}
