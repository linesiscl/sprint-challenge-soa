package br.com.fiap.controller;

import br.com.fiap.model.Alerta;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.PerfilInvestidor;
import br.com.fiap.repository.AlertaRep;
import br.com.fiap.repository.ClienteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRep alertaRepository;

    @Autowired
    private ClienteRep clienteRepository;

    //criar um alerta para clientes a partir de seus perfis de investidores
    @PostMapping("/enviar/{perfilCliente}")
    public ResponseEntity<String> enviarAlertaPorPerfil(
            @PathVariable String perfilCliente,
            @RequestParam String funcionarioEmail,
            @RequestParam String mensagem) {

        PerfilInvestidor perfil;
        try {
            perfil = PerfilInvestidor.valueOf(perfilCliente.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body("Perfil inválido! Use: CONSERVADOR, MODERADO ou ARROJADO.");
        }

        List<Cliente> clientes = clienteRepository.findAll()
                .stream()
                .filter(c -> c.getPerfilInvestidor() == perfil)
                .toList();

        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum cliente encontrado com o perfil: " + perfilCliente);
        }

        for (Cliente cliente : clientes) {
            Alerta alerta = new Alerta();
            alerta.setMensagem(mensagem);
            alerta.setFuncionarioEmail(funcionarioEmail);
            alerta.setClienteEmail(cliente.getEmail());
            alerta.setPerfilCliente(perfil.name());
            alertaRepository.save(alerta);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Alerta enviado com sucesso para clientes do perfil: " + perfilCliente);
    }

    //lista todos os alertas
    @GetMapping
    public ResponseEntity<List<Alerta>> listarTodos() {
        List<Alerta> alertas = alertaRepository.findAll();
        return ResponseEntity.ok(alertas);
    }

    //lista os alertas de um cliente específico a partir de seu email
    @GetMapping("/cliente/{email}")
    public ResponseEntity<List<Alerta>> listarAlertasPorCliente(@PathVariable String email) {
        List<Alerta> alertas = alertaRepository.findByClienteEmail(email);
        if (alertas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alertas);
        }
        return ResponseEntity.ok(alertas);
    }

    //lista os alertas a partir do perfil
    @GetMapping("/perfil/{perfil}")
    public ResponseEntity<List<Alerta>> listarAlertasPorPerfil(@PathVariable String perfil) {
        List<Alerta> alertas = alertaRepository.findByPerfilCliente(perfil);
        if (alertas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alertas);
        }
        return ResponseEntity.ok(alertas);
    }

    //deletar um alerta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (alertaRepository.existsById(id)) {
            alertaRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}

