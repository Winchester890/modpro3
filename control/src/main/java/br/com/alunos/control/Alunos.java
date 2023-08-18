package br.com.alunos.control;

public class Alunos {

    private String nome;
    private Integer idade;
    private Integer id;

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alunos(String nome, Integer idade, Integer id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }
}
