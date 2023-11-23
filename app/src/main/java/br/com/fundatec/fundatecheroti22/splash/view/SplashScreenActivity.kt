package br.com.fundatec.fundatecheroti22.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.home.view.HomeActivity
import br.com.fundatec.fundatecheroti22.login.view.LoginActivity
import br.com.fundatec.fundatecheroti22.splash.presentation.SplashViewModel
import br.com.fundatec.fundatecheroti22.splash.presentation.model.SplashViewState

private const val DELAY_SHOW_SCREEN = 3000L

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ShowLogin -> showLogin()
                SplashViewState.ShowHome -> showHome()
            }
        }
    }

    private fun showLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }

    private fun showHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }
}