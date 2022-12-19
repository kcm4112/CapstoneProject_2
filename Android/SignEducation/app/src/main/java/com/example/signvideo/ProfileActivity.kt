package com.example.signvideo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.LoginActivity.Companion.userWatch
import com.example.signvideo.LoginActivity.Companion.whereFrom
import com.example.signvideo.MainActivity.Companion.userInform
import com.example.signvideo.databinding.ProfileLayoutBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ProfileLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var fire = Firebase.database.reference
        Log.d("watchData", "Value : ${userInform}")
        //데이터 저장하고, 로그아웃 할 수 있다.
//        fire.child("User").child("${userInform}").child("See").setValue("${userWatch}")
        var stringArr = userWatch.split(" ")
        var finalString : String = ""
        for(i in 1..stringArr.size-1) {
            finalString = finalString + " " + stringArr[i]
        }
        binding.videoHistory.text = finalString
        Log.d("Value", "${finalString}")

        binding.goBack.setOnClickListener() {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.logout.setOnClickListener() {
            //로그아웃 할 떄 시청한 데이터 저장!
            whereFrom = 1
//            Log.d("User Check", "Value : ${userInform}")
//            fire.child("User").child("${userInform}").child("See").setValue("${userWatch.toString()}")
            var intent = Intent(this, LoginActivity::class.java)
            Log.d("Right Logout?", "Success!")
            startActivity(intent)
        }
    }
}