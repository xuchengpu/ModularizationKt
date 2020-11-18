package com.xcp.modularization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.xcp.common.utils.Config
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BuildConfig.isRelease) {
            Log.e(Config.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library")
        } else {
            Log.e(Config.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行")
        }

        btn_home.setOnClickListener {
            val intent = Intent(this, com.xcp.home.HomeMainActivity::class.java)
            startActivity(intent)
        }
    }
}