package uf.br.webstore.webstore.categoria;

import javax.validation.constraints.NotBlank;

public class CadastraCategoriaRequest {
    
    @NotBlank
    private String nome;

    @Deprecated // nao sera utilizado
    public  CadastraCategoriaRequest() {
    }

    public CadastraCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

}
