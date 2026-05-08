package com.example.snapsort.screens.register

interface RegisterContractActivity {

    interface View {
        fun showError(message: String)
        fun showSuccess(message: String)
        fun navigateToLogin()
    }

    interface Presenter {
        fun onRegisterClicked(
            username: String,
            firstName: String,
            middleName: String,
            lastName: String,
            email: String,
            password: String,
            confirmPassword: String
        )
        fun onBackToLoginClicked()
    }
}