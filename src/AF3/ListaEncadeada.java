package AF3;

public class ListaEncadeada {
    private Node _lista;

    public ListaEncadeada() {
        _lista = null;
    }

    public boolean vazia() {
        return _lista == null;
    }

    public void inserePrimeiro(int info) {
        _lista = new Node(info, _lista);
    }

    public static void insereDepois(Node node, int info) throws Exception {
        if(node == null)
            throw new Exception("Node informado é nulo");

        node.insereDepoisDesteNode(info);
    }

    public void insereUltimo(int info) {
        if(vazia())
            _lista = new Node(info);
        else
            _lista.getUltimo().insereDepoisDesteNode(info);
    }

    public void insereOrdenado(int info) {
        if(vazia() || info < _lista._info)
            inserePrimeiro(info);
        else
            _lista.insereOrdenado(info);
    }

    public void imprime() {
        if(_lista != null)
            _lista.imprimirValorDoNode();
    }

    public Node removePrimeiro() throws Exception {
        if(vazia())
            throw new Exception("Lista está vazia");

        Node nodeRemovido = _lista;
        _lista = _lista._prox;

        return nodeRemovido;
    }

    public Node removeUltimo() throws Exception {
        if(vazia())
            throw new Exception("Lista está vazia");

        boolean listaDeUmElemento = _lista._prox == null;
        if(listaDeUmElemento)
            return removePrimeiro();

        Node penultimo = _lista.getPenultimo();
        Node ultimo = penultimo._prox;
        penultimo._prox = null;
        return ultimo;
    }

    public Node remove(Node node) throws Exception {
        if(vazia())
            throw new Exception("Lista está vazia");
        if(_lista == node)
            _lista = _lista._prox;

        Node anterior = _lista.getAnterior(node);
        anterior._prox = node._prox;
        return node;
    }

    public Node getNode(int info) throws Exception {
        if(vazia())
            throw new Exception("Não há este nó");
        return _lista.getNode(info);
    }

    public boolean existe(int info) {
        return _lista.existe(info);
    }
}
