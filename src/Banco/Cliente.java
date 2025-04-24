package Banco;

public class Cliente {
    private String nome;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
