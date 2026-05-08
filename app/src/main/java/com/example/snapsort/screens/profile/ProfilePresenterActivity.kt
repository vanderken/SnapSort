package com.example.snapsort.screens.profile

import com.example.snapsort.data.repository.UserRepositoryActivity

class ProfilePresenterActivity(
    private val view: ProfileContractActivity.View
) : ProfileContractActivity.Presenter {

    override fun onViewCreated() {
        val user = UserRepositoryActivity.getLoggedInUser()
        if (user != null) {
            view.showProfileData(
                username = user.username,
                firstName = user.firstName,
                middleName = user.middleName,
                lastName = user.lastName,
                email = user.email
            )
        } else {
            view.navigateToDashboard()
        }
    }

    override fun onBackClicked() {
        view.navigateToDashboard()
    }
}