package br.com.alunos.control;

public class IDNotFoundException extends Exception{
    public IDNotFoundException(Integer id) {
        super("Aluno(a) com o ID " + id + " não encontrado(a)!");
    }
}
