package com.example.signvideo

import android.content.Intent
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.signvideo.databinding.ActivityMainBinding
import com.example.signvideo.databinding.SinglanguageHolderBinding

class signdata_viewHolder (val binding : SinglanguageHolderBinding) : RecyclerView.ViewHolder(binding.root)
class signdata_Adapter (val dataSet : MutableList<Video>, val mainbinding : ActivityMainBinding) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return signdata_viewHolder(SinglanguageHolderBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    //데이터를 어떻게 처리할 것인지 정의해야함
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as signdata_viewHolder).binding
        binding.language.text = dataSet[position].name

        binding.language.setOnClickListener() {
            val intent = Intent(this@signdata_Adapter.mainbinding.recycler.context, VideoActivity::class.java)
            //카테고리랑 단어 뜻 그리고 url정보 보내주기
            intent.putExtra("Category", dataSet[position].category)
            intent.putExtra("Mean", dataSet[position].name)
            intent.putExtra("Url", dataSet[position].url)
            startActivity(this@signdata_Adapter.mainbinding.recycler.context, intent,null)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}