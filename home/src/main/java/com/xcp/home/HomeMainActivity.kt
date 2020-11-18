package com.xcp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.xcp.common.utils.RecordPathManager
import kotlinx.android.synthetic.main.activity_home_main.*

class HomeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        Toast.makeText(this, "com.xcp.home.MainActivity", Toast.LENGTH_SHORT).show();
//        val btnToUser = findViewById<Button>(R.id.btn_to_user)
        btn_to_user.setOnClickListener {
            //方式1 类加载,维护成本较高且容易出现人为失误
//            val targetClass = Class.forName("com.xcp.user.UserMainActivity")
//            Intent(this, targetClass).apply {
//                putExtra("name", "DoubleD")
//                startActivity(this)
//            }
            //方式2 全局map
            val targetActivity =
                RecordPathManager.startTargetActivity("user", "UserMainActivity")
            Intent(this, targetActivity).apply {
                putExtra("name", "xuchengpu")
                startActivity(this)
            }


        }
    }
}