package br.com.fundatec.fundatecheroti22.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroti22.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroti22.profile.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            when (it) {
                ProfileViewState.Success ->
                    showSnackMessage("Sucesso ao criar o usuário")
                ProfileViewState.Error ->
                    showSnackMessage("Ocorreu um erro ao criar o usuário")
                ProfileViewState.Loading -> TODO()
                ProfileViewState.ShowNameError ->
                    showNameError()
                ProfileViewState.ShowEmailError ->
                    showEmailError()
                ProfileViewState.ShowPasswordError ->
                    showPasswordError()
            }
        }

        configBtCreateUser()
    }

    private fun configBtCreateUser() {
        binding.btCreateUser.setOnClickListener {
            viewModel.validateInputs(
                name = binding.name.text.toString(),
                email = binding.email.text.toString(),
                password = binding.password.text.toString(),
            )
        }
    }

    private fun showNameError() {
        binding.email.error = getString(R.string.email_error)
    }

    private fun showEmailError() {
        binding.email.error = getString(R.string.email_error)
    }

    private fun showPasswordError() {
        binding.password.error = getString(R.string.password_error)
    }

    private fun showSnackMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}