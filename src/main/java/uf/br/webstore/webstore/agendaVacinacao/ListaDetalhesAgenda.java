package uf.br.webstore.webstore.agendaVacinacao;

import java.time.LocalDateTime;

public class ListaDetalhesAgenda {
    String nome;
    LocalDateTime dia;
    public ListaDetalhesAgenda() {
        
    }

    public ListaDetalhesAgenda(String nome, LocalDateTime dia) {
        this.nome = nome;
        this.dia = dia;
    }

    public String getCpf() {
        return nome;
    }

    public void setCpf(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    
    
}
