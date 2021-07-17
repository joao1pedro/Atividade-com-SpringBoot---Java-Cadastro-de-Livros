package uf.br.webstore.webstore.livro;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import uf.br.webstore.webstore.autor.Autor;
import uf.br.webstore.webstore.categoria.Categoria;


public class CadastraLivroRequest {
    
    @NotBlank
    @Column(unique = true)
    String titulo;

    @NotBlank
    @Size(max = 500)
    String resumo;

    @NotBlank
    String sumario;

    @NotBlank
    @Column(unique = true)
    String isbn;

    @NotNull
    @Min(value = 100)
    int numeroDePaginas;
    
    @NotNull
    @Min(value = 20)
    double preco;

    @Future
    LocalDateTime dataDePublicacao;

    @NotBlank
    String nomeCategoria;
    
    @NotBlank
    String autorEmail;


    public CadastraLivroRequest(){
        
    }

    public CadastraLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
            @NotBlank String sumario, @NotBlank String isbn, @NotNull @Min(100) int numeroDePaginas,
            @NotNull @Min(20) double preco, @Future LocalDateTime dataDePublicacao, @NotBlank String nomeCategoria,
            @NotBlank String autorEmail) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.dataDePublicacao = dataDePublicacao;
        this.nomeCategoria = nomeCategoria;
        this.autorEmail = autorEmail;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public double getPreco() {
        return preco;
    }


    public LocalDateTime getDataDePublicacao() {
        return dataDePublicacao;
    }

    public String getNomeCategoria() {
        return nomeCategoria;

    }

    public String getAutorEmail() {
        return autorEmail;
    }

    @Override
    public String toString() {
        return "CadastraLivroRequest [autor=" + autorEmail + ", categoria=" + nomeCategoria + ", dataDePublicacao="
                + dataDePublicacao + ", isbn=" + isbn + ", numeroDePaginas=" + numeroDePaginas + ", preco=" + preco
                + ", resumo=" + resumo + ", sumario=" + sumario + ", titulo=" + titulo + "]";
    }

    public Livro toModel(Categoria categoria, Autor autor){
        return new Livro(this.titulo, this.resumo, this.sumario, this.isbn, this.numeroDePaginas, this.preco, this.dataDePublicacao, categoria, autor);
    }

}
