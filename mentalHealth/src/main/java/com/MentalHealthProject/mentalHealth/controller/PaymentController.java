package com.MentalHealthProject.mentalHealth.controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
    private static Gson gson = new Gson();

    static class CreatePaymentItem {
        String id;

        public String getId() {
            return id;
        }
    }

    static class CreatePayment {
        private int amount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    static class CreatePaymentResponse {
        private String clientSecret;

        public CreatePaymentResponse(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    @PostMapping("/create-intent")
    public String createPaymentIntent(@RequestBody CreatePayment postBody) throws StripeException {
        Stripe.apiKey = "sk_test_51MUCJqSJ5OsYGHjp2fAng56vaIW9yN1aPTS2KejTC1SHrNNEjkBrfQg1ALAExattOTjANVmFOZaKYOj75sbRK9lu00PqeXqfoS";

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) postBody.getAmount() * 100)
                .setCurrency("inr")
                .setAutomaticPaymentMethods(PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build())
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
        return gson.toJson(paymentResponse);
    }
}
