package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.model.Recompensa;
import br.com.fiap.EcoEnergy.model.Usuario;
import br.com.fiap.EcoEnergy.repository.RecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecompensaController {

    @Autowired
    private RecompensaRepository recompensaRepository;

    @GetMapping("/recompensa")
    public String retornarPagina(Model model) {
        List<Recompensa> recompensas = recompensaRepository.findAll();
        model.addAttribute("recompensas", recompensas);
        return "paginaRecompensa";
    }

    @GetMapping("/recompensa/nova")
    public String showAddRecompensaForm(Model model) {
        model.addAttribute("recompensa", new Recompensa());
        return "addRecompensa";
    }

    @PostMapping("/recompensa/adicionar")
    public String addRecompensa(@ModelAttribute("recompensa") Recompensa recompensa) {
        recompensaRepository.save(recompensa);
        return "redirect:/recompensa";
    }

    @GetMapping("/recompensa/deletar/{id}")
    public String deleteRecompensa(@PathVariable("id") Long id) {
        recompensaRepository.deleteById(id);
        return "redirect:/recompensa";
    }

    @GetMapping("/recompensa/editar/{id}")
    public String showEditRecompensaForm(@PathVariable("id") Long id, Model model) {
        Recompensa recompensa = recompensaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("recompensa", recompensa);
        return "editRecompensa";
    }

    @PostMapping("/recompensa/atualizar/{id}")
    public String updateRecompensa(@PathVariable("id") Long id, @ModelAttribute("recompensa") Recompensa updatedRecompensa) {
        Recompensa existingRecompensa = recompensaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        existingRecompensa.setDescricao(updatedRecompensa.getDescricao());
        existingRecompensa.setPontosNecessarios(updatedRecompensa.getPontosNecessarios());
        recompensaRepository.save(existingRecompensa);
        return "redirect:/recompensa";
    }

    @RequestMapping(value = "/recompensa/{id}", method = RequestMethod.GET)
    public String viewRecompensa(@PathVariable("id") Long id, Model model) {
        Recompensa recompensa = recompensaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("recompensa", recompensa);
        return "viewRecompensa";
    }
}
