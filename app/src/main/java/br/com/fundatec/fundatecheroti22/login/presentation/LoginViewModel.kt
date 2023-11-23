package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroti22.login.domain.isValidEmail
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: LoginUseCase
) : ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = LoginViewState.Loading

        if (email.isNullOrBlank() || !email.isValidEmail()) {
            viewState.value = LoginViewState.ShowEmailError
            return
        }

        if (password.isNullOrBlank() || password.length < 8) {
            viewState.value = LoginViewState.ShowPasswordError
            return
        }

        fetchLogin(email = email, password = password)
    }

    private fun fetchLogin(email: String, password: String) {
        viewModelScope.launch {
            val isSuccessLogin = useCase.login(email = email, password = password)
            viewState.value = if (isSuccessLogin) {
                LoginViewState.ShowHomeScreen
            } else {
                LoginViewState.ShowErrorMessage
            }
        }
    }
}