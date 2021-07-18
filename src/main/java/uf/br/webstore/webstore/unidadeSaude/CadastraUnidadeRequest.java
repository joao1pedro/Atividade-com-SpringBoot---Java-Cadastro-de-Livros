package uf.br.webstore.webstore.unidadeSaude;

import javax.validation.constraints.NotBlank;

public class CadastraUnidadeRequest {
    
    @NotBlank
    private String nome;

    @Deprecated // nao sera utilizado
    public  CadastraUnidadeRequest() {
    }

    public CadastraUnidadeRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Unidade toModel(){
        return new Unidade(this.nome);
    }

    public String getNome() {
        return nome;
    }

}
