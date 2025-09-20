package br.com.fiap.model.vo;

import br.com.fiap.model.PerfilInvestidor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// VO para cadastro
public class CadastroClienteVO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @NotNull(message = "O perfil de investidor é obrigatório")
    private PerfilInvestidor perfilInvestidor;


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public PerfilInvestidor getPerfilInvestidor() { return perfilInvestidor; }
    public void setPerfilInvestidor(PerfilInvestidor perfilInvestidor) { this.perfilInvestidor = perfilInvestidor; }
}
