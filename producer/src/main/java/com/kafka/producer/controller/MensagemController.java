package com.kafka.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.dto.Mensagem;
import com.kafka.producer.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    public final MensagemService orderService;

    public MensagemController(MensagemService orderService) {
        this.orderService = orderService;
    }
   
    @PostMapping
    public void criarMensagem(@RequestBody Mensagem mensagem) {        
        orderService.enviarMensagem(mensagem);
    }
    
}
