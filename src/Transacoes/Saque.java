package Transacoes;

import Banco.Conta;

public class Saque implements Transacao {
    private Conta conta;
    private double valor;

    public Saque(Conta conta, double valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void executar() {
        conta.sacar(valor);
    }
}
