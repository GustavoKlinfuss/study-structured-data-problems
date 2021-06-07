package AS2;

public class AS2 {
    public static void main(String[] args) {
        var avl1 = new AVL();

        avl1.inserir(10);
        avl1.inserir(12);
        avl1.inserir(4);
        avl1.inserir(7);
        avl1.inserir(19);
        avl1.inserir(3);
        avl1.inserir(5);
        avl1.inserir(13);
        avl1.inserir(20);
        avl1.inserir(17);
        avl1.inserir(9);
        avl1.inserir(11);
        avl1.preOrdem();
        avl1.inOrdem();
        avl1.posOrdem();

        var existe1 = avl1.verificarSeExiste(18);
        System.out.println("O node de valor 18 existe: " + existe1);
        var existe2 = avl1.verificarSeExiste(17);
        System.out.println("O node de valor 17 existe: " + existe2);
        var existe3 = avl1.verificarSeExiste(16);
        System.out.println("O node de valor 16 existe: " + existe3);
        var existe4 = avl1.verificarSeExiste(15);
        System.out.println("O node de valor 15 existe: " + existe4);

        avl1.remover(3);
        avl1.preOrdem();
        avl1.remover(7);
        avl1.preOrdem();
        avl1.remover(4);
        avl1.preOrdem();
        avl1.remover(9);
        avl1.preOrdem();

        avl1.inserir(4);
        avl1.inserir(21);
        avl1.inserir(16);
        avl1.inserir(18);
        avl1.inserir(15);

        avl1.preOrdem();
        avl1.remover(19);
        avl1.preOrdem();

        avl1.remover(13);
        avl1.preOrdem();

        avl1.remover(12);
        avl1.preOrdem();

        System.out.println("\n------------------------------- ÁRVORE 2 ------------------------------------");
        AVL avl2 = new AVL();

        avl2.inserir(65);
        avl2.preOrdem();
        avl2.inserir(95);
        avl2.preOrdem();
        avl2.inserir(125);
        avl2.preOrdem();
        avl2.inserir(35);
        avl2.preOrdem();
        avl2.inserir(5);
        avl2.preOrdem();
        avl2.inserir(2);
        avl2.preOrdem();

        avl2.inserir(10);
        avl2.inserir(1);
        avl2.inserir(3);
        avl2.preOrdem();

        avl2.remover(35);

        avl2.preOrdem();
        avl2.inOrdem();
        avl2.posOrdem();

        System.out.println("\n------------------------------- ÁRVORE 3 ------------------------------------");
        AVL avl3 = new AVL();

        avl3.inserir(1);
        avl3.inserir(2);
        avl3.inserir(3);
        avl3.preOrdem();
        avl3.inserir(4);
        avl3.inserir(5);
        avl3.inserir(6);
        avl3.inserir(7);
        avl3.inserir(8);
        avl3.inserir(0);
        avl3.preOrdem();
        avl3.inOrdem();
        avl3.posOrdem();

        System.out.println("\n------------------------------- ÁRVORE 4 ------------------------------------");
        AVL avl4 = new AVL();

        avl4.inserir(8);
        avl4.inserir(7);
        avl4.inserir(6);
        avl4.preOrdem();
        avl4.inserir(5);
        avl4.inserir(4);
        avl4.inserir(3);
        avl4.inserir(2);
        avl4.inserir(1);
        avl4.inserir(9);
        avl4.preOrdem();
        avl4.inOrdem();
        avl4.posOrdem();

        avl4.remover(4);
        avl4.preOrdem();
        avl4.inOrdem();
        avl4.posOrdem();
        avl4.remover(5);
        avl4.preOrdem();
        avl4.inOrdem();
        avl4.posOrdem();
        avl4.remover(3);
        avl4.preOrdem();
        avl4.inOrdem();
        avl4.posOrdem();
        avl4.remover(9);
        avl4.preOrdem();
        avl4.inOrdem();
        avl4.posOrdem();

    }
}
