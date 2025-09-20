package br.com.fiap.model.vo;

import br.com.fiap.model.PerfilInvestidor;

public class RespostaVO {
    private Long id;
    private String nome;
    private String email;
    private String perfilInvestidor;

    public RespostaVO(Long id, String nome, String email, PerfilInvestidor perfilInvestidor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfilInvestidor = perfilInvestidor.name();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getPerfilInvestidor() { return perfilInvestidor; }
}
