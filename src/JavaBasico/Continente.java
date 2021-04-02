package JavaBasico;

final class Continente {
    private String _nome;
    private Pais[] _paises;

    public Continente(String nome) {
        this._nome = nome;
        this._paises = new Pais[]{};
    }

    public String getNome() {
        return this._nome;
    }

    public void adicionarPais(Pais pais) {
        Pais[] novaListaPaises = new Pais[_paises.length + 1];

        for (int i = 0; i < _paises.length; i++) {
            novaListaPaises[i] = _paises[i];
        }

        novaListaPaises[_paises.length] = pais;

        _paises = novaListaPaises;
    }

    public double getDimensao() {
        Contador contador = new Contador();

        for (Pais p: _paises) {
            contador.incrementarContador(p.getDimensao());
        }

        return contador.getValorContador();
    }

    public double getPopulacao() {
        Contador contador = new Contador();

        for (Pais p: _paises) {
            contador.incrementarContador(p.getPopulacao());
        }

        return contador.getValorContador();
    }

    public double getDensidadePopulacao() {
        return this.getPopulacao() / this.getDimensao();
    }

    public Pais getMaiorPais() {
        Pais maiorPais = null;

        for (Pais p: _paises) {
            if (maiorPais == null)
                maiorPais = p;

            if (p.getDimensao() > maiorPais.getDimensao())
                maiorPais = p;
        }

        return maiorPais;
    }

    public Pais getMenorPais() {
        Pais menorPais = null;

        for (Pais p: _paises) {
            if (menorPais == null)
                menorPais = p;

            if (p.getDimensao() < menorPais.getDimensao())
                menorPais = p;
        }

        return menorPais;
    }

    public Pais getMaisPopuloso() {
        Pais maisPopuloso = null;

        for (Pais p: _paises) {
            if (maisPopuloso == null)
                maisPopuloso = p;

            if (p.getPopulacao() > maisPopuloso.getPopulacao())
                maisPopuloso = p;
        }

        return maisPopuloso;
    }

    public Pais getMenosPopuloso() {
        Pais menosPopuloso = null;

        for (Pais p: _paises) {
            if (menosPopuloso == null)
                menosPopuloso = p;

            if (p.getPopulacao() < menosPopuloso.getPopulacao())
                menosPopuloso = p;
        }

        return menosPopuloso;
    }

    public double getRazaoMaiorMenor() {
        return this.getMaiorPais().getDimensao() / this.getMenorPais().getDimensao();
    }
}
