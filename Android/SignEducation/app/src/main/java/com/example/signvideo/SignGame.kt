package com.example.signvideo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.MainActivity.Companion.randomList
import com.example.signvideo.databinding.SigngameBinding

class SignGame : AppCompatActivity() {
    lateinit var binding : SigngameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SigngameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val range = (0..38) //index 0~38까지의 데이터 중에서
        var randomValue = -1
        var before = -1
        var cnt = 0
        var realList = ArrayList<Int>()
        val set = mutableSetOf<Int>()
        while(set.size < 10) {
            set.add((0..38).random())
        }
        Log.d("Random", "Data : ${set}")

        randomList = ArrayList(set)




    }
}