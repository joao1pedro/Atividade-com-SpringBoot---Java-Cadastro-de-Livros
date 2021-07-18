package uf.br.webstore.webstore.unidadeSaude;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnidadeController {
    
    @Autowired
    //EntityManager entityManager;
    UnidadeRepository unidadeRepository;

    @PostMapping(value = "/unidade")
    @Transactional
    //ResponseEntity informa o erro a qual deve retornar
    public ResponseEntity<Object> addUnidade(@RequestBody @Valid CadastraUnidadeRequest cadastraUnidadeRequest){
      
        boolean existsUnidade = unidadeRepository.existsByNome(cadastraUnidadeRequest.getNome());

        if(existsUnidade){
            return ResponseEntity.badRequest().build();
            //return "Erro ao inserir usuário";
        }
   

        Unidade unidade = cadastraUnidadeRequest.toModel();
        
        // Salvando os dados no banco de dados
        //entityManager.persist(unidade);
        unidadeRepository.save(unidade);
  

        return  ResponseEntity.ok("Unidade Cadastrada com Sucesso.");
    }

   
}


