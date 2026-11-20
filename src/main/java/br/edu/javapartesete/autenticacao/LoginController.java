package br.edu.javapartesete.autenticacao;

    import java.time.Instant;
    import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Profile;
    import org.springframework.http.HttpStatus;
    import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
    import org.springframework.security.oauth2.jwt.JwsHeader;
    import org.springframework.security.oauth2.jwt.JwtClaimsSet;
    import org.springframework.security.oauth2.jwt.JwtEncoder;
    import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.server.ResponseStatusException;
    import io.swagger.v3.oas.annotations.security.SecurityRequirements;

    @RestController
    @Profile("local")
    @RequestMapping("/auth")
    public class LoginController {
        private final JwtEncoder encoder;
        private final String usuario;
        private final String senha;

        public LoginController(JwtEncoder encoder,
                               @Value("${app.lab.usuario}") String usuario,
                               @Value("${app.lab.senha}") String senha) {
            this.encoder = encoder;
            this.usuario = usuario;
            this.senha = senha;
        }

        @PostMapping("/login")
        @SecurityRequirements
        public LoginResponse entrar(@Valid @RequestBody LoginRequest pedido) {
            // Apenas demonstração: um usuário de laboratório definido no ambiente.
            if (!usuario.equals(pedido.usuario()) || !senha.equals(pedido.senha()) || senha.isBlank()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.");
            }

            Instant agora = Instant.now();
            JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(pedido.usuario())
                .issuedAt(agora)
                .expiresAt(agora.plusSeconds(3600))
                .claim("scope", "fretes.ler")
                .build();

            JwsHeader cabecalho = JwsHeader.with(MacAlgorithm.HS256).build();
            String token = encoder.encode(JwtEncoderParameters.from(cabecalho, claims)).getTokenValue();
            return new LoginResponse(token, "Bearer");
        }
    }
