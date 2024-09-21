package com.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.kafka.consumer.dto.MensagemDTO;

@Service
public class MensagemService {

    final String particao = "0";

    // @KafkaListener(
    //     topics = "nome-topico-kafka", 
    //     containerFactory = "orderKafkaListenerContainerFactory")
    @KafkaListener(topicPartitions = 
        @TopicPartition(
            topic = "nome-topico-kafka", 
            partitions = { particao }
        ), 
        containerFactory = "orderKafkaListenerContainerFactory")
    public void mensagemListener(MensagemDTO mensagem) {
        System.out.println("Consumer Partição: " + particao + " - Mensagem Recebida: " + mensagem.getNome());
    }
}
