package br.edu.javapartesete.eventos;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue filaPedidosCriados() {
        return QueueBuilder.durable("pedidos.criados").build();
    }

    @Bean("jsonMessageConverter")
    public JacksonJsonMessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter("br.edu.javapartesete.eventos");
    }
}
