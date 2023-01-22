package com.brinksdevs.crudbasic.service.Implementation;

import com.brinksdevs.crudbasic.exception.ResourceNotFoundException;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.service.UsuarioDelecaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioDelecaoServiceImpl implements UsuarioDelecaoService {
    private final UsuarioRepository repository;
    @Override
    public void deleteByUsuarioId(Long id) {
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
