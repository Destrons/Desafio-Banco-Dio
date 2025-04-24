package Banco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.printf(">>> Sacado R$ %.2f da CP %d%n", valor, numero);
        } else {
            System.out.println("Saldo insuficiente para saque em Poupança.");
        }
    }
}