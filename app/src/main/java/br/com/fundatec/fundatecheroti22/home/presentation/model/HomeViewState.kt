package br.com.fundatec.fundatecheroti22.home.presentation.model

sealed class HomeViewState {
    data class Success(val message: String) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    object HideButton : HomeViewState()
}