package br.com.mattec.servicepayment.services;

import br.com.mattec.servicepayment.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
