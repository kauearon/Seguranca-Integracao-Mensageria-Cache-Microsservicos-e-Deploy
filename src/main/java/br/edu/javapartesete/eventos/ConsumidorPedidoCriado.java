package br.edu.javapartesete.eventos;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// 19: escuta a fila e recebe PedidoCriadoEvent.
@Component
public class ConsumidorPedidoCriado {
    @RabbitListener(queues = "pedidos.criados", messageConverter = "jsonMessageConverter")
    public void consumir(PedidoCriadoEvent evento) {
        System.out.printf("Pedido criado: %d | Cliente: %s%n",
            evento.pedidoId(), evento.cliente());
    }
}
