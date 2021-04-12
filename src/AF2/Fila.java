package AF2;

public class Fila {
    private int _primeiro;
    private int _ultimo;
    private final int[] _dados;

    Fila(int tamanho) {
        _dados = new int[tamanho];
        _primeiro = 0;
        _ultimo = -1;
    }

    public boolean cheia() {
        int tamanhoDaFila = _ultimo - _primeiro;

        return tamanhoDaFila == _dados.length - 1;
    }

    public boolean vazia() {
        return _primeiro - 1 == _ultimo;
    }

    public void insere(int elemento) throws Exception {
        if(cheia())
            throw new Exception("A fila está cheia");

        _ultimo += 1;
        _dados[_ultimo % _dados.length] = elemento;
    }

    public int remove() throws Exception {
        if(vazia())
            throw new Exception("A fila está vazia");

        int resultado = _dados[_primeiro % _dados.length];
        _primeiro ++;

        if(_primeiro >= _dados.length)
            reseta();

        return resultado;
    }

    private void reseta() {
        _primeiro -= _dados.length;
        _ultimo -= _dados.length;
    }

    public void imprime() {
        for (int i = _primeiro; i <= _ultimo; i++) {
            System.out.print(" | " + _dados[i % _dados.length]);

            if(i == _ultimo)
                System.out.println(" | ");
        }
    }

    public int tamanho() {
        return _ultimo - _primeiro + 1;
    }
}

class Merge {
    public Fila mergeDeFilasOrdenadas(Fila fila1, Fila fila2) throws Exception {
        Fila filaFinal = new Fila(fila1.tamanho() + fila2.tamanho());

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

    private Fila completar(Fila filaFinal, Fila filaAuxiliar) throws Exception {
        while(true) {
            if (filaAuxiliar.vazia())
                return filaFinal;
            filaFinal.insere(filaAuxiliar.remove());
        }
    }
}