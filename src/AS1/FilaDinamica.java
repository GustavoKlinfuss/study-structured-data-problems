package AS1;

import AF3.ListaEncadeada;
import AF3.Node;

public class FilaDinamica {
    private final ListaEncadeada _lista;

    FilaDinamica() {
        _lista = new ListaEncadeada();
    }

    public boolean vazia() {
        return _lista.vazia();
    }

    public void insere(int elemento) {
        _lista.insereUltimo(elemento);
    }

    public int remove() throws Exception {
        if(vazia())
            throw new Exception("A fila está vazia");

        Node removido = _lista.removePrimeiro();

        return removido._info;
    }

    public void imprime() {
        _lista.imprime();
    }
}

class MergeDinamico {
    public FilaDinamica mergeDeFilasOrdenadas(FilaDinamica fila1, FilaDinamica fila2) throws Exception {
        FilaDinamica filaFinal = new FilaDinamica();

        if (fila1.vazia()) return completar(filaFinal, fila2);
        if (fila2.vazia()) return completar(filaFinal, fila1);

        int e1 = fila1.remove();
        int e2 = fila2.remove();

        while (true) {
            if (e1 <= e2) {
                filaFinal.insere(e1);
                if (fila1.vazia()) {
                    filaFinal.insere(e2);
                    return completar(filaFinal, fila2);
                }
                e1 = fila1.remove();
            }
            else {
                filaFinal.insere(e2);
                if (fila2.vazia()) {
                    filaFinal.insere(e1);
                    return completar(filaFinal, fila1);
                }
                e2 = fila2.remove();
            }
        }
    }

    private FilaDinamica completar(FilaDinamica filaFinal, FilaDinamica filaAuxiliar) throws Exception {
        while(true) {
            if (filaAuxiliar.vazia())
                return filaFinal;
            filaFinal.insere(filaAuxiliar.remove());
        }
    }
}