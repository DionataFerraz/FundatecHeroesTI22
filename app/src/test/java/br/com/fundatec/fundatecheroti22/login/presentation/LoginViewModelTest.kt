package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.fundatec.fundatecheroti22.CoroutinesRule
import br.com.fundatec.fundatecheroti22.login.data.repository.LoginRepositoryImpl
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCaseImpl
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState
import org.junit.Test
import org.junit.Assert.*
import io.mockk.mockk
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutinesRule()

    private val loginUseCase = mockk<LoginUseCase>()
    private val viewModel = LoginViewModel(loginUseCase)

    @Test
    fun validateViewState_returnShowEmailError() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validateInputs(null, null)
        coVerify(exactly = 0) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowEmailError)
    }

    @Test
    fun validateViewState_returnShowPasswordError() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validateInputs("email@gmail.com", null)
        coVerify(exactly = 0) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowPasswordError)
    }

    @Test
    fun validateViewState_returnShowErrorMessage() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validateInputs("email@gmail.com", "passworddassadas")
        coVerify(exactly = 1) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowErrorMessage)
    }

    @Test
    fun validateViewState_returnShowHomeScreen() = runTest {
        prepareScenario(isSuccess = true)
        viewModel.validateInputs("email@gmail.com", "passworddassadas")
        coVerify(exactly = 1) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowHomeScreen)
    }

    private fun prepareScenario(
        isSuccess: Boolean
    ) {
        coEvery {
            loginUseCase.login(any(), any())
        } returns isSuccess
    }
}