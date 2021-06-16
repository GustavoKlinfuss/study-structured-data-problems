package AS3;

import AF3.ListaEncadeada;

import java.util.Random;

public class TabelaHash {
    private int _colisao;
    private NodeTabela[] _tabela;

    public TabelaHash(int tamanho) {
        _tabela = new NodeTabela[tamanho];
        _colisao = 0;
        preencherTabela();
    }

    public void popular() {
        var rd = new Random();
        for (int i = 0; i < _tabela.length*9/10; i++) {
            int randomInt = rd.nextInt(1000000);
            System.out.print("n" + randomInt + " ");
            this.insere(randomInt);
        }
    }

    public void preencherTabela() {
        for (int i = 0; i < _tabela.length; i++) {
            _tabela[i] = new NodeTabela(-1);
        }
    }

    public void insere(int chave) {
        var pos = chave % _tabela.length;

        if (_tabela[pos].getInfo() == -1) {
            _tabela[pos].setInfo(chave);
        }
        else {
            _colisao++;
            _tabela[pos].insere(chave);
        }
    }

    public void imprimir() {
        for (int i = 0; i < _tabela.length; i++) {
            System.out.print(i);
            _tabela[i].imprimir();
        }
    }

    public boolean busca(int chave) throws Exception {
        return _tabela[chave % _tabela.length].busca(chave);
    }

    public int getColisoes() {
        return _colisao;
    }
}

class NodeTabela {
    private int _info;
    private ListaEncadeada _lista;

    public NodeTabela(int info)
    {
        _info = info;
        _lista = null;
    }

    public void setInfo(int info) {
        _info = info;
    }

    public int getInfo() {
        return _info;
    }

    public void insere(int elemento) {
        if(_lista == null)
            _lista = new ListaEncadeada();
        _lista.insereUltimo(elemento);
    }

    public void imprimir() {
        System.out.print(" ");
        System.out.print(_info);
        System.out.print(" ");
        if(_lista != null)
            _lista.imprime();
        System.out.println();
    }

    public boolean busca(int chave) throws Exception {
        if (_info == chave)
            return true;
        if (_info == -1 || _lista == null)
            return false;
        return _lista.existe(chave);
    }
}
