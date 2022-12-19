package com.example.signvideo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.MainActivity.Companion.randomList
import com.example.signvideo.databinding.TestReplayBinding

class TestReplay : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = TestReplayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var indexData = intent.getIntExtra("Index", 0)

        binding.replayCate.text = "카테고리 : <" + "${alllist[randomList[indexData]].category}" + ">"
        binding.replayMean.text = " \"${alllist[randomList[indexData]].name}\" "

        binding.replayVideo.setVideoURI(Uri.parse(alllist[randomList[indexData]].url))
        binding.replayVideo.start()

        binding.replayTestVideo.setOnClickListener() {//다시보기 버튼 클릭시
            binding.replayVideo.start()
        }

        binding.replayReturn.setOnClickListener() {
            val intent = Intent(this, TestScore::class.java)
            startActivity(intent)
        }



    }
}