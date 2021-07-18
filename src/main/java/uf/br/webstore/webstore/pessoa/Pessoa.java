package uf.br.webstore.webstore.pessoa;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import uf.br.webstore.webstore.endereco.Endereco;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "Nome em formato inválido") //Permite que nao seja vazias
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NumberFormat
    private int idade;

    @NotNull
    private char sexo;

    @NotNull
    private char grupoRisco;
    
    @NotBlank
    @Email //Permite só string no layout de e-mail
    private String email;

    @PastOrPresent // Data presente ou futuro, nao pode ser anterior
    LocalDateTime dataCriacao = LocalDateTime.now(); // pega o local exato que o Autor for criado

    @Deprecated
    public Pessoa(){

    }

    public Pessoa(@NotBlank(message = "Nome em formato inválido") String nome, @NotBlank @CPF String cpf, int idade,
            @NotNull char sexo, @NotNull char grupoRisco, @NotBlank @Email String email,
            @PastOrPresent LocalDateTime dataCriacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.grupoRisco = grupoRisco;
        this.email = email;
        this.dataCriacao = dataCriacao;
    }

    public Pessoa(@NotBlank(message = "Nome em formato inválido") String nome, @NotBlank @CPF String cpf, int idade,
            @NotNull char sexo, @NotNull char grupoRisco, @NotBlank @Email String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.grupoRisco = grupoRisco;
        this.email = email;
    }

    /*
    public Pessoa(@NotBlank(message = "Nome em formato inválido") String nome, @NotBlank @CPF String cpf, int idade,
            @NotNull char sexo, @NotNull char grupoRisco, @NotBlank @Email String email, @NotNull Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.grupoRisco = grupoRisco;
        this.email = email;
        this.endereco = endereco;
    }*/

    
    
}
