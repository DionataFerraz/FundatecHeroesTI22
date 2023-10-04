package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val emailState: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> = emailState

    private val passwordState: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> = passwordState

    fun validateInputs(email: String?, password: String?) {
        if (email.isNullOrBlank()) {
            emailState.value = "Digite um email valido"
        }

        if (password.isNullOrBlank()) {
            passwordState.value = "Digite uma senha valida"
        }

    }
}