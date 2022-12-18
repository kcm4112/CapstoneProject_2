package com.example.signvideo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import com.example.signvideo.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    companion object {
        var alllist = ArrayList<Video>() //모든 비디오들의 정보를 담고 있는 리스트
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //스피너 객체 불러오기
        val spinnerBtn = findViewById<Spinner>(R.id.spin_category)
        //스피너 어댑터 연결
        spinnerBtn.adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item)
        binding.spinCategory.setSelection(0) //디폴트로 "전체"를 선택한다.

        //Tools -> Firebase를 통해서 Firebase연결 완료함!

        //파이어베이스에서 데이터 불러와서 리사이클러뷰에 보여주기
        var all_video = Firebase.database.reference// 파이어베이스 DB객체를 레퍼런스함.


        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //초기화면 보여주는 부분/
        Log.d("In MainClass", "Success! ${all_video.key}")
        all_video.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(ds in snapshot.children) {
                    when {
                        "Video".equals(ds.key) -> {
                            Log.d("In Video?", "Success!")
                            val videoAll = snapshot.child("Video")
                            Log.d("Database","Value : ${videoAll.childrenCount}")
                            for(item in videoAll.children) {
                                var id : String = item.child("_id").value as String
                                var name : String = item.child("name").value as String
                                var category : String = item.child("category").value as String
                                var url : String = item.child("url").value as String


                                //받은 데이터를 Allmenu클래스에 담기
                                alllist.add(Video(id.toInt(), name, category, url))
                            }
                        }
                    }
                }
                for(i in 0..alllist.size-1) {
                    Log.d("CheckData", "Data ${i} : ${alllist[i].id}, ${alllist[i].name}, ${alllist[i].category}, ${alllist[i].url} \n")
                }

                binding.recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
                binding.recycler.adapter = signdata_Adapter(alllist, binding)
            }

            override fun onCancelled(error: DatabaseError) {
                print(error.message)
            }

        })


        ////////////////////////////////////////////////////////////////////////
        // 스피너 이벤트 구현하는 부분
        binding.spinCategory.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            //다른 카테고리를 선택했을 때 이벤트 리스너 구현
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(binding.spinCategory.selectedItem.equals("전체")) { //전체를 선택한 경우
                    binding.recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
                    binding.recycler.adapter = signdata_Adapter(alllist, binding)
                }
                else if (binding.spinCategory.selectedItem.equals("일상")) { //일상을 선택한 경우
                    var afterall = ArrayList<Video>() //일상 수화비디오 정보만 담을 리스트 생성
                    for(i in 0..alllist.size-1) {
                        if(alllist[i].category.equals("일상")) {
                            afterall.add(alllist[i])
                        }
                    }
                    binding.recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
                    binding.recycler.adapter = signdata_Adapter(afterall, binding)
                }
                else if (binding.spinCategory.selectedItem.equals("신체")) { //신체를 선택한 경우
                    var afterall = ArrayList<Video>() //일상 수화비디오 정보만 담을 리스트 생성
                    for(i in 0..alllist.size-1) {
                        if(alllist[i].category.equals("신체")) {
                            afterall.add(alllist[i])
                        }
                    }
                    binding.recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
                    binding.recycler.adapter = signdata_Adapter(afterall, binding)


                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.moveGame.setOnClickListener() {
            var intent = Intent(this, SignGame::class.java)
            startActivity(intent)
        }
    }
}