package br.com.alunos.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    AlunoService alunoService = new AlunoService();
    private List<Alunos> alunosList = new ArrayList<>();

    @GetMapping("/nome")
    public List<Alunos> findByNome(@RequestParam(required = false) String nome) {
        try {
            alunosList = (List<Alunos>) alunoService.findAluno(nome);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return alunosList;
    }

    @GetMapping("/idade")
    public List<Alunos> findByIdade(@RequestParam(required = false) Integer idade) {
        List<Alunos> alunosList = alunoService.findByIdade(idade);
        return alunosList;
    }
    @GetMapping("/{id}")
    public Alunos findById(@PathVariable("id") Integer id) {
        try {
            alunosList = (List<Alunos>) alunoService.findById(id);
        } catch (IDNotFoundException e) {
            e.printStackTrace();
        }
        return (Alunos) alunosList;
    }

    @PostMapping
    public Integer add(@RequestBody final Alunos aluno) {
        Integer alunoAdd = alunoService.add(aluno);
        return alunoAdd;
    }
    @PutMapping
    public void update(@RequestBody final Alunos aluno) {
        alunoService.update(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        alunoService.delete(id);
    }

}
