package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.producer.dto.MensagemDTO;
import com.kafka.producer.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    public MensagemService mensagemService;

    @PostMapping
    public void criarMensagem(@RequestBody MensagemDTO mensagem) throws Exception {        
        try {
            this.mensagemService.enviarMensagem(mensagem);
        } catch (JsonProcessingException e) {
            throw new Exception("Houve um erro ao enviar a mensagem: "+ e.getMessage());
        }
    }
    
}
