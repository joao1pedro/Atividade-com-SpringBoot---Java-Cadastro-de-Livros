package uf.br.webstore.webstore.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import uf.br.webstore.webstore.pessoa.Pessoa;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

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

    @NotNull
    @ManyToOne
    Pessoa pessoaCpf;

    @Deprecated
    public Endereco(){

    }

    public Endereco(@NotBlank(message = "Endereço inválido.") String endereco, @NotBlank String estado,
            @NotBlank String cidade, @NotBlank String bairro, int numero, String complemento, @NotBlank String cep,
            @NotBlank Pessoa pessoaCpf) {
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.pessoaCpf = pessoaCpf;
    }

    
}
