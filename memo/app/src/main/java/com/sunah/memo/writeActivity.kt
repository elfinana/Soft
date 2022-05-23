package com.sunah.memo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Gallery
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import java.text.SimpleDateFormat
import java.util.*

class writeActivity : AppCompatActivity() {
    private val GALLERY = 1
    val FLAG_REQ_CAMERA = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)


        val back = findViewById<ImageView>(R.id.btn_back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        clickSave()

        val camera: View = findViewById(R.id.camera)
        camera.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, GALLERY)
        }
    }

    fun clickSave() {
        val save: View = findViewById(R.id.save)
        val write_title = findViewById<EditText>(R.id.write_title)
        save.setOnClickListener {
            val title = write_title.text.toString()
            Log.d("test", "타이틀값1:${title}")
            Log.d("test", "타이틀값2:${write_title.text}")
            val success = Toast.makeText(this, "저장이 완료되었습니다.", Toast.LENGTH_LONG)
            success.show()
        }
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val write_main: View = findViewById(R.id.write_main)

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY) {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this, ImnageData.toString(), Toast.LENGTH_SHORT).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    write_main.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}

private fun View.setImageBitmap(bitmap: Bitmap?) {

}

