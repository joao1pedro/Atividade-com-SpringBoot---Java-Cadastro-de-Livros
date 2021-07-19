package uf.br.webstore.webstore.agendaVacinacao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import uf.br.webstore.webstore.pessoa.Pessoa;
import uf.br.webstore.webstore.unidadeSaude.Unidade;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Future
    LocalDateTime diaVacina;

    @Future
    LocalDateTime dataDeAgendamento;

    @NotNull
    @ManyToOne //muitos livros para uma unidade
    Unidade unidade;
    
    @NotNull
    @ManyToOne // muitos pessoaes podem estar para 1 livro quanto muitos livros para muitos pessoaes
    Pessoa pessoa;

    @NotBlank
    String cpfPessoa;


    @Deprecated
    public Agenda(){
        
    }

    public Agenda(@Future LocalDateTime diaVacina, @Future LocalDateTime dataDeAgendamento, @NotNull Unidade unidade,
            @NotNull Pessoa pessoa) {
        this.diaVacina = diaVacina;
        this.dataDeAgendamento = dataDeAgendamento;
        this.unidade = unidade;
        this.pessoa = pessoa;
    }

    public Agenda(@Future LocalDateTime diaVacina, @Future LocalDateTime dataDeAgendamento, @NotNull Unidade unidade,
            @NotNull Pessoa pessoa, @NotBlank String cpfPessoa) {
        this.diaVacina = diaVacina;
        this.dataDeAgendamento = dataDeAgendamento;
        this.unidade = unidade;
        this.pessoa = pessoa;
        this.cpfPessoa = cpfPessoa;
    }

    

    
}
