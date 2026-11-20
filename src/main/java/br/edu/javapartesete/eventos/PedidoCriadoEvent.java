package br.edu.javapartesete.eventos;

// 19: formato JSON de exemplo: {"pedidoId": 123, "cliente": "Ana"}.
public record PedidoCriadoEvent(long pedidoId, String cliente) { }
