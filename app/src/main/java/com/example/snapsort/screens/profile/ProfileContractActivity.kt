package com.example.snapsort.screens.profile

interface ProfileContractActivity {

    interface View {
        fun showProfileData(
            username: String,
            firstName: String,
            middleName: String,
            lastName: String,
            email: String
        )
        fun navigateToDashboard()
    }

    interface Presenter {
        fun onViewCreated()
        fun onBackClicked()
    }
}