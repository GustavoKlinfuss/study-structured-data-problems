package AF1;

public class Pilha {
    private int _topo;
    private final int[] _dados;

    Pilha(int max) {
        _topo = -1;
        _dados = new int[max];
    }

    public int topo() throws Exception {
        if (isVazia())
            throw new Exception("Uma lista vazia não tem topo");

        return _dados[_topo];
    }

    public boolean isVazia() {
        return _topo == -1;
    }

    public boolean isCheia() {
        return _topo == _dados.length - 1;
    }

    public void empilha(int elemento) throws Exception {
        if(isCheia())
            throw new Exception("Tentou empilhar numa pilha cheia");

        _topo++;
        _dados[_topo] = elemento;
    }

    public int desempilha() throws Exception {
        if(isVazia())
            throw new Exception("Tentou desempilhar uma pilha vazia");

        int elementoDesempilhado = _dados[_topo];
        _topo--;
        return elementoDesempilhado;
    }
}

class ValidadorDeExpressoes {
    private Pilha _pilha;

    public boolean validarExpressao(String expressao) throws Exception {
        _pilha = new Pilha(expressao.length());

        for (char c: expressao.toCharArray()) {
            if (c == '(' || c == '['  || c == '{') {
                _pilha.empilha(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if(_pilha.isVazia() || !isEquivalente((char)_pilha.desempilha(), c))
                    return false;
            }
        }

        return _pilha.isVazia();
    }

    private boolean isEquivalente(char abre, char fecha) {
        return abre == '(' && fecha == ')' || abre == '[' && fecha == ']' || abre == '{' && fecha == '}';
    }
}
