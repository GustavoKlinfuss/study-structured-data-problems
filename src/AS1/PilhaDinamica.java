package AS1;

import AF3.ListaEncadeada;
import AF3.Node;

public class PilhaDinamica {
    private ListaEncadeada _lista;

    PilhaDinamica() {
        _lista = new ListaEncadeada();
    }

    public boolean isVazia() {
        return _lista.vazia();
    }

    public void empilha(int elemento) {
        _lista.insereUltimo(elemento);
    }

    public int desempilha() throws Exception {
        if(isVazia())
            throw new Exception("Tentou desempilhar uma pilha vazia");

        Node removido = _lista.removeUltimo();

        return removido._info;
    }

    public void imprimePilha() {
        _lista.imprime();
    }
}

class ValidadorDeExpressoesDinamico {
    private PilhaDinamica _pilha;

    public boolean validarExpressao(String expressao) throws Exception {
        _pilha = new PilhaDinamica();

        char[] charsExpressao = expressao.toCharArray();

        for (char c: charsExpressao) {
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
