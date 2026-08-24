package com.hotcantina.service;

import com.hotcantina.dto.LancheRequestDTO;
import com.hotcantina.dto.LancheResponseDTO;
import com.hotcantina.dto.LancheResumoDTO;
import com.hotcantina.exception.RecursoNaoEncontradoException;
import com.hotcantina.model.Lanche;
import com.hotcantina.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

    @Autowired
    LancheRepository lancheRepository;

    public LancheResponseDTO toResponseDTO(Lanche lanche) {
        return new LancheResponseDTO(
                lanche.getId(),
                lanche.getNome(),
                lanche.getDescricao(),
                lanche.getPreco()
        );
    }

    public LancheResumoDTO toResumoDTO(Lanche lanche) {
        return new LancheResumoDTO(
              lanche.getId(), lanche.getNome(), lanche.getPreco()
        );
    }



    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        Lanche lanche = Lanche.builder().nome(dto.nome()).descricao(dto.descricao()).preco(dto.preco()).build();
        Lanche salvo = lancheRepository.save(lanche);
        return toResponseDTO(salvo);
    }

    public List<LancheResumoDTO> listar(String nome){
        if(nome != null){
            return lancheRepository.findByNome(nome)
                    .stream()
                    .map(this::toResumoDTO)
                    .toList();
        }else{
        return lancheRepository.findAll()
                .stream()
                .map(this::toResumoDTO)
                .toList();}
    }

    public Optional<Lanche> buscarPorId(Long id) {
        return Optional.of(lancheRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Lanche com id: " + id + " não encontrado.")));
    }

    public LancheResponseDTO atualizar (Long id, LancheRequestDTO dto){
        Lanche atual = lancheRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Lanche com id: " + id + " não encontrado."));
        atual.setNome(dto.nome());
        atual.setPreco(dto.preco());
        atual.setDescricao(dto.descricao());

        Lanche novo = lancheRepository.save(atual);
        return toResponseDTO(novo);
    }

    public void excluir (Long id){
        if (!lancheRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Lanche com id: " + id + " não encontrado.");
        }
        lancheRepository.deleteById(id);
    }

}