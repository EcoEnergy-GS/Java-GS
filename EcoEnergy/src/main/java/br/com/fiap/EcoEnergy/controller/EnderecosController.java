package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.model.Endereco;
import br.com.fiap.EcoEnergy.model.Usuario;
import br.com.fiap.EcoEnergy.repository.EnderecoRepository;
import br.com.fiap.EcoEnergy.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnderecosController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/endereco")
    public String retornarPagina(Model model) {
        List<Endereco> enderecos = enderecoRepository.findAll();
        model.addAttribute("enderecos", enderecos);
        return "paginaEndereco";
    }

    @GetMapping("/endereco/nova")
    public String showAddEnderecoForm(Model model) {
        model.addAttribute("endereco", new Endereco());
        return "addEndereco";
    }

    @PostMapping("/endereco/adicionar")
    public String addEndereco(@ModelAttribute("endereco") Endereco endereco) {
        enderecoRepository.save(endereco);
        return "redirect:/endereco";
    }

    @GetMapping("/endereco/deletar/{id}")
    public String deleteEndereco(@PathVariable("id") Long id) {
        enderecoRepository.deleteById(id);
        return "redirect:/endereco";
    }

    @GetMapping("/endereco/editar/{id}")
    public String showEditEnderecoForm(@PathVariable("id") Long id, Model model) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("endereco", endereco);
        return "editEndereco";
    }

//    private Long idEndereco;
//    private String cep;
//    private String rua;
//    private String numero;
//    private String complemento;
    @PostMapping("/endereco/atualizar/{id}")
    public String updateEndereco(@PathVariable("id") Long id, @ModelAttribute("endereco") Endereco updatedEndereco) {
        Endereco existingEndereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        existingEndereco.setCep(updatedEndereco.getCep());
        existingEndereco.setRua(updatedEndereco.getRua());
        existingEndereco.setNumero(updatedEndereco.getNumero());
        existingEndereco.setComplemento(updatedEndereco.getComplemento());
        enderecoRepository.save(existingEndereco);
        return "redirect:/endereco";
    }

    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public String viewEndereco(@PathVariable("id") Long id, Model model) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Campo de Id inválido:" + id));
        model.addAttribute("endereco", endereco);
        return "viewEndereco";
    }
}
