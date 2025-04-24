package Banco;

import Transacoes.*;
import Financiamento.SimuladorFinanc;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        Cliente cli1 = banco.cadastrarCliente("Alice");
        Cliente cli2 = banco.cadastrarCliente("Bob");
        Conta cc1 = banco.criarContaCorrente(cli1);
        Conta cp1 = banco.criarContaPoupanca(cli2);

        int opc;
        do {
            System.out.println("\n=== BANCO DIO ===");
            System.out.println("1) Depositar");
            System.out.println("2) Sacar");
            System.out.println("3) Transferir");
            System.out.println("4) Verificar Saldo");
            System.out.println("5) Simular Financiamento");
            System.out.println("0) Sair");
            System.out.print("Opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1: {
                    System.out.print("Conta nº: "); int nc = sc.nextInt();
                    System.out.print("Valor: "); double v = sc.nextDouble();
                    Conta c = banco.buscarConta(nc);
                    new Deposito(c, v).executar();
                    break;
                }
                case 2: {
                    System.out.print("Conta nº: "); int nc2 = sc.nextInt();
                    System.out.print("Valor: "); double v2 = sc.nextDouble();
                    Conta c2 = banco.buscarConta(nc2);
                    new Saque(c2, v2).executar();
                    break;
                }
                case 3: {
                    System.out.print("Origem nº: "); int no = sc.nextInt();
                    System.out.print("Destino nº: "); int nd = sc.nextInt();
                    System.out.print("Valor: "); double v3 = sc.nextDouble();
                    Conta o = banco.buscarConta(no);
                    Conta d = banco.buscarConta(nd);
                    new Transferencia(o, d, v3).executar();
                    break;
                }
                case 4: {
                    System.out.print("Conta nº: ");
                    int nc5 = sc.nextInt();
                    Conta c5 = banco.buscarConta(nc5);
                    if (c5 != null) {
                        System.out.printf(">>> Saldo da conta %d: R$ %.2f%n",
                                          c5.getNumero(), c5.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Conta nº: "); int nf = sc.nextInt();
                    System.out.print("Valor financiamento: "); double vf = sc.nextDouble();
                    System.out.print("Meses: "); int m = sc.nextInt();
                    Conta f = banco.buscarConta(nf);
                    SimuladorFinanc.simular(f, vf, m);
                    break;
                }
                case 0: 
                    System.out.println("Encerrando...");
                    break;
                default: 
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 0);

        sc.close();
    }
}
