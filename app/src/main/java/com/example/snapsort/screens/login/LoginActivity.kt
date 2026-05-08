package com.example.snapsort.screens.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.snapsort.databinding.ActivityLoginBinding
import com.example.snapsort.screens.dashboard.DashboardActivity
import com.example.snapsort.screens.register.RegisterActivity

class LoginActivity : AppCompatActivity(), LoginContractActivity.View {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginContractActivity.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenterActivity(this)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            presenter.onLoginClicked(email, password)
        }

        binding.tvCreateAccount.setOnClickListener {
            presenter.onRegisterClicked()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}