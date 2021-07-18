package uf.br.webstore.webstore.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;

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

    @Deprecated
    public Endereco(){

    }

    public Endereco(@NotBlank(message = "Endereço inválido.") String endereco, @NotBlank String estado,
            @NotBlank String cidade, @NotBlank String bairro, int numero, String complemento, @NotBlank String cep) {
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    
}
