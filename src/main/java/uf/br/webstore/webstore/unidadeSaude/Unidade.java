package uf.br.webstore.webstore.unidadeSaude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    @NotBlank
    private String nome;

    @Deprecated
    public Unidade(){
    }

    public Unidade(@NotBlank String nome) {
        this.nome = nome;
    }
    
}
