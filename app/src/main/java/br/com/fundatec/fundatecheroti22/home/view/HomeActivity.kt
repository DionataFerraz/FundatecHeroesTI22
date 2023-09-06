package br.com.fundatec.fundatecheroti22.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        Log.e("teste", "onCreate")

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.e("teste", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("teste", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e("teste", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("teste", "onDestroy")

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