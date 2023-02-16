package com.MyApp.Aplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main2.*


class home : AppCompatActivity() {
    var username: TextView? = null
    var btn1: CardView? = null
    var btn2: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn1 = findViewById<CardView>(R.id.materi1) as CardView
        btn2 = findViewById<CardView>(R.id.tujuan) as CardView


        val extras1 = intent.extras
        val intent = extras1!!.getString("userkey1")
        username = findViewById<View>(R.id.username) as TextView
        if (intent != null) {
            username!!.text = intent
        }


        btn1!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@home, materi::class.java)
            startActivity(intent)

        })
        btn2!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@home, tujuan_pembelajaran::class.java)
            startActivity(intent)

        })
    }
}
