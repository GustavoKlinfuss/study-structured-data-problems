package ListaDuplamenteEncadeada;

public class NodeDE {
    public int _info;
    public NodeDE _ante;
    public NodeDE _prox;

    public NodeDE(int info) {
        _info = info;
    }

    public NodeDE(int info, NodeDE ante, NodeDE prox) {
        _info = info;
        _ante = ante;
        _prox = prox;
    }

//    public Node getNode(int info) throws Exception {
//        if(_info == info)
//            return this;
//        if(_prox == null)
//            throw new Exception("O nó especificado não foi encontrado");
//        return _prox.getNode(info);
//    }
//
//    public Node getUltimo() {
//        if(_prox == null)
//            return this;
//        return _prox.getUltimo();
//    }
//
//    public void insereDepoisDesteNode(int info) {
//        _prox = new Node(info, _prox);
//    }
//
//    public void insereOrdenado(int info) {
//        if(_prox == null ||  info < _prox._info)
//            insereDepoisDesteNode(info);
//        else
//            _prox.insereOrdenado(info);
//    }
//
//    public void imprimirValorDoNode() {
//        System.out.print(_info);
//        if(_prox != null) {
//            System.out.print(", ");
//            _prox.imprimirValorDoNode();
//        }
//    }
//
//    public Node getPenultimo() {
//        if(this._prox._prox == null)
//            return this;
//        return _prox.getPenultimo();
//    }
//
//    public Node getAnterior(Node node) throws Exception {
//        if(_prox == node)
//            return this;
//        if(_prox == null)
//            throw new Exception("A lista não possui esse nó");
//        return _prox.getAnterior(node);
//    }
}
