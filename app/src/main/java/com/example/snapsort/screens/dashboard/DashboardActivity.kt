package com.example.snapsort.screens.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.snapsort.databinding.ActivityDashboardBinding
import com.example.snapsort.screens.login.LoginActivity
import com.example.snapsort.screens.profile.ProfileActivity

class DashboardActivity : AppCompatActivity(), DashBoardContractActivity.View {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var presenter: DashBoardContractActivity.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = DashBoardPresenterActivity(this)
        presenter.onViewCreated()

        binding.btnLogout.setOnClickListener {
            presenter.onLogoutClicked()
        }

        binding.btnProfile.setOnClickListener {
            presenter.onProfileClicked()
        }

        binding.btnAddPhoto.setOnClickListener {
            Toast.makeText(this, "Add Photo coming soon!", Toast.LENGTH_SHORT).show()
        }

        binding.btnTakePhoto.setOnClickListener {
            Toast.makeText(this, "Take Photo coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showWelcomeMessage(username: String) {
        binding.tvWelcome.text = "$username 👋"
    }

    override fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}