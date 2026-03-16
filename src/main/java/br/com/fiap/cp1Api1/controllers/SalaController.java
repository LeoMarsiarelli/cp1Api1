package br.com.fiap.cp1Api1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping()
public class SalaController {

    @GetMapping("/salas")
    public String statusSalas() {
        return "Status das Salas: Sala 01 (Livre), Sala 02 (Sessão em andamento)";
    }
}
