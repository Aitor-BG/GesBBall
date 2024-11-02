package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MenuJugadores: AppCompatActivity() {

    private lateinit var ch_jg1: CheckBox
    private lateinit var ch_jg2: CheckBox
    private lateinit var ch_jg3: CheckBox
    private lateinit var ch_jg4: CheckBox
    private lateinit var ch_jg5: CheckBox
    private lateinit var ch_jg6: CheckBox
    private lateinit var ch_jg7: CheckBox
    private lateinit var ch_jg8: CheckBox
    private lateinit var ch_jg9: CheckBox
    private lateinit var ch_jg10: CheckBox
    private lateinit var ch_jg11: CheckBox
    private lateinit var ch_jg12: CheckBox
    private lateinit var ch_jg13: CheckBox
    private lateinit var ch_jg14: CheckBox
    private lateinit var ch_jg15: CheckBox

    private lateinit var tv_jg1: TextView
    private lateinit var tv_jg2: TextView
    private lateinit var tv_jg3: TextView
    private lateinit var tv_jg4: TextView
    private lateinit var tv_jg5: TextView
    private lateinit var tv_jg6: TextView
    private lateinit var tv_jg7: TextView
    private lateinit var tv_jg8: TextView
    private lateinit var tv_jg9: TextView
    private lateinit var tv_jg10: TextView
    private lateinit var tv_jg11: TextView
    private lateinit var tv_jg12: TextView
    private lateinit var tv_jg13: TextView
    private lateinit var tv_jg14: TextView
    private lateinit var tv_jg15: TextView

    private lateinit var bt_banquillo: Button
    private lateinit var nm_jgcnv: TextView
    private lateinit var db: DatabaseReference
    private var jugadores = 0
    private var maxId = 0

    private var isChecked1 = true
    private var isChecked2 = true
    private var isChecked3 = true
    private var isChecked4 = true
    private var isChecked5 = true
    private var isChecked6 = true
    private var isChecked7 = true
    private var isChecked8 = true
    private var isChecked9 = true
    private var isChecked10 = true
    private var isChecked11 = true
    private var isChecked12 = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menujugadores)

        db= FirebaseDatabase.getInstance().getReference("Estadisticas")
        ch_jg1=findViewById(R.id.CH_JG1)
        ch_jg2=findViewById(R.id.CH_JG2)
        ch_jg3=findViewById(R.id.CH_JG3)
        ch_jg4=findViewById(R.id.CH_JG4)
        ch_jg5=findViewById(R.id.CH_JG5)
        ch_jg6=findViewById(R.id.CH_JG6)
        ch_jg7=findViewById(R.id.CH_JG7)
        ch_jg8=findViewById(R.id.CH_JG8)
        ch_jg9=findViewById(R.id.CH_JG9)
        ch_jg10=findViewById(R.id.CH_JG10)
        ch_jg11=findViewById(R.id.CH_JG11)
        ch_jg12=findViewById(R.id.CH_JG12)
        ch_jg13=findViewById(R.id.CH_JG13)
        ch_jg14=findViewById(R.id.CH_JG14)
        ch_jg15=findViewById(R.id.CH_JG15)

        tv_jg1=findViewById(R.id.TV_JG1)
        tv_jg2=findViewById(R.id.TV_JG2)
        tv_jg3=findViewById(R.id.TV_JG3)
        tv_jg4=findViewById(R.id.TV_JG4)
        tv_jg5=findViewById(R.id.TV_JG5)
        tv_jg6=findViewById(R.id.TV_JG6)
        tv_jg7=findViewById(R.id.TV_JG7)
        tv_jg8=findViewById(R.id.TV_JG8)
        tv_jg9=findViewById(R.id.TV_JG9)
        tv_jg10=findViewById(R.id.TV_JG10)
        tv_jg11=findViewById(R.id.TV_JG11)
        tv_jg12=findViewById(R.id.TV_JG12)
        tv_jg13=findViewById(R.id.TV_JG13)
        tv_jg14=findViewById(R.id.TV_JG14)
        tv_jg15=findViewById(R.id.TV_JG15)

        nm_jgcnv=findViewById(R.id.NM_JGCNV)
        bt_banquillo=findViewById(R.id.BT_BANQUILLO)

        //Marcamos el jugador a convocar, y con la variable jugadores comprobamos un máximo de 12 y
        // mínimo de 5, en caso de haberse elegido ya 12, se deshabilitan los jugadores que falten.
        ch_jg1.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked1: Boolean ->
            if (isChecked1) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg15.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg15.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg2.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked2: Boolean ->
            if (isChecked2) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg3.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked3: Boolean ->
            if (isChecked3) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg4.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked4: Boolean ->
            if (isChecked4) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg5.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked5: Boolean ->
            if (isChecked5) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg6.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked6: Boolean ->
            if (isChecked6) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg7.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked7: Boolean ->
            if (isChecked7) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg8.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked8: Boolean ->
            if (isChecked8) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg9.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked9: Boolean ->
            if (isChecked9) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg10.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked10: Boolean ->
            if (isChecked10) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg11.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked11: Boolean ->
            if (isChecked11) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg12.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked12: Boolean ->
            if (isChecked12) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg13.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked13: Boolean ->
            if (isChecked13) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg15.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg15.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        ch_jg14.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked14: Boolean ->
            if (isChecked14) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg15.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg15.isEnabled = true
                }
            }
        }

        ch_jg15.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked15: Boolean ->
            if (isChecked15) {
                jugadores += 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores == 12) {
                    ch_jg1.isEnabled = false
                    ch_jg2.isEnabled = false
                    ch_jg3.isEnabled = false
                    ch_jg4.isEnabled = false
                    ch_jg5.isEnabled = false
                    ch_jg6.isEnabled = false
                    ch_jg7.isEnabled = false
                    ch_jg8.isEnabled = false
                    ch_jg9.isEnabled = false
                    ch_jg10.isEnabled = false
                    ch_jg11.isEnabled = false
                    ch_jg12.isEnabled = false
                    ch_jg13.isEnabled = false
                    ch_jg14.isEnabled = false
                }
            } else {
                jugadores -= 1
                nm_jgcnv.setText(jugadores.toString())
                if (jugadores != 12) {
                    ch_jg1.isEnabled = true
                    ch_jg2.isEnabled = true
                    ch_jg3.isEnabled = true
                    ch_jg4.isEnabled = true
                    ch_jg5.isEnabled = true
                    ch_jg6.isEnabled = true
                    ch_jg7.isEnabled = true
                    ch_jg8.isEnabled = true
                    ch_jg9.isEnabled = true
                    ch_jg10.isEnabled = true
                    ch_jg11.isEnabled = true
                    ch_jg12.isEnabled = true
                    ch_jg13.isEnabled = true
                    ch_jg14.isEnabled = true
                }
            }
        }

        //Recorremos la base de datos para crear el id de la base de datos
        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    maxId=(snapshot.getChildrenCount().toInt())
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        bt_banquillo.setOnClickListener {
            //Si hubiera 5 o más convocados
            if (jugadores >= 5) {
                val sharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val partidoG = sharedPreferences.getString("partido", "")
                editor.putInt("cantidad",jugadores)

                //Si el partido no es nulo creamos una lista emparejando nombres con el checkbox
                if (partidoG != null) {
                    val jugadoresList = listOf(
                        Pair(tv_jg1, ch_jg1), Pair(tv_jg2, ch_jg2), Pair(tv_jg3, ch_jg3),
                        Pair(tv_jg4, ch_jg4), Pair(tv_jg5, ch_jg5), Pair(tv_jg6, ch_jg6),
                        Pair(tv_jg7, ch_jg7), Pair(tv_jg8, ch_jg8), Pair(tv_jg9, ch_jg9),
                        Pair(tv_jg10, ch_jg10), Pair(tv_jg11, ch_jg11), Pair(tv_jg12, ch_jg12),
                        Pair(tv_jg13,ch_jg13), Pair(tv_jg14,ch_jg14), Pair(tv_jg15,ch_jg15)
                    )

                    val selectedPlayers = mutableListOf<String>()

                    //Recorremos la lista y a cada jugador marcado le otrogamos sus estadísticas iniciales creando el registro en la base de datos
                    jugadoresList.forEach { (jugadorTextView, jugadorCheckBox) ->
                        if (jugadorCheckBox.isChecked) {
                            val fecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                            val stats = EstadisticasDB(jugadorTextView.text.toString(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,partidoG,fecha)
                            val playerName = jugadorTextView.text.toString()
                            selectedPlayers.add(playerName)
                            db.child(jugadorTextView.text.toString() + " " + partidoG + " " + fecha).setValue(stats)
                        }
                    }
                    //Guardamos los jugadores seleccionados en el sharedPreferences
                    editor.putStringSet("selectedPlayers",selectedPlayers.toSet())
                    editor.apply()

                    //Nos dirijimos al banquillo
                    val intent = Intent(this@MenuJugadores, Banquillo::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "No se encontró el partido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "NO HAS CONVOCADO LOS JUGADORES SUFICIENTES", Toast.LENGTH_SHORT).show()
            }
        }



    }
}