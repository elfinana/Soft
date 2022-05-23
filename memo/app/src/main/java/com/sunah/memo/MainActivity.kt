package com.sunah.memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.note, "제목", "날짜"),
        User(R.drawable.note, "바보", "3시"),
        User(R.drawable.note, "똥", "멍")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Adapter = UserAdapter(this, UserList)
        val mlistview = findViewById<ListView>(R.id.listView)
        mlistview.adapter = Adapter

        val intent = Intent(this,writeActivity::class.java)

       val fab: View = findViewById(R.id.plus_btn)
        fab.setOnClickListener{startActivity(intent)}


    }

}