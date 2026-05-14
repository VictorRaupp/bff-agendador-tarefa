package com.victor.bffagendadortarefa.infrastructure.client;


import com.victor.bffagendadortarefa.business.dto.out.TarefaDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping("/email")
    void enviarEmail(@RequestBody TarefaDTOResponse dto);
}