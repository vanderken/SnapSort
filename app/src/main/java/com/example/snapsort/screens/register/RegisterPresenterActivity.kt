package com.example.snapsort.screens.register

import com.example.snapsort.data.repository.UserRepositoryActivity

class RegisterPresenterActivity(
    private val view: RegisterContractActivity.View
) : RegisterContractActivity.Presenter {

    override fun onRegisterClicked(
        username: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (username.isBlank() || firstName.isBlank() ||
            lastName.isBlank() || email.isBlank() || password.isBlank()) {
            view.showError("Please fill in all required fields.")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showError("Please enter a valid email address.")
            return
        }

        if (password.length < 6) {
            view.showError("Password must be at least 6 characters.")
            return
        }

        if (password != confirmPassword) {
            view.showError("Passwords do not match.")
            return
        }

        val success = UserRepositoryActivity.register(
            username, firstName, middleName, lastName, email, password
        )

        if (success) {
            view.showSuccess("Registration successful!")
        } else {
            view.showError("Email already registered. Please log in.")
        }
    }

    override fun onBackToLoginClicked() {
        view.navigateToLogin()
    }
}