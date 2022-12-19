package com.example.signvideo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.signvideo.MainActivity.Companion.alllist
import com.example.signvideo.MainActivity.Companion.checkList
import com.example.signvideo.MainActivity.Companion.randomList
import com.example.signvideo.databinding.TestScoreBinding

class TestScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = TestScoreBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("TestScore", "Value : ${checkList}")

        //id종류
        //이미지 = score1, ..., score10
        //텍스트 = num1, ..., num10
        //다시보기 버튼 = learn1, ..., learn10
        //채점 기록을 보면서 게임 결과 보여주기
        var count = 0 //틀린 개수를 저장할 count
        for(i in 0..checkList.size-1) {
            if(checkList[i] == -1) {
                count++
            }
        }

        binding.gamescore.text = "틀린개수는 ${count}개 입니다."

        for(i in 0..checkList.size-1) {
            if(checkList[i] == 1) {//문제를 맞혔을때
                when {
                    i == 0 -> {
                        binding.score1.setImageResource(R.drawable.one_blue)
                        binding.num1.text = alllist[randomList[i]].name
                        binding.learn1.visibility = View.INVISIBLE
                    }
                    i == 1 -> {
                        binding.score2.setImageResource(R.drawable.two_blue)
                        binding.num2.text = alllist[randomList[i]].name
                        binding.learn2.visibility = View.INVISIBLE
                    }
                    i == 2 -> {
                        binding.score3.setImageResource(R.drawable.three_blue)
                        binding.num3.text = alllist[randomList[i]].name
                        binding.learn3.visibility = View.INVISIBLE
                    }
                    i == 3 -> {
                        binding.score4.setImageResource(R.drawable.four_blue)
                        binding.num4.text = alllist[randomList[i]].name
                        binding.learn4.visibility = View.INVISIBLE
                    }
                    i == 4 -> {
                        binding.score5.setImageResource(R.drawable.five_blue)
                        binding.num5.text = alllist[randomList[i]].name
                        binding.learn5.visibility = View.INVISIBLE
                    }
                    i == 5 -> {
                        binding.score6.setImageResource(R.drawable.six_blue)
                        binding.num6.text = alllist[randomList[i]].name
                        binding.learn6.visibility = View.INVISIBLE
                    }
                    i == 6 -> {
                        binding.score7.setImageResource(R.drawable.seven_blue)
                        binding.num7.text = alllist[randomList[i]].name
                        binding.learn7.visibility = View.INVISIBLE
                    }
                    i == 7 -> {
                        binding.score8.setImageResource(R.drawable.eight_blue)
                        binding.num8.text = alllist[randomList[i]].name
                        binding.learn8.visibility = View.INVISIBLE
                    }
                    i == 8 -> {
                        binding.score9.setImageResource(R.drawable.nine_blue)
                        binding.num9.text = alllist[randomList[i]].name
                        binding.learn9.visibility = View.INVISIBLE
                    }
                    i == 9 -> {
                        binding.score10.setImageResource(R.drawable.ten_blue)
                        binding.num10.text = alllist[randomList[i]].name
                        binding.learn10.visibility = View.INVISIBLE
                    }
                }
            }
            else if(checkList[i] == -1) {
                when {
                    i == 0 -> {
                        binding.score1.setImageResource(R.drawable.one_red)
                        binding.num1.text = alllist[randomList[i]].name

                    }
                    i == 1 -> {
                        binding.score2.setImageResource(R.drawable.two_red)
                        binding.num2.text = alllist[randomList[i]].name

                    }
                    i == 2 -> {
                        binding.score3.setImageResource(R.drawable.three_red)
                        binding.num3.text = alllist[randomList[i]].name

                    }
                    i == 3 -> {
                        binding.score4.setImageResource(R.drawable.four_red)
                        binding.num4.text = alllist[randomList[i]].name

                    }
                    i == 4 -> {
                        binding.score5.setImageResource(R.drawable.five_red)
                        binding.num5.text = alllist[randomList[i]].name

                    }
                    i == 5 -> {
                        binding.score6.setImageResource(R.drawable.six_red)
                        binding.num6.text = alllist[randomList[i]].name

                    }
                    i == 6 -> {
                        binding.score7.setImageResource(R.drawable.seven_red)
                        binding.num7.text = alllist[randomList[i]].name

                    }
                    i == 7 -> {
                        binding.score8.setImageResource(R.drawable.eight_red)
                        binding.num8.text = alllist[randomList[i]].name

                    }
                    i == 8 -> {
                        binding.score9.setImageResource(R.drawable.nine_red)
                        binding.num9.text = alllist[randomList[i]].name

                    }
                    i == 9 -> {
                        binding.score10.setImageResource(R.drawable.ten_red)
                        binding.num10.text = alllist[randomList[i]].name

                    }

                }

            }
        }

        //다시보기 버튼 이벤트 클릭 리스너 등록
        binding.learn1.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 0) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn2.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 1) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn3.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 2) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn4.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 3) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn5.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 4) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn6.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 5) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn7.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 6) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn8.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 7) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn9.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 8) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.learn10.setOnClickListener() {
            val intent = Intent(this, TestReplay::class.java)
            intent.putExtra("Index", 9) //randomList의 인덱스 번호를 넘겨준다.
            startActivity(intent)
        }
        binding.testpageGohome.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}