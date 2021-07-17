package uf.br.webstore.webstore.autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "Nome em formato inválido") //Permite que nao seja vazias
    private String nome;
    
    @NotBlank
    @Email //Permite só string no layout de e-mail
    private String email;
    
    @NotBlank
    @Size(max = 400) // o tamanho máximo de caracteres
    private String descricao;

    @PastOrPresent // Data presente ou futuro, nao pode ser anterior
    LocalDateTime dataCriacao = LocalDateTime.now(); // pega o local exato que o Autor for criado

    @Deprecated
    public Autor(){

    }

    public Autor(@NotBlank(message = "Nome em formato inválido") String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        
    }


}
