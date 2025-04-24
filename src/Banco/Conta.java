package Banco;

public abstract class Conta implements IConta {
    private static int SEQUENCIAL = 1;

    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf(">>> Depositado R$ %.2f na conta %d%n", valor, numero);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public abstract void sacar(double valor);

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }
}