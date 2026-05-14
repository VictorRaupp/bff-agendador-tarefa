package com.victor.bffagendadortarefa.infrastructure.client.config;

import com.victor.bffagendadortarefa.infrastructure.exceptions.BusinessException;
import com.victor.bffagendadortarefa.infrastructure.exceptions.ConflictException;
import com.victor.bffagendadortarefa.infrastructure.exceptions.ResourceNotFoundException;
import com.victor.bffagendadortarefa.infrastructure.exceptions.UnathorizedExcepetion;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributa ja existente ");
            case 403:
                return new ResourceNotFoundException("Erro atributa não encontrado ");
            case 401:
                return new UnathorizedExcepetion("Erro usuario nao autorizado ");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
