package br.edu.javapartesete.autenticacao;

import jakarta.validation.constraints.NotBlank;

// 14: DTO de entrada do login.
public record LoginRequest(@NotBlank String usuario, @NotBlank String senha) { }
