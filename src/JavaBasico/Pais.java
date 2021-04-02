package JavaBasico;

final class Pais {
    private String _codigoIso;
    private String _nome;
    private double _dimensao;
    private double _populacao;
    private Pais[] _fronteiras;

    Pais(String codigoIso, String nome, long dimensao) {
        this._codigoIso = codigoIso;
        this._nome = nome;
        this._dimensao = dimensao;
        this._fronteiras = new Pais[] {};
    }

    public String getCodigoIso() {
        return this._codigoIso;
    }

    public void setCodigoIso(String _codigoIso) {
        this._codigoIso = _codigoIso;
    }

    public String getNome() {
        return this._nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public double getPopulacao() {
        return this._populacao;
    }

    public void setPopulacao(double populacao) {
        this._populacao = populacao;
    }

    public double getDimensao() {
        return this._dimensao;
    }

    public void setDimensao(double dimensao) {
        this._dimensao = dimensao;
    }

    public Pais[] getFronteiras() {
        return this._fronteiras;
    }

    public void setFronteiras(Pais[] fronteiras) {
        this._fronteiras = fronteiras;
    }

    public boolean mesmoPais(Pais pais) {
        return this._codigoIso.equals(pais._codigoIso);
    }

    public boolean temPaisVizinho(Pais pais) {
        for (Pais paisVizinho : this._fronteiras) {
            if (paisVizinho._codigoIso.equals(pais._codigoIso))
                return true;
        }

        return false;
    }

    public double getDensidadePopulacional() {
        return _populacao / _dimensao;
    }

    public Pais[] getVizinhosComuns(Pais paisVerificado) {
        Pais[] vizinhosComuns = {};

        for (Pais paisVizinho : this._fronteiras) {
            for (Pais vizinhoDoPaisVerificado : paisVerificado._fronteiras) {
                if(paisVizinho.getCodigoIso().equals(vizinhoDoPaisVerificado.getCodigoIso())) {
                    Pais[] newObjectList = new Pais[vizinhosComuns.length+1];

                    for (int i = 0; i < vizinhosComuns.length; i++) {
                        newObjectList[i] = vizinhosComuns[i];
                    }

                    newObjectList[vizinhosComuns.length] = paisVizinho;

                    vizinhosComuns =  newObjectList;
                }
            }
        }

        return vizinhosComuns;
    }

    public void printInfo() {
        System.out.println(this.getNome() + " (" + this.getCodigoIso() + ") | População de " + this.getPopulacao() + " | " + this.getDimensao());
        System.out.println("Densidade populacional: " + this.getDensidadePopulacional() + " h/km²");

        System.out.println("Faz fronteira com:");
        for (Pais p: this.getFronteiras()) {
            System.out.println(" - " + p.getNome());
        }
    }
}
