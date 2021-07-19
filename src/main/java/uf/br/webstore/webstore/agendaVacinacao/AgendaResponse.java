package uf.br.webstore.webstore.agendaVacinacao;

import java.time.LocalDateTime;

public class AgendaResponse {
    long id;
    String cpf;
    LocalDateTime dia;

    public AgendaResponse(long id, String cpf, LocalDateTime dia) {
        this.id = id;
        this.cpf = cpf;
        this.dia = dia;
    }

    public AgendaResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return cpf;
    }

    public LocalDateTime getDia() {
        return dia;
    }
}
