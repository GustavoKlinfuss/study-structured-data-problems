package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada {
        private NodeDE _lista;

        public ListaDuplamenteEncadeada() {
            _lista = null;
        }

        public boolean vazia() {
            return _lista == null;
        }

        public void inserePrimeiro(int info) {
            if(vazia())
                _lista = new NodeDE(info);
            else if(_lista._ante == null && _lista._prox == null) {
                NodeDE nodeSalvo = _lista;

                _lista = new NodeDE(info, nodeSalvo, nodeSalvo);
                nodeSalvo._ante = _lista;
                nodeSalvo._prox = _lista;
            }
            else {
                NodeDE nodeSalvo = _lista;

                _lista = new NodeDE(info, nodeSalvo._ante, nodeSalvo);
                _lista._prox._ante = _lista;
                _lista._ante._prox = _lista;
            }
        }

//        public static void insereDepois(NodeDE node, int info) throws Exception {
//            if(node == null)
//                throw new Exception("Node informado é nulo");
//
//            node.insereDepoisDesteNode(info);
//        }
//
//        public void insereUltimo(int info) {
//            if(vazia())
//                _lista = new NodeDE(info);
//            else
//                _lista.getUltimo().insereDepoisDesteNode(info);
//        }
//
//        public void insereOrdenado(int info) {
//            if(vazia() || info < _lista._info)
//                inserePrimeiro(info);
//            else
//                _lista.insereOrdenado(info);
//        }
//
//        public void imprime() {
//            System.out.print("[");
//
//            if(_lista != null)
//                _lista.imprimirValorDoNode();
//
//            System.out.println("]");
//        }
//
//        public NodeDE removePrimeiro() throws Exception {
//            if(vazia())
//                throw new Exception("Lista está vazia");
//
//            NodeDE nodeRemovido = _lista;
//            _lista = _lista._prox;
//
//            return nodeRemovido;
//        }
//
//        public NodeDE removeUltimo() throws Exception {
//            if(vazia())
//                throw new Exception("Lista está vazia");
//
//            boolean listaDeUmElemento = _lista._prox == null;
//            if(listaDeUmElemento)
//                return removePrimeiro();
//
//            NodeDE penultimo = _lista.getPenultimo();
//            NodeDE ultimo = penultimo._prox;
//            penultimo._prox = null;
//            return ultimo;
//        }
//
//        public NodeDE remove(NodeDE node) throws Exception {
//            if(vazia())
//                throw new Exception("Lista está vazia");
//            if(_lista == node)
//                _lista = _lista._prox;
//
//            NodeDE anterior = _lista.getAnterior(node);
//            anterior._prox = node._prox;
//            return node;
//        }
//
//        public NodeDE getNode(int info) throws Exception {
//            if(vazia())
//                throw new Exception("Não há este nó");
//            return _lista.getNode(info);
//        }
}
