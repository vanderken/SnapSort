package com.example.snapsort.screens.login

interface LoginContractActivity {

    interface View {
        fun showError(message: String)
        fun navigateToDashboard()
        fun navigateToRegister()
    }

    interface Presenter {
        fun onLoginClicked(email: String, password: String)
        fun onRegisterClicked()
    }
}