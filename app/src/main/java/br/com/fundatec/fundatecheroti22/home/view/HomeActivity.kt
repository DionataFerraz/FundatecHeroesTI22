package br.com.fundatec.fundatecheroti22.home.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.presentation.model.HomeViewState
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    private val button by lazy {
        findViewById<Button>(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observerState(HomeViewState.Error("Mensagem de erro"))
        Log.e("teste", "onCreate")

        val image: ImageView = findViewById(R.id.image)
        Glide.with(this)
            .load("https://cdn.kobo.com/book-images/ef771a94-af0c-4b43-9441-623fd4e2096f/353/569/90/False/venom-by-donny-cates-vol-5.jpg")
            .into(image)

        button.setOnClickListener {
            Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show()
            Snackbar.make(button, R.string.app_name, Snackbar.LENGTH_LONG).show()
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