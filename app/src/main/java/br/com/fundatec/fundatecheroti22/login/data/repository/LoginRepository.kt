package br.com.fundatec.fundatecheroti22.login.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroti22.login.data.LoginRequest
import br.com.fundatec.fundatecheroti22.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Handler

class LoginRepository {
    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(LoginService::class.java)

    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createUser(
                    loginRequest = LoginRequest(
                        name = name,
                        email = email,
                        password = password,
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createUser", ex.message.toString())
                false
            }
        }
    }
}