package com.example.todolist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
mục đích kế thừa AppCompatActivity là để ứng dụng chạy được trên các phiên bảng
Android cũ
*/
class MainActivity : AppCompatActivity(), TaskAdater.OnTaskListener {

    /*
    biến binding đại diện cho layout activity_task_detail.xml
    dùng lateinit vì chưa gán giá trị ngay, sẽ được gán giá trị trong onCreate()
    */
    private lateinit var binding: ActivityTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        // tạo đối tượng binding bằng cách "inflate" file XML layout
        binding = ActivityTaskDetailBinding.inflate(layoutFlater)
    }
}
