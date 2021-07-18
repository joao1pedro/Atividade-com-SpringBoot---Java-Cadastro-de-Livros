package uf.br.webstore.webstore.pessoa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Optional<Pessoa> findByEmail(String email);
    public boolean existsByEmail(String email);

    public Optional<Pessoa> findByCpf(String cpf);
    public boolean existsByCpf(String cpf);
    
}