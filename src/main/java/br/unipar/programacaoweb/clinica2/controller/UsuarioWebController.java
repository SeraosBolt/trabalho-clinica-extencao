package br.unipar.programacaoweb.clinica2.controller;

import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/usuarios")
    public String getAllUsuario(Model model) {
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @PostMapping(path = "/usuarios/save")
    public String saveUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

}