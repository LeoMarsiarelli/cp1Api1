package br.com.fiap.cp1Api1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/filmes")

public class FilmeController {

    @GetMapping()
    public String listarFilmes() {
        return "Lista de Filmes: Batman, Inception, Interstellar, Pecadores, Matrix";
    }

    @GetMapping("/recomendacao")
    public String recomendacao() {
        return "Filme recomendado de hoje: Pecadores";
    }
}