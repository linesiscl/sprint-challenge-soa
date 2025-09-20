package br.com.fiap.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A mensagem não pode estar vazia")
    @Size(max = 255, message = "A mensagem deve ter no máximo 255 caracteres")
    private String mensagem;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Email(message = "Email do funcionário inválido")
    @NotBlank(message = "O email do funcionário é obrigatório")
    private String funcionarioEmail;

    @NotBlank
    private String clienteEmail;

    @NotBlank(message = "O perfil do cliente é obrigatório")
    private String perfilCliente; //conservador, moderado, arrojado


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getFuncionarioEmail() { return funcionarioEmail; }
    public void setFuncionarioEmail(String funcionarioEmail) { this.funcionarioEmail = funcionarioEmail; }

    public String getClienteEmail() { return clienteEmail; }
    public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }

    public String getPerfilCliente() { return perfilCliente; }
    public void setPerfilCliente(String perfilCliente) { this.perfilCliente = perfilCliente; }
}
