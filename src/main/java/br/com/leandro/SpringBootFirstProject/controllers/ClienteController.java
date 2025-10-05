package br.com.leandro.SpringBootFirstProject.controllers;

import br.com.leandro.SpringBootFirstProject.model.Cliente;
import br.com.leandro.SpringBootFirstProject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Cliente c = service.buscar(id);
        return (c != null) ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente existente = service.buscar(id);
        if (existente == null) return ResponseEntity.notFound().build();
        cliente.setId(id);
        return ResponseEntity.ok(service.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
