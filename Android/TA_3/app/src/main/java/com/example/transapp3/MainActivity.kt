package com.example.transapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.transapp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //네비게이션을 담는 호스트
        //activity_main에서 프레그먼트 컨테이너뷰의 id를 가져와서 그것을 management한다.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션 뷰와 네비게이션을 묶어준다
        //activity_main의 바텀 네비게이션 뷰를 가져와서 컨트롤러와 연결해준다.
        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)
    }
}