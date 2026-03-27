package com.victor.bffagendadortarefa.business.dto.in
;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor.bffagendadortarefa.infrastructure.enuns.StatusTarefaEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaDTORequest {


    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
}
