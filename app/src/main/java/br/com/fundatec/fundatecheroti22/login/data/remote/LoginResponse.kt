package br.com.fundatec.fundatecheroti22.login.data.remote

data class LoginResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)