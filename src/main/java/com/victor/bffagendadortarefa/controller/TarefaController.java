package com.victor.bffagendadortarefa.controller;


import com.victor.bffagendadortarefa.business.TarefaService;
import com.victor.bffagendadortarefa.business.dto.in.TarefaDTORequest;
import com.victor.bffagendadortarefa.business.dto.out.TarefaDTOResponse;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import com.victor.bffagendadortarefa.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefa")
@Tag(name= "Tarefa", description = "Cadastra tarefas de usuario")
@SecurityRequirement(name= SecurityConfig.SECURITY_SCHEME)
public class TarefaController {
    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Cadastra terafas de Usuarios", description = "Cadastra tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa cadastrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDTOResponse> gravarTarefa(@RequestBody TarefaDTORequest dto,
                                                          @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca lista de tarefa por periodo", description = "Busca list de tarefa do usuario por periodo")
    @ApiResponse(responseCode = "200", description = "tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<List<TarefaDTOResponse>> buscaListaDeTerefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token
    ) {

        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca  tarefa por email", description = "Busca tarefa do usuario por email")
    @ApiResponse(responseCode = "200", description = "tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<List<TarefaDTOResponse>> buscaTarefaPorEmail(
            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.buscaTarefaPorEmail(token));
    }

    @DeleteMapping @Operation(summary = "Deleta Tarefa por ID", description = "Deleta tarefa cadastradas por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa Deletada")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<Void> deletaTarefaPorid(@RequestParam("id") String id,
                                                  @RequestHeader("Authorization") String token) {
        tarefaService.deletaTaferaPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Atualiza Status da Tarefa", description = "Atualiza Status da Tarefa")
    @ApiResponse(responseCode = "200", description = "Status da terefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDTOResponse> alteraStatusNotificacao(@RequestParam("status")
                                                             StatusTarefaEnum status, @RequestParam("id") String id,
                                                                    @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(tarefaService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Atualiza dados Tarefa", description = "Atualiza dados de Tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefa Atualizada")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefaDTOResponse> uptadeTarefa(@RequestBody TarefaDTORequest dto, @RequestParam ("id") String id,
                                                         @RequestHeader("Authorization") String token){

        return  ResponseEntity.ok(tarefaService.updateTarefa(dto, id, token));
    }

}
