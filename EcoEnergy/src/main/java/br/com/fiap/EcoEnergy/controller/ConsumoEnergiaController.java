package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.model.ConsumoEnergia;
import br.com.fiap.EcoEnergy.model.Usuario;
import br.com.fiap.EcoEnergy.repository.ConsumoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaRepository consumoEnergiaRepository;

    @GetMapping("/consumoEnergia")
    public String retornarPagina(Model model) {
        List<ConsumoEnergia> consumoEnergias = consumoEnergiaRepository.findAll();
        model.addAttribute("consumoEnergias", consumoEnergias);
        return "paginaConsumoEnergia";
    }

    @GetMapping("/consumoEnergia/nova")
    public String showAddConsumoEnergiaForm(Model model) {
        model.addAttribute("consumoEnergia", new ConsumoEnergia());
        return "addConsumoEnergia";
    }

    @PostMapping("/consumoEnergia/adicionar")
    public String addConsumoEnergia(@ModelAttribute("consumoEnergia") ConsumoEnergia consumoEnergia) {
        consumoEnergiaRepository.save(consumoEnergia);
        return "redirect:/consumoEnergia";
    }

    @GetMapping("/consumoEnergia/deletar/{id}")
    public String deleteConsumoEnergia(@PathVariable("id") Long id) {
        consumoEnergiaRepository.deleteById(id);
        return "redirect:/consumoEnergia";
    }

    @GetMapping("/consumoEnergia/editar/{id}")
    public String showEditConsumoEnergiaForm(@PathVariable("id") Long id, Model model) {
        ConsumoEnergia consumoEnergia = consumoEnergiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("consumoEnergia", consumoEnergia);
        return "editConsumoEnergia";
    }

    @PostMapping("/consumoEnergia/atualizar/{id}")
    public String updateConsumoEnergia(@PathVariable("id") Long id, @ModelAttribute("consumoEnergia") ConsumoEnergia updatedConsumoEnergia) {
        ConsumoEnergia existingConsumoEnergia = consumoEnergiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        existingConsumoEnergia.setData(updatedConsumoEnergia.getData());
        existingConsumoEnergia.setConsumo(updatedConsumoEnergia.getConsumo());
        consumoEnergiaRepository.save(existingConsumoEnergia);
        return "redirect:/consumoEnergia";
    }

    @RequestMapping(value = "/consumoEnergia/{id}", method = RequestMethod.GET)
    public String viewConsumoEnergia(@PathVariable("id") Long id, Model model) {
        ConsumoEnergia consumoEnergia = consumoEnergiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("consumoEnergia", consumoEnergia);
        return "viewConsumoEnergia";
    }
}
