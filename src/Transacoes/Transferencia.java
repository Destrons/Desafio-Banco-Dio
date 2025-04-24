package Transacoes;

import Banco.Conta;

public class Transferencia implements Transacao {
    private Conta origem;
    private Conta destino;
    private double valor;

    public Transferencia(Conta origem, Conta destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public void executar() {
        origem.sacar(valor);
        destino.depositar(valor);
        System.out.printf(">>> Transferido R$ %.2f da conta %d para %d%n",
                          valor, origem.getNumero(), destino.getNumero());
    }
}
