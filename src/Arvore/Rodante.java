package Arvore;

public class Rodante {
    public static void main(String[] args) {
        var arvore = new Arvore();

        arvore.inserir(14);
        arvore.preOrdem();
        arvore.inserir(15);
        arvore.preOrdem();
        arvore.inserir(4);
        arvore.preOrdem();
        arvore.inserir(9);
        arvore.preOrdem();
        arvore.inserir(7);
        arvore.preOrdem();
        arvore.inserir(18);
        arvore.preOrdem();
        arvore.inserir(3);
        arvore.preOrdem();
        arvore.inserir(5);
        arvore.preOrdem();
        arvore.inserir(16);
        arvore.inserir(20);
        arvore.inserir(17);
        arvore.inserir(9);
        arvore.inserir(14);
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();

        var obtido = arvore.encontrar(18);
        System.out.println("esquerdaDoNodeObtido: " + obtido.getEsquerda().getInfo());

        arvore.remover(20);
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();
        arvore.remover(4);
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();
        arvore.remover(7);
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();

        System.out.println("##### ÁRVORE 2 - AVL ######");
        Arvore avl = new Arvore();

        avl.inserir(65);
        avl.preOrdem();
        avl.inserir(95);
        avl.preOrdem();
        avl.inserir(125);
        avl.preOrdem();
        avl.inserir(35);
        avl.preOrdem();
        avl.inserir(5);
        avl.preOrdem();
    }
}
