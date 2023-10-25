package br.com.fundatec.fundatecheroti22.login.data

data class LoginRequest(
    val name: String,
    val email: String,
    val password: String,
)