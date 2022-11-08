package com.example.transapp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.transapp3.databinding.FragmentTransBinding

class TransFragment : Fragment() {

    private var mBinding : FragmentTransBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        inflate(resource: Int, root: ViewGroup?, attachToRoot: Boolean)
        //          - resource : View를 만들고 싶은 레이아웃 파일의 id
        //          - root: 생성될 View의 parent를 명시
        //          - attachToRoot: true 로 설정해 줄 경우 root의 자식 View로 자동으로 추가, false 일 경우 root는 생성되는 View의 layoutParam을 생성하는데만 사용
        val binding = FragmentTransBinding.inflate(inflater, container, false)
        mBinding = binding

        return mBinding?.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}