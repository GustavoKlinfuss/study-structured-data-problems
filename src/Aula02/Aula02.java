package Aula02;

public class Aula02 {
    public static void main(String[] args) {
        int[] vetor = {5, 8, 1, 8, 4};
        int[] vetor2 = {5};
        int[] vetor3 = {56, 2, 1, 4, 4, 4, 56, 56};
        int[] vetor4 = {6, 8, -2, 5, 1, 9, -2};


        Matematica mat = new Matematica();
        System.out.println(mat.calcularMedia(vetor));

        System.out.println(mat.calcularModa(vetor));
        System.out.println(mat.calcularModa(vetor2));
        System.out.println(mat.calcularModa(vetor3));
        System.out.println(mat.calcularModa(vetor4));

        Aluno joao = new Aluno("João");
        Aluno marcos = new Aluno("Marcos");

        AgendaTelefonica agenda = new AgendaTelefonica();

        agenda.imprimirAgenda();

        agenda.adicionarContato(joao);
        agenda.adicionarContato(marcos);

        agenda.removerContato(marcos);

        agenda.imprimirAgenda();

    }
}
