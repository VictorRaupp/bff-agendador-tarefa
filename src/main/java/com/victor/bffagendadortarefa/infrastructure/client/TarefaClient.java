package com.victor.bffagendadortarefa.infrastructure.client;


import com.victor.bffagendadortarefa.business.dto.in.TarefaDTORequest;
import com.victor.bffagendadortarefa.business.dto.out.TarefaDTOResponse;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefa", url = "${agendador-tarefa.url}")
public interface TarefaClient {

    @PostMapping
    TarefaDTOResponse gravarTarefa(@RequestBody TarefaDTORequest dto,
                                   @RequestHeader(name= "Authorization", required = false) String token);

    @GetMapping("/eventos")
    List<TarefaDTOResponse> buscaListaDeTerefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name= "Authorization", required = false) String token);

    @GetMapping
    List<TarefaDTOResponse> buscaTarefaPorEmail(
            @RequestHeader(name= "Authorization", required = false) String token);

    @DeleteMapping
    void deletaTarefaPorid(@RequestParam("id") String id,
                           @RequestHeader(name= "Authorization", required = false) String token);

    @PatchMapping
    TarefaDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusTarefaEnum status,
                                             @RequestHeader(name= "Authorization", required = false) String token, String s);

    @PutMapping
    TarefaDTOResponse updateTarefa(@RequestBody TarefaDTORequest dto,
                                  @RequestParam("id") String id,
                                  @RequestHeader(name= "Authorization", required = false) String token);
}