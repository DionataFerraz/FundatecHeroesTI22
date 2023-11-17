package br.com.fundatec.fundatecheroti22.splash.view.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroti22.splash.domain.IsValidCacheUseCase
import br.com.fundatec.fundatecheroti22.splash.view.presentation.model.SplashViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val useCase by lazy {
        IsValidCacheUseCase()
    }

    private val viewState: MutableLiveData<SplashViewState> = MutableLiveData()
    val state: LiveData<SplashViewState> = viewState

    private fun validateUserCache() {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashViewState.ShowHome
            } else {
                viewState.value = SplashViewState.ShowLogin
            }
        }
    }

    init {
        validateUserCache()
    }
}