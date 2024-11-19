package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.model.Usuario;
import br.com.fiap.EcoEnergy.repository.RoleRepository;
import br.com.fiap.EcoEnergy.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuariosController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/usuario")
    public String retornarPagina(Model model) {
        List<Usuario> usuarios = usuariosRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "paginaUsuario";
    }

    @GetMapping("/usuario/nova")
    public String showAddUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "addUsuario";
    }

    @PostMapping("/usuario/adicionar")
    public String addUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuariosRepository.save(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/deletar/{id}")
    public String deleteUsuario(@PathVariable("id") Long id) {
        usuariosRepository.deleteById(id);
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/editar/{id}")
    public String showEditUsuarioForm(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("usuario", usuario);
        return "editUsuario";
    }

    @PostMapping("/usuario/atualizar/{id}")
    public String updateUsuario(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario updatedUsuario) {
        Usuario existingUsuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        existingUsuario.setNome(updatedUsuario.getNome());
        existingUsuario.setSenha(updatedUsuario.getSenha());
        existingUsuario.setTelefone(updatedUsuario.getTelefone());
        existingUsuario.setPontos(updatedUsuario.getPontos());
        existingUsuario.setRoles(updatedUsuario.getRoles());
        usuariosRepository.save(existingUsuario);
        return "redirect:/usuario";
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public String viewUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("usuario", usuario);
        return "viewUsuario";
    }

}
