package uf.br.webstore.webstore.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
    public Optional<Autor> findByEmail(String email);
    public boolean existsByEmail(String email);
}