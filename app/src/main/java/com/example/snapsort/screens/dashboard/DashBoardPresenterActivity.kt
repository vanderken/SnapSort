package com.example.snapsort.screens.dashboard

import com.example.snapsort.data.repository.UserRepositoryActivity

class DashBoardPresenterActivity(
    private val view: DashBoardContractActivity.View
) : DashBoardContractActivity.Presenter {

    override fun onViewCreated() {
        val user = UserRepositoryActivity.getLoggedInUser()
        if (user != null) {
            view.showWelcomeMessage(user.username)
        } else {
            view.navigateToLogin()
        }
    }

    override fun onLogoutClicked() {
        UserRepositoryActivity.logout()
        view.navigateToLogin()
    }

    override fun onProfileClicked() {
        view.navigateToProfile()
    }
}