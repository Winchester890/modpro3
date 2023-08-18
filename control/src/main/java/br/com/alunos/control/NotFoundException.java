package br.com.alunos.control;

public class NotFoundException extends Exception {
    public NotFoundException(final String nome) {
        super("Aluno(a) " + nome + " não encontrado(a)!");
    }

}
