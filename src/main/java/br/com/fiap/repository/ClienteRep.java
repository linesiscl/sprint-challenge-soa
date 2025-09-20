package br.com.fiap.repository;

import br.com.fiap.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRep extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}

