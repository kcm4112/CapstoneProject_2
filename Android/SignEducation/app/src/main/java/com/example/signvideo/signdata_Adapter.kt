package com.example.signvideo

import android.content.Intent
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.signvideo.LoginActivity.Companion.userWatch
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.MainActivity.Companion.userInform
import com.example.signvideo.databinding.ActivityMainBinding
import com.example.signvideo.databinding.SinglanguageHolderBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class signdata_viewHolder (val binding : SinglanguageHolderBinding) : RecyclerView.ViewHolder(binding.root)
class signdata_Adapter (val dataSet : MutableList<Video>, val mainbinding : ActivityMainBinding) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return signdata_viewHolder(SinglanguageHolderBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    //데이터를 어떻게 처리할 것인지 정의해야함
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as signdata_viewHolder).binding
        var fire = Firebase.database.reference
        var videoNum = 0
        binding.language.text = dataSet[position].name

        binding.language.setOnClickListener() {
            for(i in 0..alllist.size-1) {
                if(alllist[i].name.equals(dataSet[position].name)) {
                    if(!userWatch.contains(dataSet[position].name)) {
                        userWatch = userWatch + " " + dataSet[position].name
                        Log.d("watchData", "Value : ${userWatch}")
                        break
                    }
//                    videoNum = i
//                    Log.d("User Select Video", "VideoIndex : ${videoNum}, name : ${alllist[videoNum].name}")
//                    fire.child("User").child("${userInform}").child("See").setValue("${videoNum}!")
                }
            }
            val intent = Intent(this@signdata_Adapter.mainbinding.recycler.context, VideoActivity::class.java)
            //카테고리랑 단어 뜻 그리고 url정보 보내주기
            intent.putExtra("Category", dataSet[position].category)
            intent.putExtra("Mean", dataSet[position].name)
            intent.putExtra("Url", dataSet[position].url)
            Log.d("Intent Success?", "Success!")
            startActivity(this@signdata_Adapter.mainbinding.recycler.context, intent,null)

        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}