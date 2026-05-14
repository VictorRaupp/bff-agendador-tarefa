package com.victor.bffagendadortarefa.business;


import com.victor.bffagendadortarefa.business.dto.out.TarefaDTOResponse;
import com.victor.bffagendadortarefa.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefaDTOResponse dto){
        emailClient.enviarEmail(dto);
    }
}


