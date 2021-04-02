package Aula01;

class Pessoa {
    protected String _nome;
    protected String _cpf;
    protected String _telefone;

    Pessoa() { }

    Pessoa(String nome, String cpf, String telefone) {
        this._nome = nome;
        this._cpf = cpf;
        this._telefone = telefone;
    }

    public String getNome() {
        return this._nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public String getCpf() {
        return this._cpf;
    }

    public void setCpf(String cpf) {
        this._cpf = cpf;
    }

    public String getTelefone() {
        return this._telefone;
    }

    public void setTelefone(String telefone) {
        this._telefone = telefone;
    }
}
