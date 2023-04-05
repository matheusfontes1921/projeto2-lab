package com.app.config;

import com.app.model.entity.Automovel;
import com.app.model.repository.AutomovelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private AutomovelRepository carroRepository;

    public TestConfig(AutomovelRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Automovel automovel1 = new Automovel(1L, "2022", "Ford", "EcoSport", "ABC-1234");
        Automovel automovel2 = new Automovel(2L, "2021", "Chevrolet", "Onix", "DEF-5678");
        Automovel automovel3 = new Automovel(3L, "2020", "Volkswagen", "Gol", "GHI-9012");
        Automovel automovel4 = new Automovel(4L, "2019", "Toyota", "Corolla", "JKL-3456");
        Automovel automovel5 = new Automovel(5L, "2018", "Fiat", "Uno", "MNO-7890");

        carroRepository.saveAll(Arrays.asList(automovel1, automovel2, automovel3, automovel4, automovel5));

    }
}
