package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_event = findViewById<Button>(R.id.button)

        btn_event.setOnClickListener(){

        }

        // 버튼에 람다식을 사용 할 수 있다.
        // 1. Kotlin interfave가 아닌 자바 인터페이스여야 한다.
        // 2. 그 인터페이스는 딱 하나의 메소드만 가져야 한다.

    }

}