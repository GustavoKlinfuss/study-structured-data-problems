package JavaBasico;

final class Contador {
    private long _contador;

    Contador()
    {
        this._contador = 0;
    }

    public void zerarContador()
    {
        this._contador = 0;
    }

    public void incrementarContador(double valor)
    {
        this._contador += valor;
    }

    public long getValorContador()
    {
        return this._contador;
    }
}
