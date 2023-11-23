package br.com.fundatec.fundatecheroti22.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroti22.profile.presentation.model.ProfileViewState
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val useCase: LoginUseCase
) : ViewModel() {

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(name: String?, email: String?, password: String?) {
        if (name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowNameError
        } else if (email.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowEmailError
        } else if (password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowPasswordError
        } else {
            createUser(name = name, email = email, password = password)
        }
    }

    private fun createUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            val isSuccess = useCase.createUser(
                name = name,
                email = email,
                password = password,
            )
            if (isSuccess) {
                viewState.value = ProfileViewState.Success
            } else {
                viewState.value = ProfileViewState.Error
            }
        }
    }
}