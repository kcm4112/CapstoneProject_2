package com.example.signvideo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.LoginActivity.Companion.whereFrom
import com.example.signvideo.databinding.RegisterActivityBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity(){
    lateinit var database: DatabaseReference
    var itemCount : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = RegisterActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database = Firebase.database.reference
        whereFrom = 0
        binding.register.setOnClickListener() {
            var id = binding.regiId.text.toString()
            var pw = binding.regiPw.text.toString()
            var user = User(id, pw, "")
            addItem(user)

            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("Id", binding.regiId.text.toString())
            intent.putExtra("Pw", binding.regiPw.text.toString())
            startActivity(intent)

        }
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Data", "Count : ${snapshot.child("User").childrenCount}")
                itemCount = snapshot.child("User").childrenCount
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

    fun addItem(user : User) {
        itemCount++
        var key = "user" + itemCount.toString()
        database.child("User").child(key).setValue(user)
    }
}