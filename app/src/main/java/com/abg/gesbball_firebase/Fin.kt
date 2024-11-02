package com.abg.gesbball_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Fin : AppCompatActivity() {

    private lateinit var si: Button
    private lateinit var no: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fin)

        si=findViewById(R.id.BT_SI)
        no=findViewById(R.id.BT_NO)

        //Si pulsamos que queremos acabar el partido volvemos a Menu
        si.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        //Si pulsamos que no queremos, volvemos a partido
        no.setOnClickListener {
            val intent = Intent(this, Partido::class.java)
            startActivity(intent)
        }

    }


}