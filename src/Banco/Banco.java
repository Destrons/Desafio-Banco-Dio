package Banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public Cliente cadastrarCliente(String nome, String cpf) {
        Cliente c = new Cliente(nome, cpf);
        clientes.add(c);
        return c;
    }

    public Conta criarContaCorrente(Cliente cliente) {
        Conta cc = new ContaCorrente(cliente);
        contas.add(cc);
        return cc;
    }

    public Conta criarContaPoupanca(Cliente cliente) {
        Conta cp = new ContaPoupanca(cliente);
        contas.add(cp);
        return cp;
    }

    public Conta buscarConta(int numero) {
        return contas.stream()
                     .filter(c -> c.getNumero() == numero)
                     .findFirst()
                     .orElse(null);
    }
}