package br.com.leandro.SpringBootFirstProject.repository;

import br.com.leandro.SpringBootFirstProject.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
