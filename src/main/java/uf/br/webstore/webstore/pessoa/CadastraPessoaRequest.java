package uf.br.webstore.webstore.pessoa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

public class CadastraPessoaRequest {
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
    

    public CadastraPessoaRequest(@NotBlank(message = "Nome em formato inválido") String nome, @NotBlank @CPF String cpf,
            int idade, @NotNull char sexo, @NotNull char grupoRisco, @NotBlank @Email String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.grupoRisco = grupoRisco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGrupoRisco() {
        return grupoRisco;
    }

    public void setGrupoRisco(char grupoRisco) {
        this.grupoRisco = grupoRisco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Pessoa toModel(){
        return new Pessoa(this.nome, this.cpf, this.idade, this.sexo, this.grupoRisco, this.email);
    }

    
}
