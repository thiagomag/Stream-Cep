package br.com.thiago.streamcep;


import br.com.thiago.streamcep.subscriber.CepSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

@SpringBootApplication
public class StreamCepApplication {

    public static void main(String[] args) {

        SpringApplication.run(StreamCepApplication.class, args);

        CepSubscriber<String> cepSubscriber = new CepSubscriber<>();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        publisher.subscribe(cepSubscriber);

        List<String> ceps = List.of("25685350", "01001000");

        for (String cep : ceps) {
            publisher.submit(cep);
        }

        publisher.close();
    }
}
