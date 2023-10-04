package br.com.fundatec.fundatecheroti22.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroti22.home.view.HomeActivity
import br.com.fundatec.fundatecheroti22.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroti22.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configButtonLogin()
        configNewHereButton()
    }

    private fun configButtonLogin() {
        binding.btLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
        }
    }

    private fun configNewHereButton() {
        binding.tvNewHere.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        }
    }

}
