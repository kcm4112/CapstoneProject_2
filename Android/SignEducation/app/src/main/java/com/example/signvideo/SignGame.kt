package com.example.signvideo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.MainActivity.Companion.checkList
import com.example.signvideo.MainActivity.Companion.randomList
import com.example.signvideo.databinding.SigngameBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SignGame : AppCompatActivity() {
    lateinit var binding : SigngameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //체크리스트 초기화
//        checkList = ArrayList<Int>()
        super.onCreate(savedInstanceState)
        binding = SigngameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("RandomList", "Value : ${randomList}")
        var data = intent.getIntExtra("Count", 0)
//        Log.d("Count", "Value : ${data}")
        if(data == 10) {
            //게임 결과 확인!
//            for(i in 0..checkList.size-1) {
//                Log.d("CheckList", "data : ${checkList[i]}")
//            }
            val intent = Intent(this, TestScore::class.java)
            startActivity(intent)
            finish()
        }
        else {
            var cnt = data
            when {
                cnt == 0 -> {
                    binding.btn1.setImageResource(R.drawable.one_t)
                }
                cnt == 1 -> {
                    binding.btn2.setImageResource(R.drawable.two_t)
                }
                cnt == 2 -> {
                    binding.btn3.setImageResource(R.drawable.three_t)
                }
                cnt == 3 -> {
                    binding.btn4.setImageResource(R.drawable.four_t)
                }
                cnt == 4 -> {
                    binding.btn5.setImageResource(R.drawable.five_t)
                }
                cnt == 5 -> {
                    binding.btn6.setImageResource(R.drawable.six_t)
                }
                cnt == 6 -> {
                    binding.btn7.setImageResource(R.drawable.seven_t)
                }
                cnt == 7 -> {
                    binding.btn8.setImageResource(R.drawable.eight_t)
                }
                cnt == 8 -> {
                    binding.btn9.setImageResource(R.drawable.nine_t)
                }
                cnt == 9 -> {
                    binding.btn10.setImageResource(R.drawable.ten_t)
                }
            }
//            Log.d("NO", "This it not right area!")
            val range = (0..38) //index 0~38까지의 데이터 중에서
            var randomValue = -1



            var realList = ArrayList<Int>()


            //디폴트로 첫 번째 문제는 그냥 보여줄 것임!

            var index = randomList[cnt] //randomList에서 제일 첫 번째 영상을 골라 보여준다.
            var game_url = alllist[index].url
            binding.gameVideo.setVideoURI(Uri.parse(game_url))
            binding.gameVideo.start()

            var answer = alllist[index].name
            var false1 = alllist[(index + 1)%38].name
            var false2 = alllist[(index + 2)%38].name

            //답이 될 수 있는 후보를 만든다!
            var answerList = ArrayList<String>()
            answerList.add(answer)
            answerList.add(false1)
            answerList.add(false2)

            //0,1,2중에 랜덤으로 뽑아서 indexList에 넣는다.
            val set2 = mutableSetOf<Int>()
            while(set2.size < 3) {
                set2.add((0..2).random())
            }

            var indexList = ArrayList(set2)
            //indexList에 0,1,2번째 인덱스의 숫자를 골라서 %3하여 text에 넣는다.
            //text에 넣을 때는 answerList(후보 3개의 리스트)에서 랜덤으로 뽑아서 넣는다!
            binding.answer0.text = answerList[indexList[0]%3]
            binding.answer1.text = answerList[indexList[1]%3]
            binding.answer2.text = answerList[indexList[2]%3]

            binding.answer0.setOnClickListener() {
                if(binding.answer0.text.toString().equals(alllist[index].name)) { //정답이라면?
                    checkList.add(1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
                else {//아니라면?
                    checkList.add(-1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
            }
            binding.answer1.setOnClickListener() {
                if(binding.answer1.text.toString().equals(alllist[index].name)) { //정답이라면?
                    checkList.add(1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
                else {//아니라면?
                    checkList.add(-1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
            }
            binding.answer2.setOnClickListener() {
                if(binding.answer2.text.toString().equals(alllist[index].name)) { //정답이라면?
                    checkList.add(1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
                else {//아니라면?
                    checkList.add(-1)
                    cnt++
                    val intent = Intent(this, SignGame::class.java)
                    intent.putExtra("Count", cnt)
                    startActivity(intent)
                }
            }
        }

//        while(true) {
//            if(cnt > 9) {
//                break
//            }
//            runBlocking {
//                launch {

//                }
//                //게임 다시 해주는 함수 사용하기
//                restart(cnt)
//            }
//        }
//




    }

//    fun restart(cnt : Int) {
//        var index = randomList[cnt] //randomList에서 제일 첫 번째 영상을 골라 보여준다.
//        var game_url = alllist[index].url
//        binding.gameVideo.setVideoURI(Uri.parse(game_url))
//        binding.gameVideo.start()
//
//        var answer = alllist[index].name
//        var false1 = alllist[(index + 1)%38].name
//        var false2 = alllist[(index + 2)%38].name
//
//        //답이 될 수 있는 후보를 만든다!
//        var answerList = ArrayList<String>()
//        answerList.add(answer)
//        answerList.add(false1)
//        answerList.add(false2)
//
//        //0,1,2중에 랜덤으로 뽑아서 indexList에 넣는다.
//        val set2 = mutableSetOf<Int>()
//        while(set2.size < 3) {
//            set2.add((0..2).random())
//        }
//
//        var indexList = ArrayList(set2)
//        //indexList에 0,1,2번째 인덱스의 숫자를 골라서 %3하여 text에 넣는다.
//        //text에 넣을 때는 answerList(후보 3개의 리스트)에서 랜덤으로 뽑아서 넣는다!
//        binding.answer0.text = answerList[indexList[0]%3]
//        binding.answer1.text = answerList[indexList[1]%3]
//        binding.answer2.text = answerList[indexList[2]%3]
//    }
}