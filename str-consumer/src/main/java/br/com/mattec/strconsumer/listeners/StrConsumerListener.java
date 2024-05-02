package br.com.mattec.strconsumer.listeners;


import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class StrConsumerListener {


    @KafkaListener(groupId = "gruop1", topics = "STR-TOPIC", containerFactory = "strContainerFactory")
    public void listener(String message){
        log.info("Receive message {}", message);

    }
}
