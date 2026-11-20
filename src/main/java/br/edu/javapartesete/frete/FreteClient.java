package br.edu.javapartesete.frete;

import org.springframework.beans.factory.annotation.Value;
    import org.springframework.cache.annotation.Cacheable;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestClient;

    // 18 e 20: cliente HTTP com cache de resultados por CEP.
    @Service
    public class FreteClient {
        private final RestClient cliente;

        public FreteClient(RestClient.Builder builder,
                           @Value("${app.fretes.base-url}") String urlBase) {
            this.cliente = builder.baseUrl(urlBase).build();
        }

        @Cacheable(value = "fretes", key = "#p0")
        public String consultarFrete(String cep) {
            return cliente.get().uri("/fretes/{cep}", cep)
                .retrieve().body(String.class);
        }
    }
