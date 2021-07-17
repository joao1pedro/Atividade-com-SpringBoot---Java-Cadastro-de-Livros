package uf.br.webstore.webstore.livro;

public class ListaDetalhesLivro {
    
    String titulo;
    int numeroDePaginas;
    double preco;

    public ListaDetalhesLivro(){
        
    }

    public ListaDetalhesLivro(String titulo, int numeroDePaginas, double preco) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }


    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public double getPreco() {
        return preco;
    }

}
