package uf.br.webstore.webstore.endereco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    public Optional<Endereco> findByCep(String cep);
    public boolean existsByCep(String cep);
}
