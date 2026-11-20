package br.edu.javapartesete.frete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreteController {
    private final FreteClient freteClient;

    public FreteController(FreteClient freteClient) {
        this.freteClient = freteClient;
    }

    @GetMapping("/consulta-fretes/{cep}")
    public String consultar(@PathVariable String cep) {
        System.out.printf("Consultando frete para CEP: %s%n", cep);
        return freteClient.consultarFrete(cep);
    }
}
