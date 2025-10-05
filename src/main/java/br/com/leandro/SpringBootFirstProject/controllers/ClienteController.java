package br.com.leandro.SpringBootFirstProject.controllers;

import br.com.leandro.SpringBootFirstProject.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Lista temporária só pra simular um "banco em memória"
    private List<Cliente> clientes = new ArrayList<>();

    // CREATE
    @PostMapping
    public ResponseEntity<String> criarCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return ResponseEntity.ok("Cliente adicionado com sucesso: " + cliente.getNome());
    }

    // READ - todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clientes);
    }

    // READ - individual (por nome, só pra exemplo)
    @GetMapping("/{nome}")
    public ResponseEntity<Cliente> buscarPorNome(@PathVariable String nome) {
        return clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{nome}")
    public ResponseEntity<String> atualizarCliente(@PathVariable String nome, @RequestBody Cliente novoCliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNome(novoCliente.getNome());
                c.setIdade(novoCliente.getIdade());
                return ResponseEntity.ok("Cliente atualizado: " + c.getNome());
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{nome}")
    public ResponseEntity<String> deletarCliente(@PathVariable String nome) {
        boolean removido = clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
        if (removido) {
            return ResponseEntity.ok("Cliente removido com sucesso: " + nome);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
