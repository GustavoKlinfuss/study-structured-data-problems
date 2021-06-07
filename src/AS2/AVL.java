package AS2;

public class AVL {
    private Node _raiz;

    public AVL(){
        this._raiz = null;
    }

    public boolean isVazia() {
        return this._raiz == null;
    }

    public void inserir(int info) {
        System.out.println("Inserido: " + "\u001B[32m" + info + "\u001B[0m");
        if(isVazia())
            this._raiz = new Node(info);
        else
            this._raiz = this._raiz.inserirEBalancear(info);
    }

    public void preOrdem() {
        System.out.print("\u001B[33m" + "Pré Ordem" + "\u001B[0m" + " -| ");
        if(!isVazia())
            _raiz.preOrdem();
        System.out.println();
    }

    public void inOrdem() {
        System.out.print("\u001B[34m" + "In Ordem " + "\u001B[0m" + " -| ");
        if(!isVazia())
            this._raiz.inOrdem();
        System.out.println();
    }

    public void posOrdem() {
        System.out.print("\u001B[35m" + "Pós Ordem" + "\u001B[0m" + " -| ");
        if(!isVazia())
            this._raiz.posOrdem();
        System.out.println();
    }

//    public Node encontrar(int info) {
//        if(isVazia())
//            return null;
//        return this._raiz.encontrar(info);
//    }

    public void remover(int info) {
        if(!isVazia())
            if(this._raiz.getInfo() == info) {
                if(this._raiz.isFolha())
                    this._raiz = null;
                else
                    this._raiz.remover();
            }
            else
                this._raiz = this._raiz.removerEBalancear(info);
    }
}

class Node {
    private int _info;
    private Node _esquerda;
    private Node _direita;

    public Node(int info) {
        this._info = info;
        this._esquerda = null;
        this._direita = null;
    }

    public static int getAltura(Node node) {
        if(node == null) return -1;

        int alturaEsquerda = getAltura(node._esquerda);
        int alturaDireita = getAltura(node._direita);

        if(alturaEsquerda > alturaDireita)
            return 1 + alturaEsquerda;
        return 1 + alturaDireita;
    }

    private static Node rotacionarADireita(Node node) {
        Node novaRaiz = node._esquerda;
        Node temp = novaRaiz._direita;
        novaRaiz._direita = node;
        node._esquerda = temp;
        return novaRaiz;
    }

    private static Node rotacionarAEsquerda(Node node) {
        Node novaRaiz = node._direita;
        Node temp = novaRaiz._esquerda;
        novaRaiz._esquerda = node;
        node._direita = temp;
        return novaRaiz;
    }

    public int getInfo() {
        return _info;
    }

//    public Node encontrar(int info) {
//        if(info == _info) return this;
//
//        if(info > _info)
//            if(this._direita != null)
//                return this._direita.encontrar(info);
//        else if(this._esquerda != null)
//            return this._esquerda.encontrar(info);
//
//        return null;
//    }

    public Node inserirEBalancear(int info) {
        if(info >= _info)
            _direita = inserirOuProsseguir(_direita, info);
        else
            _esquerda = inserirOuProsseguir(_esquerda, info);

        int fb = fatorDeBalanceamento();
        if (fb < -1 || fb > 1)
            return balancear(fb);

        return this;
    }

    public static Node inserirOuProsseguir(Node node, int info) {
        if (node == null)
            return new Node(info);
        return node.inserirEBalancear(info);
    }

    public Node balancear(int fb) {
        System.out.println("Balanceado");

        if(fb == 2) {
            if (this._esquerda != null && this._esquerda.fatorDeBalanceamento() == -1)
                this._esquerda = rotacionarAEsquerda(this._esquerda);
            if (this._direita != null && this._direita.fatorDeBalanceamento() == -1)
                this._direita = rotacionarAEsquerda(this._direita);
            return rotacionarADireita(this);
        }

        if (this._esquerda != null && this._esquerda.fatorDeBalanceamento() == 1)
            this._esquerda = rotacionarADireita(this._esquerda);
        if (this._direita != null && this._direita.fatorDeBalanceamento() == 1)
            this._direita = rotacionarADireita(this._direita);
        return rotacionarAEsquerda(this);
    }

    private int fatorDeBalanceamento() {
        return getAltura(_esquerda) - getAltura(_direita);
    }

    public boolean isFolha() {
        return this._direita == null && this._esquerda == null;
    }

    public Node removerEBalancear(int info) {
        if(info > this._info)
            this._direita = removerOuProsseguir(this._direita, info);
        else
            this._esquerda = removerOuProsseguir(this._esquerda, info);

        int fb = this.fatorDeBalanceamento();
        if (fb < -1 || fb > 1)
            return balancear(fb);

        return this;
    }

    private static Node removerOuProsseguir(Node node, int info) {
        if(node != null) {
            if(node._info == info) {
                System.out.println("Removido: " + "\u001B[31m" + info + "\u001B[0m");
                if(node.isFolha())
                    return null;
                return node.remover();
            }

            return node.removerEBalancear(info);
        }

        return null;
    }

    public Node remover() {
        Node removido;

        if(this._esquerda != null) {
            if(this._esquerda._direita == null)
                removido = removerComOMaiorSendoAEsquerda();
            else
                removido = removerComMaiorDaEsquerda();
        }
        else
            removido = removerSemEsquerda();

        int fb = this.fatorDeBalanceamento();
        if (fb < -1 || fb > 1)
            return balancear(fb);
        return removido;
    }

    private Node removerComOMaiorSendoAEsquerda() {
        Node nodeEsquerda = this._esquerda;
        this._info = nodeEsquerda._info;
        this._esquerda = nodeEsquerda._esquerda;
        nodeEsquerda._esquerda = null;
        return this;
    }

    private Node removerComMaiorDaEsquerda() {
        Node paiDoNodeRef = this._esquerda.encontrarPaiDaMaiorSubArvore();
        Node nodeRef = paiDoNodeRef._direita;
        this._info = nodeRef._info;
        paiDoNodeRef._direita = nodeRef._esquerda;
        _esquerda = _esquerda.balancearEsquerda();
        return this;
    }

    private Node removerSemEsquerda() {
        Node nodeRef = this._direita;
        this._info = nodeRef._info;
        this._esquerda = nodeRef._esquerda;
        this._direita = nodeRef._direita;
        nodeRef._esquerda = null;
        nodeRef._direita = null;
        return this;
    }

    public Node balancearEsquerda() {
        if(this._esquerda != null)
            this._esquerda = this._esquerda.balancearEsquerda();

        int fb = this.fatorDeBalanceamento();
        if (fb < -1 || fb > 1)
            return balancear(fb);
        return this;
    }

    public Node encontrarPaiDaMaiorSubArvore() {
        if(this._direita._direita == null)
            return this;
        return this._direita.encontrarPaiDaMaiorSubArvore();
    }

    public void preOrdem() {
        System.out.print("\u001B[33m" + this._info + "\u001B[0m" + " | ");
        if(this._esquerda != null) this._esquerda.preOrdem();
        if(this._direita != null) this._direita.preOrdem();
    }

    public void inOrdem() {
        if(this._esquerda != null) this._esquerda.inOrdem();
        System.out.print("\u001B[34m" + this._info + "\u001B[0m" + " | ");
        if(this._direita != null) this._direita.inOrdem();
    }

    public void posOrdem() {
        if(this._esquerda != null) this._esquerda.posOrdem();
        if(this._direita != null) this._direita.posOrdem();
        System.out.print("\u001B[35m" + this._info + "\u001B[0m" + " | ");
    }
}
