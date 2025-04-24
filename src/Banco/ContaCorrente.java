package Banco;

public class ContaCorrente extends Conta {
    private static final double TARIFA_SAQUE = 1.00;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        double total = valor + TARIFA_SAQUE;
        if (saldo >= total) {
            saldo -= total;
            System.out.printf(">>> Sacado R$ %.2f (tarifa R$ %.2f) da CC %d%n", valor, TARIFA_SAQUE, numero);
        } else {
            System.out.println("Saldo insuficiente para saque em Conta Corrente.");
        }
    }
}