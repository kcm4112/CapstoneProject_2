package com.example.signvideo


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.databinding.SignvideoviewBinding

class VideoActivity : AppCompatActivity() {
    lateinit var binding : SignvideoviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignvideoviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentData_category = intent.getStringExtra("Category")
        val intentData_mean = intent.getStringExtra("Mean")
        val intentData_url = intent.getStringExtra("Url")
        binding.cateLanguage.text = "카테고리 : <" + "${intentData_category}" + ">"
        binding.meanLanguage.text = " \"${intentData_mean}\" "
        binding.signVideo.setVideoURI(Uri.parse(intentData_url))
        binding.signVideo.start()

        Log.d("Intent Data Check", "category : ${intentData_category}, mean : ${intentData_mean}, url : ${intentData_url}")

        //돌아가기 버튼 클릭 리스너
        binding.returnBtn.setOnClickListener() {
            finish()
        }
        //다시보기 버튼 클릭 리스너
        binding.replay.setOnClickListener() {
            binding.signVideo.start()
        }
    }
    fun onPlay(view : View) {
        binding.signVideo.start()
    }
    fun onStop(view : View) {
        binding.signVideo.pause()
    }
}