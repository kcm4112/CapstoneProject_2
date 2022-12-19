package com.example.signvideo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.databinding.LoginActivityBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    companion object {
        var userWatch : String = ""
        var whereFrom = 0 //0이면 회원가입에서 온 것 1이면 프로필에서 로그아웃 한 것
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = LoginActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginId.hint = "아이디"
        binding.loginPw.hint = "비밀번호"
        var key : String? = ""
        if(whereFrom == 0) {
            Log.d("Right Login?", "Success!")
            var dataId = intent.getStringExtra("Id")
            var dataPw = intent.getStringExtra("Pw")
            binding.loginId.setText(dataId)
            binding.loginPw.setText(dataPw)
        }

        Log.d("Right Login2?", "Success!")
        binding.register.setOnClickListener() {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //로그인 버튼 눌렀을 때, User데이터베이스에 user몇인지 찾아서 함께 넘겨주기!
        binding.login.setOnClickListener() {
            var curId = binding.loginId.text.toString()
            Log.d("ID", "Value : ${curId}")
            var fire = Firebase.database.reference
            fire.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (ds in snapshot.children) {
                        when {
                            "User".equals(ds.key) -> {
                                val userAll = snapshot.child("User")
                                Log.d("This is in User", "Success!")
                                for(item in userAll.children) {
                                    Log.d("Check", "${userAll.childrenCount}")
                                    var userKey = item.child("id").value as String

                                    if(userKey.equals(curId)) {
                                        Log.d("Find correct user?", "Success!")
                                        key = item.key.toString()
                                        Log.d("Check key", "${key}")
                                        var intent = Intent(this@LoginActivity, MainActivity::class.java)
                                        //로그인하면, Id값을 넘겨준다.

                                        intent.putExtra("Inform", key)
                                        Log.d("Check", "User : ${key}")
                                        startActivity(intent)
                                        break
                                    }
                                }
                            }
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    print(error.message)
                }

            })
        }
    }
}