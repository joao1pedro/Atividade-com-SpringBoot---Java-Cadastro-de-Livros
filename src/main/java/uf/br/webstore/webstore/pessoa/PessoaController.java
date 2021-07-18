package uf.br.webstore.webstore.pessoa;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PessoaController {

    // Persistir no banco de dados


    // interface para mnanusear objetos no banco
    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping(value = "/pessoa")
    @Transactional
    //ResponseEntity informa o erro a qual deve retornar
    public ResponseEntity<Object> addPessoa(@RequestBody @Valid CadastraPessoaRequest cadastraPessoaRequest){
        
        boolean existsPessoa = pessoaRepository.existsByEmail(cadastraPessoaRequest.getEmail());

        if(existsPessoa){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao inserir usuário.");
            //return "Erro ao inserir usuário";
        }
        
        Pessoa pessoa = cadastraPessoaRequest.toModel();
        
        // Salvando os dados no banco de dados
        pessoaRepository.save(pessoa);
  

        return  ResponseEntity.created(null).body("Pessoa Cadastrado com Sucesso.");
    }

   
}
