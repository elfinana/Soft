package com.sunah.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class UserAdapter(val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item, null)

        val img = view.findViewById<ImageView>(R.id.list_img)
        val title = view.findViewById<TextView>(R.id.title_text)
        val time = view.findViewById<TextView>(R.id.time_text)

        val user = UserList[position]

        img.setImageResource(user.img)
        title.text = user.title
        time.text = user.time

        return view

    }

    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}