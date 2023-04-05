package com.app.controller;

import com.app.model.entity.Automovel;
import com.app.model.service.AutomovelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automoveis")
public class AutomovelController {

    private final AutomovelService automovelService;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    @GetMapping
    public List<Automovel> listarAutomoveis() {
        return automovelService.listarAutomoveis();
    }

    @GetMapping("/{matricula}")
    public Automovel buscarPorMatricula(@PathVariable Long matricula) {
        return automovelService.buscarPorMatricula(matricula);
    }

    @PostMapping("/automoveis")
    public void salvarAutomovel(@RequestBody Automovel automovel) {
        automovelService.salvarAutomovel(automovel);
    }

    @PutMapping("/{matricula}")
    public void atualizarAutomovel(@PathVariable Long matricula, @RequestBody Automovel automovel) {
         automovelService.atualizarAutomovel(matricula, automovel);
    }

    @DeleteMapping("/{matricula}")
    public void excluirAutomovel(@PathVariable Long matricula) {
        automovelService.excluirAutomovel(matricula);
    }
}