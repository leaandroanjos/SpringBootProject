package br.com.leandro.SpringBootFirstProject.service;

import br.com.leandro.SpringBootFirstProject.model.Cliente;
import br.com.leandro.SpringBootFirstProject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
