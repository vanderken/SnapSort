package com.example.snapsort.screens.dashboard

interface DashBoardContractActivity {

    interface View {
        fun showWelcomeMessage(username: String)
        fun navigateToLogin()
        fun navigateToProfile()
    }

    interface Presenter {
        fun onViewCreated()
        fun onLogoutClicked()
        fun onProfileClicked()
    }
}