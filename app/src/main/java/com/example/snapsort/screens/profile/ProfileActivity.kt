package com.example.snapsort.screens.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.snapsort.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity(), ProfileContractActivity.View {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var presenter: ProfileContractActivity.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = ProfilePresenterActivity(this)
        presenter.onViewCreated()

        binding.btnBack.setOnClickListener {
            presenter.onBackClicked()
        }
    }

    override fun showProfileData(
        username: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String
    ) {
        binding.tvUsername.text = username
        binding.tvFirstName.text = firstName
        binding.tvMiddleName.text = middleName
        binding.tvLastName.text = lastName
        binding.tvEmail.text = email
    }

    override fun navigateToDashboard() {
        finish()
    }
}