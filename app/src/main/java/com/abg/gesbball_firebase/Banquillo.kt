package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abg.gesbball_firebase.EstadisticasDB
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Banquillo : AppCompatActivity() {
    private lateinit var db: DatabaseReference

    private lateinit var bt_volver:ImageButton
    private lateinit var bt_vpartido:Button
    private lateinit var bt_videoteca:Button

    private lateinit var ch1:CheckBox
    private lateinit var jg1:TextView
    private lateinit var pt1: TextView
    private lateinit var tla1:TextView
    private lateinit var tlt1:TextView
    private lateinit var fpn1:TextView
    private lateinit var fpt1:TextView
    private lateinit var as1:TextView
    private lateinit var rba1:TextView
    private lateinit var rbd1:TextView
    private lateinit var ptc1:TextView
    private lateinit var rob1:TextView
    private lateinit var pe1:TextView

    private lateinit var ch2:CheckBox
    private lateinit var jg2:TextView
    private lateinit var pt2: TextView
    private lateinit var tla2:TextView
    private lateinit var tlt2:TextView
    private lateinit var fpn2:TextView
    private lateinit var fpt2:TextView
    private lateinit var as2:TextView
    private lateinit var rba2:TextView
    private lateinit var rbd2:TextView
    private lateinit var ptc2:TextView
    private lateinit var rob2:TextView
    private lateinit var pe2:TextView

    private lateinit var ch3:CheckBox
    private lateinit var jg3:TextView
    private lateinit var pt3: TextView
    private lateinit var tla3:TextView
    private lateinit var tlt3:TextView
    private lateinit var fpn3:TextView
    private lateinit var fpt3:TextView
    private lateinit var as3:TextView
    private lateinit var rba3:TextView
    private lateinit var rbd3:TextView
    private lateinit var ptc3:TextView
    private lateinit var rob3:TextView
    private lateinit var pe3:TextView

    private lateinit var ch4:CheckBox
    private lateinit var jg4:TextView
    private lateinit var pt4: TextView
    private lateinit var tla4:TextView
    private lateinit var tlt4:TextView
    private lateinit var fpn4:TextView
    private lateinit var fpt4:TextView
    private lateinit var as4:TextView
    private lateinit var rba4:TextView
    private lateinit var rbd4:TextView
    private lateinit var ptc4:TextView
    private lateinit var rob4:TextView
    private lateinit var pe4:TextView

    private lateinit var ch5:CheckBox
    private lateinit var jg5:TextView
    private lateinit var pt5: TextView
    private lateinit var tla5:TextView
    private lateinit var tlt5:TextView
    private lateinit var fpn5:TextView
    private lateinit var fpt5:TextView
    private lateinit var as5:TextView
    private lateinit var rba5:TextView
    private lateinit var rbd5:TextView
    private lateinit var ptc5:TextView
    private lateinit var rob5:TextView
    private lateinit var pe5:TextView

    private lateinit var ch6:CheckBox
    private lateinit var jg6:TextView
    private lateinit var pt6: TextView
    private lateinit var tla6:TextView
    private lateinit var tlt6:TextView
    private lateinit var fpn6:TextView
    private lateinit var fpt6:TextView
    private lateinit var as6:TextView
    private lateinit var rba6:TextView
    private lateinit var rbd6:TextView
    private lateinit var ptc6:TextView
    private lateinit var rob6:TextView
    private lateinit var pe6:TextView

    private lateinit var ch7:CheckBox
    private lateinit var jg7:TextView
    private lateinit var pt7: TextView
    private lateinit var tla7:TextView
    private lateinit var tlt7:TextView
    private lateinit var fpn7:TextView
    private lateinit var fpt7:TextView
    private lateinit var as7:TextView
    private lateinit var rba7:TextView
    private lateinit var rbd7:TextView
    private lateinit var ptc7:TextView
    private lateinit var rob7:TextView
    private lateinit var pe7:TextView

    private lateinit var ch8:CheckBox
    private lateinit var jg8:TextView
    private lateinit var pt8: TextView
    private lateinit var tla8:TextView
    private lateinit var tlt8:TextView
    private lateinit var fpn8:TextView
    private lateinit var fpt8:TextView
    private lateinit var as8:TextView
    private lateinit var rba8:TextView
    private lateinit var rbd8:TextView
    private lateinit var ptc8:TextView
    private lateinit var rob8:TextView
    private lateinit var pe8:TextView

    private lateinit var ch9:CheckBox
    private lateinit var jg9:TextView
    private lateinit var pt9: TextView
    private lateinit var tla9:TextView
    private lateinit var tlt9:TextView
    private lateinit var fpn9:TextView
    private lateinit var fpt9:TextView
    private lateinit var as9:TextView
    private lateinit var rba9:TextView
    private lateinit var rbd9:TextView
    private lateinit var ptc9:TextView
    private lateinit var rob9:TextView
    private lateinit var pe9:TextView

    private lateinit var ch10:CheckBox
    private lateinit var jg10:TextView
    private lateinit var pt10: TextView
    private lateinit var tla10:TextView
    private lateinit var tlt10:TextView
    private lateinit var fpn10:TextView
    private lateinit var fpt10:TextView
    private lateinit var as10:TextView
    private lateinit var rba10:TextView
    private lateinit var rbd10:TextView
    private lateinit var ptc10:TextView
    private lateinit var rob10:TextView
    private lateinit var pe10:TextView

    private lateinit var ch11:CheckBox
    private lateinit var jg11:TextView
    private lateinit var pt11: TextView
    private lateinit var tla11:TextView
    private lateinit var tlt11:TextView
    private lateinit var fpn11:TextView
    private lateinit var fpt11:TextView
    private lateinit var as11:TextView
    private lateinit var rba11:TextView
    private lateinit var rbd11:TextView
    private lateinit var ptc11:TextView
    private lateinit var rob11:TextView
    private lateinit var pe11:TextView

    private lateinit var ch12:CheckBox
    private lateinit var jg12:TextView
    private lateinit var pt12: TextView
    private lateinit var tla12:TextView
    private lateinit var tlt12:TextView
    private lateinit var fpn12:TextView
    private lateinit var fpt12:TextView
    private lateinit var as12:TextView
    private lateinit var rba12:TextView
    private lateinit var rbd12:TextView
    private lateinit var ptc12:TextView
    private lateinit var rob12:TextView
    private lateinit var pe12:TextView

    private var jugadoresP = 0
    private var jugadores = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.banquillo)

        ch1=findViewById(R.id.CH1)
        jg1=findViewById(R.id.JG1)
        pt1=findViewById(R.id.PT1)
        tla1 = findViewById(R.id.TLA1)
        tlt1 = findViewById(R.id.TLT1)
        fpn1 = findViewById(R.id.FPN1)
        fpt1 = findViewById(R.id.FPT1)
        as1 = findViewById(R.id.AS1)
        rba1 = findViewById(R.id.RBA1)
        rbd1 = findViewById(R.id.RBD1)
        ptc1 = findViewById(R.id.PTC1)
        rob1 = findViewById(R.id.ROB1)
        pe1 = findViewById(R.id.PE1)

        ch2=findViewById(R.id.CH2)
        jg2=findViewById(R.id.JG2)
        pt2 = findViewById(R.id.PT2)
        tla2 = findViewById(R.id.TLA2)
        tlt2 = findViewById(R.id.TLT2)
        fpn2 = findViewById(R.id.FPN2)
        fpt2 = findViewById(R.id.FPT2)
        as2 = findViewById(R.id.AS2)
        rba2 = findViewById(R.id.RBA2)
        rbd2 = findViewById(R.id.RBD2)
        ptc2 = findViewById(R.id.PTC2)
        rob2 = findViewById(R.id.ROB2)
        pe2 = findViewById(R.id.PE2)

        ch3=findViewById(R.id.CH3)
        jg3=findViewById(R.id.JG3)
        pt3 = findViewById(R.id.PT3)
        tla3 = findViewById(R.id.TLA3)
        tlt3 = findViewById(R.id.TLT3)
        fpn3 = findViewById(R.id.FPN3)
        fpt3 = findViewById(R.id.FPT3)
        as3 = findViewById(R.id.AS3)
        rba3 = findViewById(R.id.RBA3)
        rbd3 = findViewById(R.id.RBD3)
        ptc3 = findViewById(R.id.PTC3)
        rob3 = findViewById(R.id.ROB3)
        pe3 = findViewById(R.id.PE3)

        ch4 = findViewById(R.id.CH4)
        jg4 = findViewById(R.id.JG4)
        pt4 = findViewById(R.id.PT4)
        tla4 = findViewById(R.id.TLA4)
        tlt4 = findViewById(R.id.TLT4)
        fpn4 = findViewById(R.id.FPN4)
        fpt4 = findViewById(R.id.FPT4)
        as4 = findViewById(R.id.AS4)
        rba4 = findViewById(R.id.RBA4)
        rbd4 = findViewById(R.id.RBD4)
        ptc4 = findViewById(R.id.PTC4)
        rob4 = findViewById(R.id.ROB4)
        pe4 = findViewById(R.id.PE4)

        ch5 = findViewById(R.id.CH5)
        jg5 = findViewById(R.id.JG5)
        pt5 = findViewById(R.id.PT5)
        tla5 = findViewById(R.id.TLA5)
        tlt5 = findViewById(R.id.TLT5)
        fpn5 = findViewById(R.id.FPN5)
        fpt5 = findViewById(R.id.FPT5)
        as5 = findViewById(R.id.AS5)
        rba5 = findViewById(R.id.RBA5)
        rbd5 = findViewById(R.id.RBD5)
        ptc5 = findViewById(R.id.PTC5)
        rob5 = findViewById(R.id.ROB5)
        pe5 = findViewById(R.id.PE5)

        ch6 = findViewById(R.id.CH6)
        jg6 = findViewById(R.id.JG6)
        pt6 = findViewById(R.id.PT6)
        tla6 = findViewById(R.id.TLA6)
        tlt6 = findViewById(R.id.TLT6)
        fpn6 = findViewById(R.id.FPN6)
        fpt6 = findViewById(R.id.FPT6)
        as6 = findViewById(R.id.AS6)
        rba6 = findViewById(R.id.RBA6)
        rbd6 = findViewById(R.id.RBD6)
        ptc6 = findViewById(R.id.PTC6)
        rob6 = findViewById(R.id.ROB6)
        pe6 = findViewById(R.id.PE6)

        ch7 = findViewById(R.id.CH7)
        jg7 = findViewById(R.id.JG7)
        pt7 = findViewById(R.id.PT7)
        tla7 = findViewById(R.id.TLA7)
        tlt7 = findViewById(R.id.TLT7)
        fpn7 = findViewById(R.id.FPN7)
        fpt7 = findViewById(R.id.FPT7)
        as7 = findViewById(R.id.AS7)
        rba7 = findViewById(R.id.RBA7)
        rbd7 = findViewById(R.id.RBD7)
        ptc7 = findViewById(R.id.PTC7)
        rob7 = findViewById(R.id.ROB7)
        pe7 = findViewById(R.id.PE7)

        ch8 = findViewById(R.id.CH8)
        jg8 = findViewById(R.id.JG8)
        pt8 = findViewById(R.id.PT8)
        tla8 = findViewById(R.id.TLA8)
        tlt8 = findViewById(R.id.TLT8)
        fpn8 = findViewById(R.id.FPN8)
        fpt8 = findViewById(R.id.FPT8)
        as8 = findViewById(R.id.AS8)
        rba8 = findViewById(R.id.RBA8)
        rbd8 = findViewById(R.id.RBD8)
        ptc8 = findViewById(R.id.PTC8)
        rob8 = findViewById(R.id.ROB8)
        pe8 = findViewById(R.id.PE8)

        ch9 = findViewById(R.id.CH9)
        jg9 = findViewById(R.id.JG9)
        pt9 = findViewById(R.id.PT9)
        tla9 = findViewById(R.id.TLA9)
        tlt9 = findViewById(R.id.TLT9)
        fpn9 = findViewById(R.id.FPN9)
        fpt9 = findViewById(R.id.FPT9)
        as9 = findViewById(R.id.AS9)
        rba9 = findViewById(R.id.RBA9)
        rbd9 = findViewById(R.id.RBD9)
        ptc9 = findViewById(R.id.PTC9)
        rob9 = findViewById(R.id.ROB9)
        pe9 = findViewById(R.id.PE9)

        ch10 = findViewById(R.id.CH10)
        jg10 = findViewById(R.id.JG10)
        pt10 = findViewById(R.id.PT10)
        tla10 = findViewById(R.id.TLA10)
        tlt10 = findViewById(R.id.TLT10)
        fpn10 = findViewById(R.id.FPN10)
        fpt10 = findViewById(R.id.FPT10)
        as10 = findViewById(R.id.AS10)
        rba10 = findViewById(R.id.RBA10)
        rbd10 = findViewById(R.id.RBD10)
        ptc10 = findViewById(R.id.PTC10)
        rob10 = findViewById(R.id.ROB10)
        pe10 = findViewById(R.id.PE10)

        ch11 = findViewById(R.id.CH11)
        jg11 = findViewById(R.id.JG11)
        pt11 = findViewById(R.id.PT11)
        tla11 = findViewById(R.id.TLA11)
        tlt11 = findViewById(R.id.TLT11)
        fpn11 = findViewById(R.id.FPN11)
        fpt11 = findViewById(R.id.FPT11)
        as11 = findViewById(R.id.AS11)
        rba11 = findViewById(R.id.RBA11)
        rbd11 = findViewById(R.id.RBD11)
        ptc11 = findViewById(R.id.PTC11)
        rob11 = findViewById(R.id.ROB11)
        pe11 = findViewById(R.id.PE11)

        ch12 = findViewById(R.id.CH12)
        jg12 = findViewById(R.id.JG12)
        pt12 = findViewById(R.id.PT12)
        tla12 = findViewById(R.id.TLA12)
        tlt12 = findViewById(R.id.TLT12)
        fpn12 = findViewById(R.id.FPN12)
        fpt12 = findViewById(R.id.FPT12)
        as12 = findViewById(R.id.AS12)
        rba12 = findViewById(R.id.RBA12)
        rbd12 = findViewById(R.id.RBD12)
        ptc12 = findViewById(R.id.PTC12)
        rob12 = findViewById(R.id.ROB12)
        pe12 = findViewById(R.id.PE12)

        db = FirebaseDatabase.getInstance().getReference("Estadisticas")
        bt_volver = findViewById(R.id.BT_VOLVER)
        bt_vpartido = findViewById(R.id.BT_VPARTIDO)
        bt_videoteca = findViewById(R.id.BT_VIDEOTECA)
        fetchData()

        //Seleccionamos el jugador que saldrá a pista ya umentamos el contador, una vez se llegue a
        // 5 deshabilitamos el resto de jugadores
        ch1.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked1: Boolean ->
            if (isChecked1) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch2.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked2: Boolean ->
            if (isChecked2) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false

                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true

                }
            }
        }

        ch3.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked3: Boolean ->
            if (isChecked3) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch4.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked4: Boolean ->
            if (isChecked4) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch5.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked5: Boolean ->
            if (isChecked5) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch6.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked6: Boolean ->
            if (isChecked6) {
                jugadoresP += 1
                if (jugadoresP == 5 ) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch7.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked7: Boolean ->
            if (isChecked7) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch8.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked8: Boolean ->
            if (isChecked8) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch9.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked9: Boolean ->
            if (isChecked9) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch10.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked10: Boolean ->
            if (isChecked10) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch11.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch11.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch11.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked11: Boolean ->
            if (isChecked11) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch12.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch12.isEnabled = true
                }
            }
        }

        ch12.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked12: Boolean ->
            if (isChecked12) {
                jugadoresP += 1
                if (jugadoresP == 5) {
                    ch1.isEnabled = false
                    ch2.isEnabled = false
                    ch3.isEnabled = false
                    ch4.isEnabled = false
                    ch5.isEnabled = false
                    ch6.isEnabled = false
                    ch7.isEnabled = false
                    ch8.isEnabled = false
                    ch9.isEnabled = false
                    ch10.isEnabled = false
                    ch11.isEnabled = false
                }
            } else {
                jugadoresP -= 1
                if (jugadoresP != 5) {
                    ch1.isEnabled = true
                    ch2.isEnabled = true
                    ch3.isEnabled = true
                    ch4.isEnabled = true
                    ch5.isEnabled = true
                    ch6.isEnabled = true
                    ch7.isEnabled = true
                    ch8.isEnabled = true
                    ch9.isEnabled = true
                    ch10.isEnabled = true
                    ch11.isEnabled = true
                }
            }
        }

        bt_vpartido.setOnClickListener {
            //Si los jugadores seleccionados fueran 5 vamos a la pantalla de Partido
            if (jugadoresP >= 5) {
                val sharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val partidoG = sharedPreferences.getString("partido", "")

                //Juntamos los jugadores con su checkbox para saver cual están seleccionados
                if (partidoG != null) {
                    val jugadoresListP = listOf(
                        Pair(jg1, ch1), Pair(jg2, ch2), Pair(jg3, ch3),
                        Pair(jg4, ch4), Pair(jg5, ch5), Pair(jg6, ch6),
                        Pair(jg7, ch7), Pair(jg8, ch8), Pair(jg9, ch9),
                        Pair(jg10, ch10), Pair(jg11, ch11), Pair(jg12, ch12)
                    )

                    val selectedPlayersP = mutableListOf<String>()

                    //Recorremos la lista de jugadores marcados
                    jugadoresListP.forEach { (jugadorPTextView, jugadorPCheckBox) ->
                        //Si el checkbox esta seleccionado creamos sus estadísticas en caso de que no se hubieran creado
                        if (jugadorPCheckBox.isChecked) {
                            val fecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                            val jugadorNombre = jugadorPTextView.text.toString()
                            val playerKey = "$jugadorNombre $partidoG $fecha"

                            db.child(playerKey).get().addOnSuccessListener { snapshot ->
                                //Recorremos que el jugador exista para tratar las estadísticas
                                if (snapshot.exists()) {
                                    val existingStats = snapshot.getValue(EstadisticasDB::class.java)
                                    if (existingStats != null) {
                                        val updatedStats = existingStats.copy(
                                            fecha = fecha,
                                        )
                                        db.child(playerKey).setValue(updatedStats)
                                    }
                                } else {
                                    val newStats = EstadisticasDB(
                                        nombre = jugadorNombre,
                                        puntos = 0,
                                        tlibresA = 0,
                                        tlibresT = 0,
                                        faltas = 0,
                                        faltasT = 0,
                                        asistencias = 0,
                                        rebotesA = 0,
                                        rebotesD = 0,
                                        contraataque = 0,
                                        robos = 0,
                                        perdidas = 0,
                                        partido = partidoG,
                                        fecha = fecha
                                    )
                                    db.child(playerKey).setValue(newStats)
                                }
                            }

                            selectedPlayersP.add(jugadorNombre)
                        }
                    }
                    editor.putStringSet("selectedPlayersP", selectedPlayersP.toSet())
                    editor.apply()

                    val intent = Intent(this@Banquillo, Partido::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "No se encontró el partido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "NO HAS CONVOCADO LOS JUGADORES SUFICIENTES", Toast.LENGTH_SHORT).show()
            }
        }

        //Nos dirigimos a videoteca
        bt_videoteca.setOnClickListener {
            val banvid = "videoteca"
            val sharedPreferences2: SharedPreferences = getSharedPreferences("Pagina", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences2.edit()
            editor.putString("pagina",banvid)
            editor.apply()
            val intent = Intent(this, Videoteca::class.java)
            startActivity(intent)
        }

        //volvemos a la pestaña anterior MenuJugadores
        bt_volver.setOnClickListener {
            val intent = Intent(this, MenuJugadores::class.java)
            startActivity(intent)
        }

    }

    //Recogemos los datos para mostrarlos en el banquillo
    private fun fetchData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
        val partidoGuardado = sharedPreferences.getString("partido", "") ?: ""
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val selectedPlayers = mutableListOf<EstadisticasDB>()

                //Recorremos la lista de jugadores
                for (jugadorSnap in snapshot.children) {
                    val part=jugadorSnap.key
                    //Si el partido existe y el nodo contiene su nombre se muestra el jugador
                    if(part != null && part.contains(partidoGuardado)){
                        val jugador = jugadorSnap.getValue(EstadisticasDB::class.java)
                        jugador?.let {
                            selectedPlayers.add(it)
                        }
                    }
                }

                val playersToShow = selectedPlayers.take(12)
                //Asigmanos el index a cada jugador
                playersToShow.forEachIndexed{ index,player ->
                    when(index){
                        0 -> assignPlayerDataToViews(player, 1)
                        1 -> assignPlayerDataToViews(player, 2)
                        2 -> assignPlayerDataToViews(player, 3)
                        3 -> assignPlayerDataToViews(player, 4)
                        4 -> assignPlayerDataToViews(player, 5)
                        5 -> assignPlayerDataToViews(player, 6)
                        6 -> assignPlayerDataToViews(player, 7)
                        7 -> assignPlayerDataToViews(player, 8)
                        8 -> assignPlayerDataToViews(player, 9)
                        9 -> assignPlayerDataToViews(player, 10)
                        10 -> assignPlayerDataToViews(player, 11)
                        11 -> assignPlayerDataToViews(player, 12)
                    }
                    //Si se hubieran seleccionado solo 10 jugadores se muestran esos 10 para no
                    // tener datos vacíos
                    ch1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    jg1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    pt1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    tla1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    tlt1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    fpn1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    fpt1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    as1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    rba1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    rbd1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    ptc1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    rob1.visibility = if (index >= 0) View.VISIBLE else View.GONE
                    pe1.visibility = if (index >= 0) View.VISIBLE else View.GONE

                    ch2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    jg2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    pt2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    tla2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    tlt2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    fpn2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    fpt2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    as2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    rba2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    rbd2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    ptc2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    rob2.visibility = if (index >= 1) View.VISIBLE else View.GONE
                    pe2.visibility = if (index >= 1) View.VISIBLE else View.GONE

                    ch3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    jg3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    pt3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    tla3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    tlt3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    fpn3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    fpt3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    as3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    rba3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    rbd3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    ptc3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    rob3.visibility = if (index >= 2) View.VISIBLE else View.GONE
                    pe3.visibility = if (index >= 2) View.VISIBLE else View.GONE

                    ch4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    jg4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    pt4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    tla4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    tlt4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    fpn4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    fpt4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    as4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    rba4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    rbd4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    ptc4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    rob4.visibility = if (index >= 3) View.VISIBLE else View.GONE
                    pe4.visibility = if (index >= 3) View.VISIBLE else View.GONE

                    ch5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    jg5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    pt5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    tla5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    tlt5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    fpn5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    fpt5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    as5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    rba5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    rbd5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    ptc5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    rob5.visibility = if (index >= 4) View.VISIBLE else View.GONE
                    pe5.visibility = if (index >= 4) View.VISIBLE else View.GONE

                    ch6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    jg6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    pt6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    tla6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    tlt6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    fpn6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    fpt6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    as6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    rba6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    rbd6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    ptc6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    rob6.visibility = if (index >= 5) View.VISIBLE else View.GONE
                    pe6.visibility = if (index >= 5) View.VISIBLE else View.GONE

                    ch7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    jg7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    pt7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    tla7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    tlt7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    fpn7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    fpt7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    as7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    rba7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    rbd7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    ptc7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    rob7.visibility = if (index >= 6) View.VISIBLE else View.GONE
                    pe7.visibility = if (index >= 6) View.VISIBLE else View.GONE

                    ch8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    jg8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    pt8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    tla8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    tlt8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    fpn8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    fpt8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    as8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    rba8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    rbd8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    ptc8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    rob8.visibility = if (index >= 7) View.VISIBLE else View.GONE
                    pe8.visibility = if (index >= 7) View.VISIBLE else View.GONE

                    ch9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    jg9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    pt9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    tla9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    tlt9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    fpn9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    fpt9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    as9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    rba9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    rbd9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    ptc9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    rob9.visibility = if (index >= 8) View.VISIBLE else View.GONE
                    pe9.visibility = if (index >= 8) View.VISIBLE else View.GONE

                    ch10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    jg10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    pt10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    tla10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    tlt10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    fpn10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    fpt10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    as10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    rba10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    rbd10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    ptc10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    rob10.visibility = if (index >= 9) View.VISIBLE else View.GONE
                    pe10.visibility = if (index >= 9) View.VISIBLE else View.GONE

                    ch11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    jg11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    pt11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    tla11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    tlt11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    fpn11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    fpt11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    as11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    rba11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    rbd11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    ptc11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    rob11.visibility = if (index >= 10) View.VISIBLE else View.GONE
                    pe11.visibility = if (index >= 10) View.VISIBLE else View.GONE

                    ch12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    jg12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    pt12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    tla12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    tlt12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    fpn12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    fpt12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    as12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    rba12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    rbd12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    ptc12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    rob12.visibility = if (index >= 11) View.VISIBLE else View.GONE
                    pe12.visibility = if (index >= 11) View.VISIBLE else View.GONE

                    //Hacemos cuentas con los jugadores que tenemos, si nos quedaran menos de 4
                    // jugadores disponibles se acaba el partido por normativa
                    val sharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
                    val cantidad = sharedPreferences.getInt("cantidad",0)
                    val disponibles = cantidad - jugadores
                    if(disponibles==4){
                        Toast.makeText(applicationContext, "No dispones de jugadores suficientes", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Banquillo, Menu::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    private fun assignPlayerDataToViews(jugador: EstadisticasDB, playerNumber: Int) {
        //Asignamos a cada jugador su index y comprobamos que puedan seguir jugando
        when (playerNumber) {
            1 -> {
                jg1.text = jugador.nombre
                pt1.text = jugador.puntos.toString()
                tla1.text = jugador.tlibresA.toString()
                tlt1.text = jugador.tlibresT.toString()
                fpn1.text = jugador.faltas.toString()
                fpt1.text = jugador.faltasT.toString()
                as1.text = jugador.asistencias.toString()
                rba1.text = jugador.rebotesA.toString()
                rbd1.text = jugador.rebotesD.toString()
                ptc1.text = jugador.contraataque.toString()
                rob1.text = jugador.robos.toString()
                pe1.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch1.isEnabled = false
                    jugadores+=1
                }
            }
            2 -> {
                jg2.text = jugador.nombre
                pt2.text = jugador.puntos.toString()
                tla2.text = jugador.tlibresA.toString()
                tlt2.text = jugador.tlibresT.toString()
                fpn2.text = jugador.faltas.toString()
                fpt2.text = jugador.faltasT.toString()
                as2.text = jugador.asistencias.toString()
                rba2.text = jugador.rebotesA.toString()
                rbd2.text = jugador.rebotesD.toString()
                ptc2.text = jugador.contraataque.toString()
                rob2.text = jugador.robos.toString()
                pe2.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch2.isEnabled = false
                    jugadores+=1
                }
            }
            3 -> {
                jg3.text = jugador.nombre
                pt3.text = jugador.puntos.toString()
                tla3.text = jugador.tlibresA.toString()
                tlt3.text = jugador.tlibresT.toString()
                fpn3.text = jugador.faltas.toString()
                fpt3.text = jugador.faltasT.toString()
                as3.text = jugador.asistencias.toString()
                rba3.text = jugador.rebotesA.toString()
                rbd3.text = jugador.rebotesD.toString()
                ptc3.text = jugador.contraataque.toString()
                rob3.text = jugador.robos.toString()
                pe3.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch3.isEnabled = false
                    jugadores+=1
                }
            }
            4 -> {
                jg4.text = jugador.nombre
                pt4.text = jugador.puntos.toString()
                tla4.text = jugador.tlibresA.toString()
                tlt4.text = jugador.tlibresT.toString()
                fpn4.text = jugador.faltas.toString()
                fpt4.text = jugador.faltasT.toString()
                as4.text = jugador.asistencias.toString()
                rba4.text = jugador.rebotesA.toString()
                rbd4.text = jugador.rebotesD.toString()
                ptc4.text = jugador.contraataque.toString()
                rob4.text = jugador.robos.toString()
                pe4.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch4.isEnabled = false
                    jugadores+=1
                }
            }
            5 -> {
                jg5.text = jugador.nombre
                pt5.text = jugador.puntos.toString()
                tla5.text = jugador.tlibresA.toString()
                tlt5.text = jugador.tlibresT.toString()
                fpn5.text = jugador.faltas.toString()
                fpt5.text = jugador.faltasT.toString()
                as5.text = jugador.asistencias.toString()
                rba5.text = jugador.rebotesA.toString()
                rbd5.text = jugador.rebotesD.toString()
                ptc5.text = jugador.contraataque.toString()
                rob5.text = jugador.robos.toString()
                pe5.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch5.isEnabled = false
                    jugadores+=1
                }
            }
            6 -> {
                jg6.text = jugador.nombre
                pt6.text = jugador.puntos.toString()
                tla6.text = jugador.tlibresA.toString()
                tlt6.text = jugador.tlibresT.toString()
                fpn6.text = jugador.faltas.toString()
                fpt6.text = jugador.faltasT.toString()
                as6.text = jugador.asistencias.toString()
                rba6.text = jugador.rebotesA.toString()
                rbd6.text = jugador.rebotesD.toString()
                ptc6.text = jugador.contraataque.toString()
                rob6.text = jugador.robos.toString()
                pe6.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch6.isEnabled = false
                    jugadores+=1
                }
            }
            7 -> {
                jg7.text = jugador.nombre
                pt7.text = jugador.puntos.toString()
                tla7.text = jugador.tlibresA.toString()
                tlt7.text = jugador.tlibresT.toString()
                fpn7.text = jugador.faltas.toString()
                fpt7.text = jugador.faltasT.toString()
                as7.text = jugador.asistencias.toString()
                rba7.text = jugador.rebotesA.toString()
                rbd7.text = jugador.rebotesD.toString()
                ptc7.text = jugador.contraataque.toString()
                rob7.text = jugador.robos.toString()
                pe7.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch7.isEnabled = false
                    jugadores+=1
                }
            }
            8 -> {
                jg8.text = jugador.nombre
                pt8.text = jugador.puntos.toString()
                tla8.text = jugador.tlibresA.toString()
                tlt8.text = jugador.tlibresT.toString()
                fpn8.text = jugador.faltas.toString()
                fpt8.text = jugador.faltasT.toString()
                as8.text = jugador.asistencias.toString()
                rba8.text = jugador.rebotesA.toString()
                rbd8.text = jugador.rebotesD.toString()
                ptc8.text = jugador.contraataque.toString()
                rob8.text = jugador.robos.toString()
                pe8.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch8.isEnabled = false
                    jugadores+=1
                }
            }
            9 -> {
                jg9.text = jugador.nombre
                pt9.text = jugador.puntos.toString()
                tla9.text = jugador.tlibresA.toString()
                tlt9.text = jugador.tlibresT.toString()
                fpn9.text = jugador.faltas.toString()
                fpt9.text = jugador.faltasT.toString()
                as9.text = jugador.asistencias.toString()
                rba9.text = jugador.rebotesA.toString()
                rbd9.text = jugador.rebotesD.toString()
                ptc9.text = jugador.contraataque.toString()
                rob9.text = jugador.robos.toString()
                pe9.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch9.isEnabled = false
                    jugadores+=1
                }
            }
            10 -> {
                jg10.text = jugador.nombre
                pt10.text = jugador.puntos.toString()
                tla10.text = jugador.tlibresA.toString()
                tlt10.text = jugador.tlibresT.toString()
                fpn10.text = jugador.faltas.toString()
                fpt10.text = jugador.faltasT.toString()
                as10.text = jugador.asistencias.toString()
                rba10.text = jugador.rebotesA.toString()
                rbd10.text = jugador.rebotesD.toString()
                ptc10.text = jugador.contraataque.toString()
                rob10.text = jugador.robos.toString()
                pe10.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch10.isEnabled = false
                    jugadores+=1
                }
            }
            11 -> {
                jg11.text = jugador.nombre
                pt11.text = jugador.puntos.toString()
                tla11.text = jugador.tlibresA.toString()
                tlt11.text = jugador.tlibresT.toString()
                fpn11.text = jugador.faltas.toString()
                fpt11.text = jugador.faltasT.toString()
                as11.text = jugador.asistencias.toString()
                rba11.text = jugador.rebotesA.toString()
                rbd11.text = jugador.rebotesD.toString()
                ptc11.text = jugador.contraataque.toString()
                rob11.text = jugador.robos.toString()
                pe11.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch11.isEnabled = false
                    jugadores+=1
                }
            }
            12 -> {
                jg12.text = jugador.nombre
                pt12.text = jugador.puntos.toString()
                tla12.text = jugador.tlibresA.toString()
                tlt12.text = jugador.tlibresT.toString()
                fpn12.text = jugador.faltas.toString()
                fpt12.text = jugador.faltasT.toString()
                as12.text = jugador.asistencias.toString()
                rba12.text = jugador.rebotesA.toString()
                rbd12.text = jugador.rebotesD.toString()
                ptc12.text = jugador.contraataque.toString()
                rob12.text = jugador.robos.toString()
                pe12.text = jugador.perdidas.toString()
                if(jugador.faltasT == 2 || jugador.faltas == 5){
                    ch12.isEnabled = false
                    jugadores+=1
                }
            }
        }
    }

}

