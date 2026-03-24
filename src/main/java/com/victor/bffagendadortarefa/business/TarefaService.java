package com.victor.bffagendadortarefa.business;



import com.victor.bffagendadortarefa.business.dto.TarefaDTO;
import com.victor.bffagendadortarefa.infrastructure.client.TarefaClient;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaClient tarefaClient;

    public TarefaDTO gravarTarefa(String token, TarefaDTO dto) {
        return tarefaClient.gravarTarefa(dto, token);
    }

    public List<TarefaDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInial,
                                                           LocalDateTime dataFinal, String token) {
        return tarefaClient.buscaListaDeTerefasPorPeriodo(dataInial,dataFinal,token);
    }

    public List<TarefaDTO> buscaTarefaPorEmail(String token) {
       return tarefaClient.buscaTarefaPorEmail(token);
    }

    public void deletaTaferaPorId(String id, String token) {
       tarefaClient.deletaTarefaPorid(id, token);
    }

    public TarefaDTO alteraStatus(StatusTarefaEnum status, String id, String token) {
     return tarefaClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefaDTO updateTarefa(TarefaDTO dto, String id, String token) {
       return tarefaClient.updateTarefa(dto,id,token);
    }
}
