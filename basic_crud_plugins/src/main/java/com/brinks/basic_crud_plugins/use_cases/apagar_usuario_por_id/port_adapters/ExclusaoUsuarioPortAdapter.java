package com.brinks.basic_crud_plugins.use_cases.apagar_usuario_por_id.port_adapters;

import com.brinks.basic_crud_plugins.data_base_configurations.repositories.SaltTableEntityRepository;
import com.brinks.basic_crud_plugins.data_base_configurations.repositories.SecretTableEntityRepository;
import com.brinks.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.ExclusaoUsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExclusaoUsuarioPortAdapter implements ExclusaoUsuarioPort {

    private final UsuarioTableEntityRepository usuarioTableEntityRepository;
    private final SaltTableEntityRepository saltTableEntityRepository;
    private final SecretTableEntityRepository secretTableEntityRepository;

    @Override
    public void execute(Long input) {
        //TODO: implementar mecanismo de retry e restore em caso de falha em uma das transações (se uma falhar, não podemos concluir o atendimento
        //se o usuário foi apagado, é necessário também apagar sua senha e o sal da senha. Se alguma dessas operações falhar, utilizar algum
        // algoritmo de resiliência.
        this.usuarioTableEntityRepository.deleteById(input);
        this.saltTableEntityRepository.deleteById(input);
        this.secretTableEntityRepository.deleteById(input);
    }
}
