package br.com.fundatec.fundatecheroti22.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.view.HomeActivity
import br.com.fundatec.fundatecheroti22.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheroti22.profile.view.ProfileActivity
import br.com.fundatec.fundatecheroti22.visible
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configButtonLogin()
        configNewHereButton()

        viewModel.state.observe(this) {
            when (it) {
                LoginViewState.ShowErrorMessage -> showSnackMessage()
                LoginViewState.Loading -> binding.pbLoader.visible()
                LoginViewState.ShowEmailError -> showEmailError()
                LoginViewState.ShowPasswordError -> showPasswordError()
                LoginViewState.ShowHomeScreen ->
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            }
        }
    }

    private fun configButtonLogin() {
        binding.btLogin.setOnClickListener {
            viewModel.validateInputs(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    private fun configNewHereButton() {
        binding.tvNewHere.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        }
    }

    private fun showEmailError() {
        binding.pbLoader.gone()
        binding.email.error = getString(R.string.email_error)
    }

    private fun showPasswordError() {
        binding.pbLoader.gone()
        binding.password.error = getString(R.string.password_error)
    }

    private fun showSnackMessage() {
        binding.pbLoader.gone()

        Snackbar.make(
            binding.root,
            R.string.login_error,
            Snackbar.LENGTH_LONG
        ).show()
    }

}
