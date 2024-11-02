package com.abg.gesbball_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {

    private lateinit var et_nombre: EditText
    private lateinit var et_user: EditText
    private lateinit var et_pass: EditText
    private lateinit var bt_regis:Button
    private lateinit var bt_login:Button
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseDatabase.getInstance().getReference("Users")
        et_nombre=findViewById(R.id.ET_NOMBRE)
        et_user=findViewById(R.id.ET_USER)
        et_pass=findViewById(R.id.ET_PASS)
        bt_regis=findViewById(R.id.BT_REGIS)
        bt_login=findViewById(R.id.BT_LOGIN)

        bt_regis.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val user = et_user.text.toString()
            val pass = et_pass.text.toString()
            //Ciframos la contraseña para que no se lea en la base de datos
            val passC = pass.hashCode().toString()
            val datoscuentas = CuentasDB(nombre,user,passC)

            //Recorremos la base de datos para ver si el usuario existe, si es así no puede registrarse
            db.child(user).addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                            Toast.makeText(applicationContext, "USUARIO YA EXISTE", Toast.LENGTH_SHORT).show()
                    }else{
                        db.child(user).setValue(datoscuentas)
                        Toast.makeText(applicationContext, "USUARIO REGISTRADO", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, Login::class.java)
                        startActivity(intent)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
        }

        //Nos dirigimos a la pestaña de login
        bt_login.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}