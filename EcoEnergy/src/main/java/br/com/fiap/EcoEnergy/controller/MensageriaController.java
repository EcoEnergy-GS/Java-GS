package br.com.fiap.EcoEnergy.controller;

import br.com.fiap.EcoEnergy.mensageria.ProdutorRabbitMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class MensageriaController {

    @Autowired
    private ProdutorRabbitMQ produtorRabbit;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/retorna_pag_mensagem_rabbit")
    public String retornaPagEnvioMensagemRabbit(Model model) {
        return "enviar_mensagem_rabbit";
    }

    @PostMapping("/enviar_mensagem_rabbit")
    public String enviarMsgRabbit(@RequestParam(name = "mensagem") String msg, Model model, Locale locale) {
        String msgSucesso = messageSource.getMessage("msg_sucesso", null, locale);
        produtorRabbit.enviarMensagem(msg);
        model.addAttribute("var", msgSucesso + msg);
        return "enviar_mensagem_rabbit";
    }
}
