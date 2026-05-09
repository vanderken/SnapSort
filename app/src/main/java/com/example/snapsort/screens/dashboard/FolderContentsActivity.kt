package com.example.snapsort.screens.dashboard

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.snapsort.databinding.ActivityFolderContentsBinding

class FolderContentsActivity: AppCompatActivity(){

    private val imageList = ArrayList<String>()
    private lateinit var imageAdapter: ArrayAdapter<String>
    private lateinit var binding: ActivityFolderContentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFolderContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val folderName = intent.getStringExtra("FOLDER_NAME") ?: "Unknown Folder"
        title = folderName
        imageList.add("photo_001.jpg — Note: Beach sunset")
        imageList.add("photo_002.jpg — Note: Family dinner")
        imageList.add("photo_003.jpg — Note: No note added")
        imageAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, imageList)
        binding.listViewImages.adapter = imageAdapter
        binding.listViewImages.setOnItemClickListener { _, _, position, _ ->
            val selectedImage = imageList[position]
            // TODO: Open image detail view in next step
        }
    }
}

