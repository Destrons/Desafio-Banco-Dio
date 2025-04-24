package Financiamento;

import Banco.Conta;

public class SimuladorFinanc {
        /**
     * Juros simples de acordo com saldo:
     * até R$1000 → 2% a.m.
     * de 1000 a 5000 → 1.5% a.m.
     * acima de 5000 → 1% a.m.
     */
    public static void simular(Conta conta, double valor, int meses) {
        double taxa;
        double saldo = conta.getSaldo();
        if (saldo <= 1000) taxa = 0.02;
        else if (saldo <= 5000) taxa = 0.015;
        else taxa = 0.01;

        double montante = valor * Math.pow(1 + taxa, meses);
        double parcela = montante / meses;

        System.out.println("--- Simulação de Financiamento ---");
        System.out.printf("Conta: %d | Saldo: R$ %.2f%n", conta.getNumero(), saldo);
        System.out.printf("Valor solicitado: R$ %.2f, Meses: %d, Taxa: %.2f%%%n",
                          valor, meses, taxa * 100);
        System.out.printf("Montante a pagar: R$ %.2f | Parcela: R$ %.2f%n",
                          montante, parcela);
        System.out.println("----------------------------------");
    }
}

