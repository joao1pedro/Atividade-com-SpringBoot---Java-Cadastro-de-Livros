package uf.br.webstore.webstore.agendaVacinacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uf.br.webstore.webstore.pessoa.Pessoa;
import uf.br.webstore.webstore.pessoa.PessoaRepository;
import uf.br.webstore.webstore.unidadeSaude.Unidade;
import uf.br.webstore.webstore.unidadeSaude.UnidadeRepository;

@RestController
public class AgendaController {
    @Autowired
    UnidadeRepository unidadeRepository;
    
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    AgendaRepository agendaRepository;

    @PostMapping(value = "/agenda")
    @Transactional
    public ResponseEntity<Object> addAgenda(@RequestBody @Valid CadastraAgendaRequest cadastraAgendaRequest){
        System.out.println(cadastraAgendaRequest.toString());
        
        Optional<Unidade>  unidadeOpt = unidadeRepository.findByNome(cadastraAgendaRequest.getUnidadeNome());
        Optional<Pessoa>  pessoaOpt = pessoaRepository.findByCpf(cadastraAgendaRequest.getPessoaCpf());
        
        if(unidadeOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Unidade inválida.");

        }  

        if(pessoaOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Pessoa inválida.");

        }

        Agenda agenda = cadastraAgendaRequest.toModel(unidadeOpt.get(), pessoaOpt.get());
        
        agendaRepository.save(agenda);

        return ResponseEntity.ok().body("Agenda criado com sucesso.");
    }

    @GetMapping(value = "/agenda")
    //Criar uma classe especifica AgendaResponse para enviar só o que quer exebir, se enviar Object, enviaria algo que vc nao quer
    public List<AgendaResponse> listaAgendas() {
        
        List<AgendaResponse> agendaResponse = new ArrayList<>();

        List<Agenda> agendaFromDb = agendaRepository.findAll();
        
        if(agendaFromDb.isEmpty()){
            return null;
        }

        for (Agenda agenda: agendaFromDb){
            agendaResponse.add(new AgendaResponse(agenda.id));
        }
        return agendaResponse;
    }

    @GetMapping(value = "/agenda/{idAgenda}")
    public ResponseEntity<Object> listDetalhesAgenda(@NotNull @PathVariable long idAgenda) {
        Optional<Agenda> agendaOpt =agendaRepository.findById(idAgenda);
    
        if(agendaOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        Agenda agendaFromDb = agendaOpt.get();
        ListaDetalhesAgenda detalhesAgenda = new ListaDetalhesAgenda(agendaFromDb.cpfPessoa, agendaFromDb.diaVacina);
        
        
        return ResponseEntity.ok(detalhesAgenda);
    }

}
