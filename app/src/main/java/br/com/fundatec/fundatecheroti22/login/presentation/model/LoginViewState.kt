package br.com.fundatec.fundatecheroti22.login.presentation.model

sealed class LoginViewState {
    object Loading : LoginViewState()
    object ShowErrorMessage : LoginViewState()
    object ShowHomeScreen : LoginViewState()
    object ShowEmailError : LoginViewState()
    object ShowPasswordError : LoginViewState()
}