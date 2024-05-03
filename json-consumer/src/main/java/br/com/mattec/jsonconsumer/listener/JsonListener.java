package br.com.mattec.jsonconsumer.listener;

import br.com.mattec.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {


    @SneakyThrows
    @KafkaListener(topics = "PAYMENT-TOPIC", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){

        log.info("Recebi oi pagamento {}",payment.toString());
        sleep(2000);
        log.info("Validando fraud ...");
        sleep(2000);

        log.info("Compra aprovada");
        sleep(3000);

    }

    @SneakyThrows
    @KafkaListener(topics = "PAYMENT-TOPIC", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){

        log.info("Gerando PDF do produto de id {}",payment.getId());
        sleep(2000);

        log.info("PDF gerado com sucesso");
        sleep(3000);

    }

    @SneakyThrows
    @KafkaListener(topics = "PAYMENT-TOPIC", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){

        log.info("Enviando email de confirmação ...");
        sleep(2000);

        log.info("Email enviado");
        sleep(3000);

    }
}
