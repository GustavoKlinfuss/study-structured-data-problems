package Arvore;

public class Arvore {
    private Node _raiz;

    Arvore(){
        _raiz = null;
    }

    public boolean vazia(){
        return _raiz == null;
    }

    public void inserir(int info) {
        if(vazia())
            _raiz = new Node(info);
        else
            _raiz = _raiz.inserir(info);
    }

    public void preOrdem() {
        System.out.print("---- PRÉ ORDEM | ");
        if(!vazia())
            _raiz.preOrdem();
        System.out.println();
    }

    public void inOrdem() {
        System.out.print("---- IN ORDEM  | ");
        if(!vazia())
            _raiz.inOrdem();
        System.out.println();
    }

    public void posOrdem() {
        System.out.print("---- PÓS ORDEM | ");
        if(!vazia())
            _raiz.posOrdem();
        System.out.println();
    }

    public Node encontrar(int info) {
        if(vazia())
            return null;

        return _raiz.encontrar(info);
    }

    public void remover(int info) {
        if(!vazia())
            _raiz.remover(info);
    }
}

class Node {
    private int _info;
    private Node _esquerda;
    private Node _direita;

    Node(int info) {
        _info = info;
        _esquerda = null;
        _direita = null;
    }

    public static int altura(Node node) {
        if(node == null) return -1;

        int alturaEsquerda = altura(node._esquerda);
        int alturaDireita = altura(node._direita);

        if(alturaEsquerda > alturaDireita)
            return 1 + alturaEsquerda;
        return 1 + alturaDireita;
    }

    public static Node rotacaoADireita(Node node)
    {
        Node novaRaiz = node._esquerda;
        Node temp = novaRaiz._direita;
        novaRaiz._direita = node;
        node._esquerda = temp;
        return novaRaiz;
    }

    public static Node rotacaoAEsquerda(Node node)
    {
        Node novaRaiz = node._direita;
        Node temp = novaRaiz._esquerda;
        novaRaiz._esquerda = node;
        node._direita = temp;
        return novaRaiz;
    }

    public int getInfo() {
        return _info;
    }

    public Node getEsquerda() {
        return _esquerda;
    }

    public Node getDireita() {
        return _direita;
    }

    public Node encontrar(int info) {
        if(info == _info) return this;

        if(info > _info)
            if (_direita != null)
                return _direita.encontrar(info);
        else
            if(_esquerda != null)
                return _esquerda.encontrar(info);

        return null;
    }

    public Node inserir(int info) {
        if(info >= _info) {
            if (_direita == null)
                _direita = new Node(info);
            else
                _direita = _direita.inserir(info);
        }
        else {
            if(_esquerda == null)
                _esquerda = new Node(info);
            else
                _esquerda = _esquerda.inserir(info);
        }

        int fb = fatorDeBalanceamento();
        if (fb < -1 || fb > 1)
            return balancear(fb);

        return this;
    }

    public Node balancear(int fb) {
        if(fb < -1) {
            if (_esquerda != null && _esquerda.fatorDeBalanceamento() == 1)
                _esquerda = rotacaoADireita(_esquerda);
            if (_direita != null && _direita.fatorDeBalanceamento() == 1)
                _direita = rotacaoADireita(_direita);
            return rotacaoAEsquerda(this);
        }

        if (_esquerda != null && _esquerda.fatorDeBalanceamento() == -1)
            _esquerda = rotacaoADireita(_esquerda);
        if (_direita != null && _direita.fatorDeBalanceamento() == -1)
            _direita = rotacaoADireita(_direita);
        return rotacaoADireita(this);
    }

    public int fatorDeBalanceamento() {
        return altura(_esquerda) - altura(_direita);
    }

    public void remover(int info) {
        if(info == _info)
            removerEste();
        else if(info > _info) {
            if(_direita._direita == null && _direita._esquerda == null)
                _direita = null;
            else {
                _direita.remover(info);
            }
        }
        else {
            if(_esquerda._esquerda == null && _esquerda._direita == null)
                _esquerda = null;
            else {
                _esquerda.remover(info);
            }
        }
    }

    public void removerEste()
    {
        boolean temEsquerda = _esquerda != null;

        if(temEsquerda) {
            boolean SubArvoreEsquerdaEOMaior = _esquerda._direita == null;

            if(SubArvoreEsquerdaEOMaior) {
                Node substituto = _esquerda;
                _info = substituto._info;
                _esquerda = substituto._esquerda;
                substituto._esquerda = null;
            }
            else {
                Node paiDoSubstituto = _esquerda.encontrarPaiDaMaiorSubArvore();
                Node substituto = paiDoSubstituto._direita;
                _info = substituto._info;
                paiDoSubstituto._direita = substituto._esquerda;
            }
        } else {
            Node substituto = _direita;
            _info = substituto._info;
            _direita = substituto._direita;
            substituto._direita = null;
        }
    }

    public Node encontrarPaiDaMaiorSubArvore() {
        if(_direita._direita == null)
            return this;
        else
            return _direita.encontrarPaiDaMaiorSubArvore();
    }

    public void preOrdem() {
        System.out.print(_info + " | ");

        if(_esquerda != null)
            _esquerda.preOrdem();

        if(_direita != null)
            _direita.preOrdem();
    }

    public void inOrdem() {
        if(_esquerda != null)
            _esquerda.inOrdem();

        System.out.print(_info + " | ");

        if(_direita != null)
            _direita.inOrdem();
    }

    public void posOrdem() {
        if(_esquerda != null)
            _esquerda.posOrdem();

        if(_direita != null)
            _direita.posOrdem();

        System.out.print(_info + " | ");
    }
}
