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

        // System.out.println("Inserido: Primeiro = " + _primeiro + ", Último = " + _ultimo);
    }

    public int remove() throws Exception {
        if(vazia())
            throw new Exception("A fila está vazia");

        int resultado = _dados[_primeiro % _dados.length];
        _primeiro ++;

        if(_primeiro >= _dados.length)
            reseta();

        // System.out.println("Removido: Primeiro = " + _primeiro + ", Último = " + _ultimo);

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
}
