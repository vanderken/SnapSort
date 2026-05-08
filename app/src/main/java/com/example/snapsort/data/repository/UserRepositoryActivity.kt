package com.example.snapsort.data.repository

import com.example.snapsort.data.models.UserModelActivity

object UserRepositoryActivity {

    private val users = mutableListOf<UserModelActivity>()
    private var loggedInUser: UserModelActivity? = null

    fun register(
        username: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String,
        password: String
    ): Boolean {
        if (users.any { it.email == email }) return false
        val newUser = UserModelActivity(
            id = users.size + 1,
            username = username,
            firstName = firstName,
            middleName = middleName,
            lastName = lastName,
            email = email,
            password = password
        )
        users.add(newUser)
        return true
    }

    fun login(email: String, password: String): UserModelActivity? {
        val user = users.find { it.email == email && it.password == password }
        if (user != null) loggedInUser = user
        return user
    }

    fun logout() {
        loggedInUser = null
    }

    fun getLoggedInUser(): UserModelActivity? = loggedInUser
}