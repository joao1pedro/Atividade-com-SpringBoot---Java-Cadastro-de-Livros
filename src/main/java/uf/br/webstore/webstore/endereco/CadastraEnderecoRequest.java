package uf.br.webstore.webstore.endereco;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;

public class CadastraEnderecoRequest {
    @NotBlank(message = "Endereço inválido.")
    private String endereco;

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;

    @NotBlank
    private String bairro;

    @NumberFormat
    private int numero;

    private String complemento;

    @NotBlank
    private String cep;

    @Deprecated
    public CadastraEnderecoRequest() {

    }

    public CadastraEnderecoRequest(@NotBlank(message = "Endereço inválido.") String endereco, @NotBlank String estado,
            @NotBlank String cidade, @NotBlank String bairro, int numero, String complemento, @NotBlank String cep) {
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco toModel() {
        return new Endereco(this.endereco, this.estado, this.cidade,
        this.bairro, this.numero,this.complemento, this.cep);
    }

    
}
