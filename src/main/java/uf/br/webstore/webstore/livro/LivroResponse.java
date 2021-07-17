package uf.br.webstore.webstore.livro;

public class LivroResponse {
    
    long id;

    String nome;

    public LivroResponse(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
