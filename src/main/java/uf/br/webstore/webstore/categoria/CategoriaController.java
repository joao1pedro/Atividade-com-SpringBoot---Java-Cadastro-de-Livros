package uf.br.webstore.webstore.categoria;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    
    @Autowired
    //EntityManager entityManager;
    CategoriaRepository categoriaRepository;

    @PostMapping(value = "/categoria")
    @Transactional
    //ResponseEntity informa o erro a qual deve retornar
    public ResponseEntity<Object> addCategoria(@RequestBody @Valid CadastraCategoriaRequest cadastraCategoriaRequest){
      
        boolean existsCategoria = categoriaRepository.existsByNome(cadastraCategoriaRequest.getNome());

        if(existsCategoria){
            return ResponseEntity.badRequest().build();
            //return "Erro ao inserir usuário";
        }
   

        Categoria categoria = cadastraCategoriaRequest.toModel();
        
        // Salvando os dados no banco de dados
        //entityManager.persist(categoria);
        categoriaRepository.save(categoria);
  

        return  ResponseEntity.ok("Categoria Cadastrada com Sucesso.");
    }

   
}


