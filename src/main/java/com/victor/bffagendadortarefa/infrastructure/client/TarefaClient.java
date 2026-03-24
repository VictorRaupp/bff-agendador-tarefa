package com.victor.bffagendadortarefa.infrastructure.client;


import com.victor.bffagendadortarefa.business.dto.TarefaDTO;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefa", url = "${agendador-tarefa.url}")
public interface TarefaClient {

    @PostMapping
    TarefaDTO gravarTarefa(@RequestBody TarefaDTO dto,
                           @RequestHeader(name= "Authorization", required = false) String token);

    @GetMapping("/eventos")
    List<TarefaDTO> buscaListaDeTerefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name= "Authorization", required = false) String token);

    @GetMapping
    List<TarefaDTO> buscaTarefaPorEmail(
            @RequestHeader(name= "Authorization", required = false) String token);

    @DeleteMapping
    void deletaTarefaPorid(@RequestParam("id") String id,
                           @RequestHeader(name= "Authorization", required = false) String token);

    @PatchMapping
    TarefaDTO alteraStatusNotificacao(@RequestParam("status") StatusTarefaEnum status,
                                      @RequestHeader(name= "Authorization", required = false) String token, String s);

    @PutMapping
    TarefaDTO updateTarefa(@RequestBody TarefaDTO dto,
                           @RequestParam("id") String id,
                           @RequestHeader(name= "Authorization", required = false) String token);
}