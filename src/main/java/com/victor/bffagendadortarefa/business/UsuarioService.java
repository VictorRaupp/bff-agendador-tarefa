package com.victor.bffagendadortarefa.business;


import com.victor.bffagendadortarefa.business.dto.EnderecoDTO;
import com.victor.bffagendadortarefa.business.dto.TelefoneDTO;
import com.victor.bffagendadortarefa.business.dto.UsuarioDTO;
import com.victor.bffagendadortarefa.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO){
        return usuarioClient.login(usuarioDTO);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token){
       return usuarioClient.buscarUsuarioPorEmail(email,token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deleteUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario (String token, UsuarioDTO dto){
       return usuarioClient.atualizaDadosUsuario(dto, token);
    }
    public EnderecoDTO cadastraEndereco (String token, EnderecoDTO dto){
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTO cadastraTelefone (String token, TelefoneDTO dto){
       return usuarioClient.cadastraTelefone(dto, token);
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token){
        return usuarioClient.atualiaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO telefoneDTO, String token){
       return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }



}
