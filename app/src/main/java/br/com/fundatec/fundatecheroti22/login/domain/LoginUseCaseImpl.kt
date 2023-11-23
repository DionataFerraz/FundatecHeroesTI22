package br.com.fundatec.fundatecheroti22.login.domain

import br.com.fundatec.fundatecheroti22.login.data.repository.LoginRepository

class LoginUseCaseImpl(
    private val repository: LoginRepository
) : LoginUseCase {

    override suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return repository.createUser(
            name = name,
            email = email,
            password = password,
        )
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Boolean {
        return repository.login(
            email = email,
            password = password,
        )
    }

}