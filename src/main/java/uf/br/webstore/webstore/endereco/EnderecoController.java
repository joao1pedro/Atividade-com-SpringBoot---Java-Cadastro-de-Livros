package uf.br.webstore.webstore.endereco;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping(value = "/endereco")
    @Transactional
    
    public ResponseEntity<Object> addEndereco(@RequestBody @Valid CadastraEnderecoRequest cadastraEnderecoRequest){
        
        /*
        boolean existsEndereco = enderecoRepository.existsByCep(cadastraEnderecoRequest.getCep());

        
        if(existsEndereco){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao inserir usuário.");
            //return "Erro ao inserir usuário";
        }
        */
        
        Endereco endereco = cadastraEnderecoRequest.toModel();
        
        // Salvando os dados no banco de dados
        enderecoRepository.save(endereco);
  

        return  ResponseEntity.created(null).body("Endereco Cadastrado com Sucesso.");
    }
}
