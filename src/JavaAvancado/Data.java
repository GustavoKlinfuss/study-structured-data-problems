package JavaAvancado;

public class Data {
    private final int _dia;
    private final int _mes;
    private final int _ano;
    private String _formato;
    private char[] _data;

    public Data(int dia, int mes, int ano){
        this._dia = dia;
        this._mes = mes;
        this._ano = ano;
        this._formato = "dd/mm/aaaa";
    }

    public void definirFormato(String formato) {
        this._formato = formato;
    }

    public void imprimir() {
        this._data = new char[_formato.length()];
        char[] formato = _formato.toCharArray();

        for (int i = 0; i < _formato.length(); i++) {
            int tamanhoConjunto = contarConjuntoDeLetras(formato, formato[i], i);

            if (formato[i] == 'd')
                preencherComNumeros(tamanhoConjunto, i, _dia);
            else if (formato[i] == 'm')
                preencherComNumeros(tamanhoConjunto, i, _mes);
            else if (formato[i] == 'a')
                preencherComNumeros(tamanhoConjunto, i, _ano);
            else {
                System.arraycopy(_formato.toCharArray(), i, _data, i, tamanhoConjunto);
            }

            i += tamanhoConjunto - 1;
        }

        for (char c: _data) {
            System.out.print(c);
        }
        System.out.println();
    }

    private void preencherComNumeros(int tamanhoConjunto, int index, int informacaoData) {
        for (int j = 0; j < tamanhoConjunto; j++) {
            int resultado = informacaoData % Gustavo.pow(10, tamanhoConjunto - j) / Gustavo.pow(10, (tamanhoConjunto - j - 1));
            this._data[index + j] = Character.forDigit(resultado, 10);
        }
    }

    private int contarConjuntoDeLetras(char[] formato, char letra, int index) {
        if (formato.length > index && formato[index] == letra)
            return 1 + contarConjuntoDeLetras(formato, formato[index], index + 1);
        else
            return 0;
    }


}

class Gustavo {
    public static int pow(int base, int expoente)
    {
        int soma = 1;

        for (int i = 0; i < expoente; i++) {
            soma *= base;
        }

        return soma;
    }
}
