package br.com.fiap.cp1Api1.repositories;

import br.com.fiap.cp1Api1.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
