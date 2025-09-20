package br.com.fiap.controller;

import br.com.fiap.model.Funcionario;
import br.com.fiap.repository.FuncionarioRep;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRep funcionarioRepository;

    //cadastro de funcionários
    @PostMapping("/cadastro")
    public Funcionario cadastrar(@RequestBody @Valid Funcionario tecnico) {
        return funcionarioRepository.save(tecnico);
    }

}

