package com.xcp.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xcp.arouter_annotation.ARouter

@ARouter(path="/user/UserMainActivity")
class UserMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        val name = intent.getStringExtra("name")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}