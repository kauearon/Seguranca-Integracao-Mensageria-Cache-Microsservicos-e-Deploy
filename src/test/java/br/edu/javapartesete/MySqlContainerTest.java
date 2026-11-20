package br.edu.javapartesete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

// 17: requer Docker ativo; @ServiceConnection configura DataSource do Testcontainers.
@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(properties = {
    "app.jwt.segredo=chave_apenas_para_testes_com_mais_de_32_bytes_123",
    "spring.rabbitmq.listener.simple.auto-startup=false"
})
public class MySqlContainerTest {
    @Container
    @ServiceConnection
    static MySQLContainer mysql = new MySQLContainer("mysql:8.4");

    @Autowired
    JdbcTemplate jdbc;

    @Test
    void deveConectarAoMySql() {
        Integer resultado = jdbc.queryForObject("SELECT 1", Integer.class);
        assertEquals(1, resultado);
    }
}
