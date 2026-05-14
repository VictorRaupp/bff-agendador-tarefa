package com.victor.bffagendadortarefa.business;

import com.victor.bffagendadortarefa.business.dto.in.LoginDTORequest;
import com.victor.bffagendadortarefa.business.dto.out.TarefaDTOResponse;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaProximaHora(){
        String token = login(converterParaRequestDto());
        LocalDateTime horaFutura =  LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List< TarefaDTOResponse> listaTarefa= tarefaService.buscaTarefasAgendadasPorPeriodo(
                horaFutura, horaFuturaMaisCinco, token);

        listaTarefa.forEach(tarefa ->{
            emailService.enviaEmail(tarefa);
            tarefaService.alteraStatus(StatusTarefaEnum.NOTIFICADO, tarefa.getId(), token);
        });
    }

    public String login (LoginDTORequest dto){
       return usuarioService.loginUsuario(dto);
    }

    public LoginDTORequest converterParaRequestDto(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
