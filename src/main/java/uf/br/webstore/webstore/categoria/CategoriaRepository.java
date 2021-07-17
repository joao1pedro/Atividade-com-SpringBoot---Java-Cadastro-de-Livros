package uf.br.webstore.webstore.categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    
    public boolean existsByNome(String nome);
    public Optional<Categoria> findByNome(String nome);
}