package uf.br.webstore.webstore.livro;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import uf.br.webstore.webstore.autor.Autor;
import uf.br.webstore.webstore.autor.AutorRepository;
import uf.br.webstore.webstore.categoria.Categoria;
import uf.br.webstore.webstore.categoria.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController{

    // @Autowired
    // AutorRepository autorRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @PostMapping(value = "/livro")
    @Transactional
    public ResponseEntity<Object> addLivro(@RequestBody @Valid CadastraLivroRequest cadastraLivroRequest){
        
        System.out.println(cadastraLivroRequest.toString());
        
        Optional<Categoria>  categoriaOpt = categoriaRepository.findByNome(cadastraLivroRequest.getNomeCategoria());
        Optional<Autor>  autorOpt = autorRepository.findByEmail(cadastraLivroRequest.getAutorEmail());
        
        if(categoriaOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Categoria inválida.");

        }  

        if(autorOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Autor inválida.");

        }

        Livro livro = cadastraLivroRequest.toModel(categoriaOpt.get(), autorOpt.get());
        
        livroRepository.save(livro);

        return ResponseEntity.ok().body("Livro criado com sucesso.");
    }

    @GetMapping(value = "/livros")
    //Criar uma classe especifica LivroResponse para enviar só o que quer exebir, se enviar Object, enviaria algo que vc nao quer
    public List<LivroResponse> listaLivros() {
        
        List<LivroResponse> livroResponse = new ArrayList<>();

        List<Livro> livroFromDb = livroRepository.findAll();
        
        if(livroFromDb.isEmpty()){
            return null;
        }

        for (Livro livro: livroFromDb){
            livroResponse.add(new LivroResponse(livro.id, livro.titulo));
        }
        return livroResponse;
    }

    @GetMapping(value = "/livro/{idLivro}")
    public ResponseEntity<Object> listDetalhesLivro(@NotNull @PathVariable long idLivro) {
        Optional<Livro> livroOpt =livroRepository.findById(idLivro);
    
        if(livroOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        Livro livroFromDb = livroOpt.get();
        ListaDetalhesLivro detalhesLivro = new ListaDetalhesLivro(livroFromDb.titulo, livroFromDb.numeroDePaginas, livroFromDb.preco);
        
        
        return ResponseEntity.ok(detalhesLivro);
    }

}