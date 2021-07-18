package uf.br.webstore.webstore.unidadeSaude;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    
    
    public boolean existsByNome(String nome);
    public Optional<Unidade> findByNome(String nome);
}