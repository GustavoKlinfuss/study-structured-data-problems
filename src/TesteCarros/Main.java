package TesteCarros;

class Automovel {
    protected String nome;

    protected String getNome()
    {
        return this.nome;
    };
}

class Carro extends Automovel {
    private String potencia;
    private String torque;

    Carro(String nome, String potencia, String torque)
    {
        this.nome = nome;
        this.potencia = potencia;
        this.torque = torque;
    }

    public String getPotencia() {
        return this.potencia;
    }

    public String getTorque() {
        return this.torque;
    }
}

class Motocicleta extends Automovel {
    private float cilindrada;

    Motocicleta(String nome, float cilindrada)
    {
        this.nome = nome;
        this.cilindrada = cilindrada;
    }

    public float getCilindrada()
    {
        return this.cilindrada;
    }
}


public class Main {

    public static void main(String[] args) {
        Carro camaro = new Carro("Chevrolet Camaro", "160cv", "500cv");
        Automovel jetta = new Carro("Volkswagen Jetta", "400cv", "500cv");
        Motocicleta mt03 = new Motocicleta("Yamaha MT-03 ABS", 320);

        Automovel[] a = {camaro, jetta, mt03};

        for (Automovel b : a) {
            System.out.print(b.getNome());
        }

        System.out.println(camaro.getNome() + " - " + camaro.getPotencia());
        System.out.println(jetta.getNome() + " - ");
    }
}
