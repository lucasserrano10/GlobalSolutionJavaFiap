package model;

public class Usuario {
    private String nome;
    private int idade;
    private boolean grupoDeRisco;

    public Usuario(String nome, int idade, boolean grupoDeRisco) {
        this.nome = nome;
        this.idade = idade;
        this.grupoDeRisco = grupoDeRisco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isGrupoDeRisco() {
        return grupoDeRisco;
    }
}
