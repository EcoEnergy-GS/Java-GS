//package br.com.fiap.EcoEnergy.controller;
//
//import br.com.fiap.EcoEnergy.model.ConsumoEnergia;
//import br.com.fiap.EcoEnergy.model.Usuario;
//import br.com.fiap.EcoEnergy.repository.ConsumoEnergiaRepository;
//import br.com.fiap.EcoEnergy.repository.UsuariosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class ConsumoEnergiaController {
//
//    @Autowired
//    private ConsumoEnergiaRepository consumoRepository;
//
//    @GetMapping("/consumo")
//    public String retornarPagina(Model model) {
//        List<ConsumoEnergia> consumos = consumoRepository.findAll();
//        model.addAttribute("consumos", consumos);
//        return "paginaConsumo";
//    }
//
//    @GetMapping("/consumo/nova")
//    public String showAddConsumoForm(Model model) {
//        model.addAttribute("consumo", new ConsumoEnergia());
//        return "addConsumo";
//    }
//
//    @PostMapping("/consumo/adicionar")
//    public String addConsumo(@ModelAttribute("consumo") ConsumoEnergia consumoEnergia) {
//        consumoRepository.save(consumoEnergia);
//        return "redirect:/consumo";
//    }
//
//    @GetMapping("/consumo/deletar/{id}")
//    public String deleteConsumo(@PathVariable("id") Long id) {
//        consumoRepository.deleteById(id);
//        return "redirect:/consumo";
//    }
//
//    @GetMapping("/consumo/editar/{id}")
//    public String showEditConsumoForm(@PathVariable("id") Long id, Model model) {
//        ConsumoEnergia consumoEnergia = consumoRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
//        model.addAttribute("consumo", consumoEnergia);
//        return "editConsumo";
//    }
//
//    @PostMapping("/consumo/atualizar/{id}")
//    public String updateConsumo(@PathVariable("id") Long id, @ModelAttribute("consumo") ConsumoEnergia updatedConsumoEnergia) {
//        ConsumoEnergia existingConsumoEnergia = consumoRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
//        existingConsumoEnergia.setData(updatedConsumoEnergia.getData());
//        existingConsumoEnergia.setConsumo(updatedConsumoEnergia.getConsumo());
//        consumoRepository.save(existingConsumoEnergia);
//        return "redirect:/consumo";
//    }
//
//    @RequestMapping(value = "/consumo/{id}", method = RequestMethod.GET)
//    public String viewConsumo(@PathVariable("id") Long id, Model model) {
//        ConsumoEnergia consumoEnergia = consumoRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
//        model.addAttribute("consumo", consumoEnergia);
//        return "viewConsumo";
//    }
//}
