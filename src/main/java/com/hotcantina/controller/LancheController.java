package com.hotcantina.controller;

import com.hotcantina.dto.LancheRequestDTO;
import com.hotcantina.dto.LancheResponseDTO;
import com.hotcantina.dto.LancheResumoDTO;
import com.hotcantina.model.Lanche;
import com.hotcantina.service.LancheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Cadastra um novo lanche no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanche cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos (Nome menor que 2 letras ou maior que 150 | Preco menor que 0)."),
    })

    @PostMapping()
    public LancheResponseDTO cadastrar (@Valid @RequestBody LancheRequestDTO lanche){
        return lancheService.cadastrar(lanche);
    }

    @Operation(summary = "Lista todos os lanches filtrando apenas o nome e o preco.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanches listados com sucesso.")
    })
    @GetMapping()
    public List<LancheResumoDTO> listar (){
        return lancheService.listar();
    }

    @Operation(summary = "Busca um lanche pelo id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanche encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Não tem lanche cadastrado com esse id.")
    })
    @GetMapping("/{id}")
    public Optional<Lanche> buscarPorId(@PathVariable Long id){
        return lancheService.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um lanche ja existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanche atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos (Nome menor que 2 letras ou maior que 150 | Preco <= 0)."),
            @ApiResponse(responseCode = "404", description = "Não tem lanche cadastrado com esse id."),
    })
    @PutMapping("/{id}")
    public LancheResponseDTO atualizar (@PathVariable Long id, @Valid @RequestBody LancheRequestDTO novo){
        return lancheService.atualizar(id,novo);
    }

    @Operation(summary = "Exclui um lanche cadastrado do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanche removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não tem lanche cadastrado com esse id.")
    })
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        lancheService.excluir(id);
    }
}
