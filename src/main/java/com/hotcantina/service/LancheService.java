package com.hotcantina.service;

import com.hotcantina.dto.LancheRequestDTO;
import com.hotcantina.dto.LancheResponseDTO;
import com.hotcantina.dto.LancheResumoDTO;
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
              lanche.getNome(), lanche.getPreco()
        );
    }



    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        Lanche lanche = new Lanche();
        lanche.setNome(dto.nome());
        lanche.setDescricao(dto.descricao());
        lanche.setPreco(dto.preco());

        Lanche salvo = lancheRepository.save(lanche);

        return toResponseDTO(salvo);
    }

    public List<LancheResumoDTO> listar(){
        return lancheRepository.findAll()
                .stream()
                .map(this::toResumoDTO)
                .toList();
    }

    public Optional<Lanche> buscarPorId(Long id) {
        return lancheRepository.findById(id);
    }

    public LancheResponseDTO atualizar (Long id, LancheRequestDTO dto){
        Lanche atual = lancheRepository.findById(id).orElseThrow(()-> new RuntimeException());
        atual.setNome(dto.nome());
        atual.setPreco(dto.preco());
        atual.setDescricao(dto.descricao());

        Lanche novo = lancheRepository.save(atual);
        return toResponseDTO(novo);
    }

    public void excluir (Long id){
        lancheRepository.deleteById(id);
    }

}