package com.example.signvideo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.databinding.SignPracticeBinding

class SignPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = SignPracticeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.practiceVideo.setVideoURI(Uri.parse(alllist[1].url))
        binding.practiceVideo.start()


        binding.startGame.setOnClickListener() {
            val intent = Intent(this, SignGame::class.java)
            startActivity(intent)
        }
    }
}