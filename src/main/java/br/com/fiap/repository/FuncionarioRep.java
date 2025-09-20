package br.com.fiap.repository;

import br.com.fiap.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRep extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}

