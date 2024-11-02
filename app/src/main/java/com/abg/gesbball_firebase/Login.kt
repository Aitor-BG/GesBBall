package com.abg.gesbball_firebase


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login: AppCompatActivity() {

    private lateinit var et_userlog:EditText
    private lateinit var et_passlog:EditText
    private lateinit var bt_loginlog:Button
    private lateinit var bt_regislog:Button
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        db = FirebaseDatabase.getInstance().getReference("Users")
        et_userlog=findViewById(R.id.ET_USERLOG)
        et_passlog=findViewById(R.id.ET_PASSLOG)
        bt_loginlog=findViewById(R.id.BT_LOGINLOG)
        bt_regislog=findViewById(R.id.BT_REGISLOG)

        bt_loginlog.setOnClickListener {
            //Recogemos los datos expuestos en el EditText
            val user_et = et_userlog.text.toString()
            val pass_et = et_passlog.text.toString()
            //Recorremos la base de datos
            db.child(user_et).addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        val datoscuentas = snapshot.getValue(CuentasDB::class.java)
                        //Comparamos que los valores de la base de datos y los del EditText sean los mismos
                        if(datoscuentas?.user.equals(user_et) && datoscuentas?.pass.equals(pass_et.hashCode().toString())){
                            val intent = Intent(this@Login, Menu::class.java)
                            startActivity(intent)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }

        //Nos dirigimos a la pestaña de Registro
        bt_regislog.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}