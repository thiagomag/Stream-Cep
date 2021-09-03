package br.com.thiago.streamcep.subscriber;

import br.com.thiago.streamcep.endereco.Endereco;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;


public class CepSubscriber<T> implements Flow.Subscriber<T> {

        private Flow.Subscription subscription;
        private List<T> elementos;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
                elementos = new ArrayList<>();
                this.subscription = subscription;
                subscription.request(1);
        }

        @Override
        public void onNext(T item) {
                Endereco endereco = getEndereco(item);
                elementos.add((T) endereco);
                System.out.println(endereco + "\n");
                subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
                System.out.printf("Error %s", throwable.getMessage());
        }

        @Override
        public void onComplete() {
                System.out.println("No more elements");
        }

        private Endereco getEndereco(T item) {
                String resourceUrl = "https://viacep.com.br/ws/" + item + "/json/";
                RestTemplate restTemplate = new RestTemplate();
                return restTemplate.getForObject(resourceUrl, Endereco.class);
        }
}
