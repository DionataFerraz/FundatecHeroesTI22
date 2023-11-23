package br.com.fundatec.fundatecheroti22.login.data.repository

interface LoginRepository {
    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean

    suspend fun login(
        email: String,
        password: String,
    ): Boolean
}