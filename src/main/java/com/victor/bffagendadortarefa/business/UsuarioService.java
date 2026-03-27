package com.victor.bffagendadortarefa.business;


import com.victor.bffagendadortarefa.business.dto.in.EnderecoDTORequest;
import com.victor.bffagendadortarefa.business.dto.in.LoginDTORequest;
import com.victor.bffagendadortarefa.business.dto.in.TelefoneDTORequest;
import com.victor.bffagendadortarefa.business.dto.in.UsuarioDTORequest;
import com.victor.bffagendadortarefa.business.dto.out.EnderecoDTOResponse;
import com.victor.bffagendadortarefa.business.dto.out.TelefoneDTOResponse;
import com.victor.bffagendadortarefa.business.dto.out.UsuarioDTOResponse;
import com.victor.bffagendadortarefa.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO){
        return usuarioClient.login(usuarioDTO);
    }


    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
       return usuarioClient.buscarUsuarioPorEmail(email,token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deleteUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario (String token, UsuarioDTORequest dto){
       return usuarioClient.atualizaDadosUsuario(dto, token);
    }
    public EnderecoDTOResponse cadastraEndereco (String token, EnderecoDTORequest dto){
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone (String token, TelefoneDTORequest dto){
       return usuarioClient.cadastraTelefone(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualiaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
       return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }



}
