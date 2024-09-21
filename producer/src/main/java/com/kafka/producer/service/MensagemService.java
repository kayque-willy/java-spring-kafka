package com.kafka.producer.service;

import java.util.Random;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.producer.dto.MensagemDTO;

@Service
public class MensagemService {

    private final KafkaTemplate<String, MensagemDTO> kafkaTemplate;

    private final Random random = new Random();

    public MensagemService(KafkaTemplate<String, MensagemDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Envia o objeto da mensagem para o Kafka
    public void enviarMensagem(MensagemDTO mensagem) throws JsonProcessingException {
        // Randomiza partição para exemplificação
        int particao = random.nextInt(2);

        System.out.println("Mensagem enviada para a partição: " + particao);
        System.out.println("Enviando Mensagem: " + mensagem.getNome());

        this.kafkaTemplate.send("nome-topico-kafka", 0, null, mensagem);
    }

}