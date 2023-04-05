package com.app.model.service;

import com.app.model.entity.Automovel;
import com.app.model.repository.AutomovelRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovelService {

    private final AutomovelRepository automovelRepository;

    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public List<Automovel> listarAutomoveis() {
        return automovelRepository.findAll();
    }

    public Automovel buscarPorMatricula(Long matricula) {
        return automovelRepository.findById(matricula).orElse(null);
    }

    public void salvarAutomovel(Automovel automovel) {
        automovelRepository.save(automovel);
    }

    public void excluirAutomovel(Long matricula) {
        automovelRepository.deleteById(matricula);
    }
    public void atualizarAutomovel(Long matricula, Automovel automovel) {
        Automovel automovelExistente = automovelRepository.findById(matricula)
                .orElseThrow(() -> new ResourceNotFoundException("Automóvel não encontrado com a matrícula: " + matricula));

        automovelExistente.setAno(automovel.getAno());
        automovelExistente.setMarca(automovel.getMarca());
        automovelExistente.setModelo(automovel.getModelo());
        automovelExistente.setPlaca(automovel.getPlaca());

        automovelRepository.save(automovelExistente);
    }
}