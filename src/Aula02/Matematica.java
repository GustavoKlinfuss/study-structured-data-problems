package Aula02;

public class Matematica {

    public double calcularMedia(int[] vetor) {
        int soma = 0;

        for (int i: vetor) {
            soma += i;
        }

        return (double)soma / vetor.length;
    }

    public int calcularModa(int[] vetor) {
        int moda = -1;
        int contagemOcorrencias = -1;

        boolean multiplasModas = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != moda)
            {
                int contagemOcorrenciasAtuais = calcularOcorrencias(vetor, i);

                if (contagemOcorrenciasAtuais > contagemOcorrencias) {
                    moda = vetor[i];
                    contagemOcorrencias = contagemOcorrenciasAtuais;
                    multiplasModas = false;
                }
                else if (contagemOcorrenciasAtuais == contagemOcorrencias)
                    multiplasModas = true;
            }
        }

        if (multiplasModas){
            System.out.print("Não existem modas");
//            return -1;
        }

        return moda;
    }

    private int calcularOcorrencias(int[] vetor, int posicaoAVerificar) {
        int contagem = 0;

        for (int j = 0; j < vetor.length; j++) {
            if (vetor[posicaoAVerificar] == vetor[j])
                contagem++;
        }

        return contagem;
    }
}
