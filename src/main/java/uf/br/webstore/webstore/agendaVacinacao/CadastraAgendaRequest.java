package uf.br.webstore.webstore.agendaVacinacao;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import uf.br.webstore.webstore.pessoa.Pessoa;
import uf.br.webstore.webstore.unidadeSaude.Unidade;

public class CadastraAgendaRequest {
    @Future
    LocalDateTime diaVacina;

    @Future
    LocalDateTime dataDeAgendamento;

    @NotBlank
    String unidadeNome;
    
    @NotBlank
    String pessoaCpf;

    @NotBlank
    String nome;

    public CadastraAgendaRequest() {
        
    }

    public CadastraAgendaRequest(@Future LocalDateTime diaVacina, @Future LocalDateTime dataDeAgendamento,
            @NotBlank String unidadeNome, @NotBlank String pessoaCpf) {
        this.diaVacina = diaVacina;
        this.dataDeAgendamento = dataDeAgendamento;
        this.unidadeNome = unidadeNome;
        this.pessoaCpf = pessoaCpf;
    }

    public LocalDateTime getDiaVacina() {
        return diaVacina;
    }

    public void setDiaVacina(LocalDateTime diaVacina) {
        this.diaVacina = diaVacina;
    }

    public LocalDateTime getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(LocalDateTime dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public String getUnidadeNome() {
        return unidadeNome;
    }

    public void setUnidadeNome(String unidadeNome) {
        this.unidadeNome = unidadeNome;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CadastraAgendaRequest [cpf=" + pessoaCpf + ", dia=" + diaVacina + ", unidade de saude="
                + unidadeNome + ", data de agendamento=" + dataDeAgendamento + "]";
    }

    /*
    public Agenda toModel(Unidade unidade, Pessoa pessoa){
        return new Agenda(this.diaVacina, this.dataDeAgendamento,unidade,pessoa);
    }*/

    public Agenda toModel(Unidade unidade, Pessoa pessoa){
        return new Agenda(this.diaVacina, this.dataDeAgendamento,unidade,pessoa, this.nome);
    }
}
