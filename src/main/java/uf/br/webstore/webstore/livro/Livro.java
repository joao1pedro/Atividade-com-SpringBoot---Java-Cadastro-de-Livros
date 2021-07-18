package uf.br.webstore.webstore.livro;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import uf.br.webstore.webstore.pessoa.Pessoa;
import uf.br.webstore.webstore.unidadeSaude.Unidade;

@Entity
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
        
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

    @NotNull
    @ManyToOne //muitos livros para uma categoria
    Unidade categoria;
    
    @NotNull
    @ManyToOne // muitos autores podem estar para 1 livro quanto muitos livros para muitos autores
    Pessoa autor;


    @Deprecated
    public Livro(){
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
            @NotBlank String isbn, @NotNull @Min(100) int numeroDePaginas, @NotNull @Min(20) double preco,
            @Future LocalDateTime dataDePublicacao, @NotNull Unidade categoria, @NotNull Pessoa autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }



}
