package br.com.fiap.controller;

import br.com.fiap.model.Cliente;
import br.com.fiap.model.vo.CadastroClienteVO;
import br.com.fiap.model.vo.LoginVO;
import br.com.fiap.model.vo.RespostaVO;
import br.com.fiap.repository.ClienteRep;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRep clienteRepository;

    //criar o perfil do cliente
    @PostMapping("/cadastro")
    public RespostaVO cadastrar(@RequestBody @Valid CadastroClienteVO vo) {
        Cliente cliente = new Cliente();
        cliente.setNome(vo.getNome());
        cliente.setEmail(vo.getEmail());
        cliente.setSenha(vo.getSenha());
        cliente.setPerfilInvestidor(vo.getPerfilInvestidor());

        Cliente salvo = clienteRepository.save(cliente);

        return new RespostaVO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getPerfilInvestidor()
        );
    }

    //listar todos os clientes, mas sem expor a senha
    @GetMapping
    public List<RespostaVO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(c -> new RespostaVO(
                        c.getId(),
                        c.getNome(),
                        c.getEmail(),
                        c.getPerfilInvestidor()
                ))
                .collect(Collectors.toList());
    }

    //login de cliente
    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginVO loginVO) {
        Cliente cliente = clienteRepository.findByEmail(loginVO.getEmail());
        if (cliente != null && cliente.getSenha().equals(loginVO.getSenha())) {
            return "Login bem-sucedido! Perfil: " + cliente.getPerfilInvestidor();
        } else {
            return "Email ou senha inválidos!";
        }
    }
}

