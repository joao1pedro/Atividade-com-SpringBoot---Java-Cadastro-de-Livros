package uf.br.webstore.webstore.endereco;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uf.br.webstore.webstore.pessoa.CadastraPessoaRequest;
import uf.br.webstore.webstore.pessoa.Pessoa;
import uf.br.webstore.webstore.pessoa.PessoaRepository;

@RestController
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping(value = "/endereco")
    @Transactional
    
    public ResponseEntity<Object> addEndereco(@RequestBody @Valid CadastraEnderecoRequest cadastraEnderecoRequest){
        
        //Optional <Endereco> enderecoOpt = enderecoRepository.findByEndereco(cadastraEnderecoRequest.getEndereco());
        Optional <Pessoa> pessoaOpt = pessoaRepository.findByCpf(cadastraEnderecoRequest.getPessoaCpf());
        Endereco endereco = cadastraEnderecoRequest.toModel(pessoaOpt.get());
        
        // Salvando os dados no banco de dados
        enderecoRepository.save(endereco);
  

        return  ResponseEntity.created(null).body("Endereco Cadastrado com Sucesso.");
    }
}
