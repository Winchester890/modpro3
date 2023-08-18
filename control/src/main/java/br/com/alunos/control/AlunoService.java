package br.com.alunos.control;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private List<Alunos> alunosList = new ArrayList<>();
    public List<Alunos> findByNome(String nome) {
        if (alunosList != null){
            return alunosList.stream()
                    .filter(alu -> alu.getNome().contains(nome))
                    .collect(Collectors.toList());
        }
        return alunosList;
    }

    public Alunos findAluno(String nome) throws NotFoundException {
        return findByNome(nome).stream()
                .filter(aluno -> aluno.equals(nome))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(nome));
    }

    public List<Alunos> findByIdade(Integer idade) {
        if (alunosList != null){
            return alunosList.stream()
                    .filter(alu -> alu.getIdade().equals(idade))
                    .collect(Collectors.toList());
        }
        return alunosList;
    }

    public Alunos findById(Integer id) throws IDNotFoundException{
        return alunosList.stream()
                .filter(alu -> alu.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IDNotFoundException(id));
    }

    public Integer add(final Alunos aluno) {
        if(aluno.getId() == null) {
            aluno.setId(alunosList.size() + 1);
        }
        alunosList.add(aluno);
        return aluno.getId();
    }

    public void update(final Alunos aluno) {
        alunosList.stream()
                .filter(alu -> alu.getId().equals(aluno.getId()))
                .forEach(alu -> alu.setNome(aluno.getNome()));
        alunosList.stream()
                .filter(alu -> alu.getId().equals(aluno.getId()))
                .forEach(alu -> alu.setIdade(aluno.getIdade()));
    }

    public void delete(Integer id) {
        alunosList.removeIf(alu -> alu.getId().equals(id));
    }

}
