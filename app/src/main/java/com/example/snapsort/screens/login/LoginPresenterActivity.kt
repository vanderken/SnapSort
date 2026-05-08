package com.example.snapsort.screens.login

import com.example.snapsort.data.repository.UserRepositoryActivity

class LoginPresenterActivity(
    private val view: LoginContractActivity.View
) : LoginContractActivity.Presenter {

    override fun onLoginClicked(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            view.showError("Please enter username and password.")
            return
        }

        val user = UserRepositoryActivity.login(email, password)

        if (user != null) {
            view.navigateToDashboard()
        } else {
            view.showError("Invalid email or password.")
        }
    }

    override fun onRegisterClicked() {
        view.navigateToRegister()
    }
}