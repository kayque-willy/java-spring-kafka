package com.kafka.producer.service;

import java.util.Random;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.dto.Mensagem;

@Service
public class MensagemService {

    private final KafkaTemplate<String, Mensagem> kafkaTemplateOrder;

    private final Random random = new Random();

    public MensagemService(KafkaTemplate<String, Mensagem> kafkaTemplateOrder) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
    }

    // Envia o objeto da mensagem para o Kafka
    public void enviarMensagem(Mensagem mensagem) {
        int particao = random.nextInt(2);
        System.out.println("Mensagem enviada para a partição: " + particao);
        System.out.println("Enviando Mensagem: " + mensagem.nome());
        kafkaTemplateOrder.send("nome-topico-kafka",particao, null, mensagem);
    }

}