package uf.br.webstore.webstore.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AutorController {

    // Persistir no banco de dados


    // interface para mnanusear objetos no banco
    @Autowired
    AutorRepository autorRepository;

    @PostMapping(value = "/autor")
    @Transactional
    //ResponseEntity informa o erro a qual deve retornar
    public ResponseEntity<Object> addAutor(@RequestBody @Valid CadastraAutorRequest cadastraAutorRequest){
        
        boolean existsAutor = autorRepository.existsByEmail(cadastraAutorRequest.getEmail());

        if(existsAutor){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao inserir usuário.");
            //return "Erro ao inserir usuário";
        }
        
        Autor autor = cadastraAutorRequest.toModel();
        
        // Salvando os dados no banco de dados
        autorRepository.save(autor);
  

        return  ResponseEntity.created(null).body("Autor Cadastrado com Sucesso.");
    }

   
}
