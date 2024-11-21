package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.model.Endereco;
import br.com.fiap.EcoEnergy.model.Residencia;
import br.com.fiap.EcoEnergy.model.TipoEletrodomestico;
import br.com.fiap.EcoEnergy.model.Usuario;
import br.com.fiap.EcoEnergy.repository.ResidenciaRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ResidenciaController {

    @Autowired
    private ResidenciaRepository residenciaRepository;

    @GetMapping("/residencia")
    public String retornarPagina(Model model) {
        List<Residencia> residencias = residenciaRepository.findAll();
        model.addAttribute("residencias", residencias);
        return "paginaResidencia";
    }

    @GetMapping("/residencia/nova")
    public String showAddResidenciaForm(Model model) {
        model.addAttribute("residencia", new Residencia());
        return "addResidencia";
    }

    @PostMapping("/residencia/adicionar")
    public String addResidencia(@ModelAttribute("residencia") Residencia residencia) {
        residenciaRepository.save(residencia);
        return "redirect:/residencia";
    }

    @GetMapping("/residencia/deletar/{id}")
    public String deleteResidencia(@PathVariable("id") Long id) {
        residenciaRepository.deleteById(id);
        return "redirect:/residencia";
    }

    @GetMapping("/residencia/editar/{id}")
    public String showEditResidenciaForm(@PathVariable("id") Long id, Model model) {
        Residencia residencia = residenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("residencia", residencia);
        return "editResidencia";
    }

    @PostMapping("/residencia/atualizar/{id}")
    public String updateResidencia(@PathVariable("id") Long id, @ModelAttribute("residencia") Residencia updatedResidencia) {
        Residencia existingResidencia = residenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        existingResidencia.setDispositivoMonitoramento(updatedResidencia.getDispositivoMonitoramento());
        existingResidencia.setQuantidadePessoas(updatedResidencia.getQuantidadePessoas());
        existingResidencia.setMediaConsumo(updatedResidencia.getMediaConsumo());
        residenciaRepository.save(existingResidencia);
        return "redirect:/residencia";
    }

    @RequestMapping(value = "/residencia/{id}", method = RequestMethod.GET)
    public String viewResidencia(@PathVariable("id") Long id, Model model) {
        Residencia residencia = residenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("residencia", residencia);
        return "viewResidencia";
    }
}
