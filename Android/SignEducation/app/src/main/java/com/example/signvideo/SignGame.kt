package com.example.signvideo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.databinding.SigngameBinding

class SignGame : AppCompatActivity() {
    lateinit var binding : SigngameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SigngameBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}