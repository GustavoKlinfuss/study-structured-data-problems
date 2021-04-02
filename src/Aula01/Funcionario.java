package Aula01;

class Funcionario extends Pessoa {
    private String _matricula;

    public Funcionario(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone);
        _matricula = matricula;
    }

    public String getMatricula() {
        return this._matricula;
    }

    public void setMatricula(String matricula) {
        this._matricula = matricula;
    }
}
