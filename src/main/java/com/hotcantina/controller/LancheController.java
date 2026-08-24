package com.hotcantina.controller;

import com.hotcantina.dto.LancheRequestDTO;
import com.hotcantina.dto.LancheResponseDTO;
import com.hotcantina.dto.LancheResumoDTO;
import com.hotcantina.model.Lanche;
import com.hotcantina.service.LancheService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Lanches", description = "Controle de lanches da cantina")
@RestController
@RequestMapping("/")
public class LancheController {

    @Autowired
    LancheService lancheService;

    @PostMapping()
    public LancheResponseDTO cadastrar (@Valid @RequestBody LancheRequestDTO lanche){
        return lancheService.cadastrar(lanche);
    }

    @GetMapping()
    public List<LancheResumoDTO> listar (){
        return lancheService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Lanche> buscarPorId(@PathVariable Long id){
        return lancheService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public LancheResponseDTO atualizar (@PathVariable Long id, @RequestBody LancheRequestDTO novo){
        return lancheService.atualizar(id,novo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        lancheService.excluir(id);
    }
}
