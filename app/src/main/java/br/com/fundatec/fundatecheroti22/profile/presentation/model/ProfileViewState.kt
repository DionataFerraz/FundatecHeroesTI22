package br.com.fundatec.fundatecheroti22.profile.presentation.model

sealed class ProfileViewState {
    object Success : ProfileViewState()
    object Loading : ProfileViewState()
    object Error : ProfileViewState()
    object ShowNameError : ProfileViewState()
    object ShowEmailError : ProfileViewState()
    object ShowPasswordError : ProfileViewState()
}