package br.com.fundatec.fundatecheroti22.home.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {
    private val button by lazy {
        findViewById<Button>(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observerState(HomeViewState.Error("Mensagem de erro"))
    }

    private fun observerState(state: HomeViewState) {
        when (state) {
            is HomeViewState.Success -> {
                state.message
            }
            is HomeViewState.Error -> {
                state.errorMessage
            }
            HomeViewState.Loading -> {

            }
            HomeViewState.HideButton -> {
                button.gone()
            }
        }
    }
}