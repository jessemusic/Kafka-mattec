package br.com.mattec.servicepayment.resources.impl;

import br.com.mattec.servicepayment.model.Payment;
import br.com.mattec.servicepayment.resources.PaymentResource;
import br.com.mattec.servicepayment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payment")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;
    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
