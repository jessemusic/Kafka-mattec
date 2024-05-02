package br.com.mattec.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public  void sendMessage(String message){
        kafkaTemplate.send("STR-TOPIC", message).addCallback(
                success -> {
                    if(success != null){
                        log.info("Send success messages {}",message);
                        log.info("Partitions {}, Offset {}",success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());

                    }
                },
                error -> log.info("Sent failure messages")
        );
    }



}
