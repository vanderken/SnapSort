package com.example.snapsort.screens.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.snapsort.databinding.ActivityDashboardBinding
import com.example.snapsort.screens.login.LoginActivity
import com.example.snapsort.screens.profile.ProfileActivity

class DashboardActivity : AppCompatActivity(), DashBoardContractActivity.View {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var presenter: DashBoardPresenterActivity
    private val folderList = ArrayList<String>()
    private lateinit var folderAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        // ✅ STEP 1: Always call super FIRST
        super.onCreate(savedInstanceState)

        // ✅ STEP 2: Create binding SECOND — before anything else
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ STEP 3: NOW it is safe to use binding
        presenter = DashBoardPresenterActivity(this)
        presenter.onViewCreated()

        // ✅ STEP 4: Set up folder list AFTER binding exists
        folderList.add("Vacation Photos")
        folderList.add("School")
        folderList.add("Family")

        folderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            folderList
        )

        binding.listViewFolders.adapter = folderAdapter

        binding.listViewFolders.setOnItemClickListener { _, _, position, _ ->
            val selectedFolder = folderList[position]
            val intent = Intent(this, FolderContentsActivity::class.java)
            intent.putExtra("FOLDER_NAME", selectedFolder)
            startActivity(intent)
        }

        // ✅ STEP 5: Set up button listeners
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