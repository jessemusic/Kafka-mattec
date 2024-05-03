package br.com.mattec.servicepayment.services.impl;

import br.com.mattec.servicepayment.model.Payment;
import br.com.mattec.servicepayment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class
PayServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> templateKafka;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}", payment);
        Thread.sleep(1000);

        log.info("Enviando mensagem de pagamento...");

        templateKafka.send("PAYMENT-TOPIC", payment);

    }
}
