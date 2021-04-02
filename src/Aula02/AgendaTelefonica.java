package Aula02;

public class AgendaTelefonica {
    private Aluno[] _alunos;

    public AgendaTelefonica() {
        _alunos = new Aluno[]{};
    }

    public void adicionarContato(Aluno contato) {
        Aluno[] newListAlunos = new Aluno[this._alunos.length + 1];

        for (int i = 0; i < _alunos.length; i++) {
            newListAlunos[i] = _alunos[i];
        }

        newListAlunos[newListAlunos.length - 1] = contato;

        _alunos = newListAlunos;
    }

    public void removerContato(Aluno contato) {
        Aluno[] newListAlunos = new Aluno[this._alunos.length - 1];
        boolean passouDoIndex = false;

        for (int i = 0; i < _alunos.length - 1; i++) {
            if(_alunos[i].equals(contato))
                passouDoIndex = true;

            if (passouDoIndex)
                newListAlunos[i] = _alunos[i + 1];
            else
                newListAlunos[i] = _alunos[i];
        }

        _alunos = newListAlunos;
    }

    public void imprimirAgenda() {
        System.out.println("A agenda tem o seguintes alunos:");
        for (Aluno aluno: _alunos) {
            System.out.println(aluno.getNome());
        }
    }
}

class Aluno {
    private String _nome;
    private String _telefone;

    public Aluno(String nome) {
        this._nome = nome;
    }

    public String getNome() {
        return this._nome;
    }
}