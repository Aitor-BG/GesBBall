package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
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

class MenuPartido: AppCompatActivity(){

    private lateinit var btconf:Button
    private lateinit var tveq1:TextView
    private lateinit var tveq2:TextView
    private lateinit var tveq3:TextView
    private lateinit var tveq4:TextView
    private lateinit var tveq5:TextView
    private lateinit var tveq6:TextView
    private lateinit var tveq7:TextView
    private lateinit var tveq8:TextView
    private lateinit var tveq9:TextView
    private lateinit var tveq10:TextView
    private lateinit var tveq11:TextView
    private lateinit var tveq12:TextView
    private lateinit var tveq13:TextView
    private lateinit var tveq14:TextView
    private lateinit var tveq15:TextView
    private lateinit var tveq16:TextView
    private lateinit var tveq17:TextView
    private lateinit var tveq18:TextView
    private lateinit var tveq19:TextView
    private lateinit var tveq20:TextView
    private lateinit var tveq21:TextView
    private lateinit var tveq22:TextView
    private lateinit var tveq23:TextView
    private lateinit var tveq24:TextView
    private lateinit var ch1:CheckBox
    private lateinit var ch2:CheckBox
    private lateinit var ch3:CheckBox
    private lateinit var ch4:CheckBox
    private lateinit var ch5:CheckBox
    private lateinit var ch6:CheckBox
    private lateinit var ch7:CheckBox
    private lateinit var ch8:CheckBox
    private lateinit var ch9:CheckBox
    private lateinit var ch10:CheckBox
    private lateinit var ch11:CheckBox
    private lateinit var ch12:CheckBox
    private lateinit var ch13:CheckBox
    private lateinit var ch14:CheckBox
    private lateinit var ch15:CheckBox
    private lateinit var ch16:CheckBox
    private lateinit var ch17:CheckBox
    private lateinit var ch18:CheckBox
    private lateinit var ch19:CheckBox
    private lateinit var ch20:CheckBox
    private lateinit var ch21:CheckBox
    private lateinit var ch22:CheckBox
    private lateinit var ch23:CheckBox
    private lateinit var ch24:CheckBox
    private lateinit var db: DatabaseReference
    private lateinit var volver:ImageButton
    private var local:String?=null
    private var visitante:String?=null
    private var maxid=0
    private var equipos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menupartido)

        db = FirebaseDatabase.getInstance().getReference("Partido")
        volver=findViewById(R.id.BT_VOLVER)
        btconf=findViewById(R.id.BT_CONF)
        tveq1=findViewById(R.id.TV_EQUIPO1)
        tveq2=findViewById(R.id.TV_EQUIPO2)
        tveq3=findViewById(R.id.TV_EQUIPO3)
        tveq4=findViewById(R.id.TV_EQUIPO4)
        tveq5=findViewById(R.id.TV_EQUIPO5)
        tveq6=findViewById(R.id.TV_EQUIPO6)
        tveq7=findViewById(R.id.TV_EQUIPO7)
        tveq8=findViewById(R.id.TV_EQUIPO8)
        tveq9=findViewById(R.id.TV_EQUIPO9)
        tveq10=findViewById(R.id.TV_EQUIPO10)
        tveq11=findViewById(R.id.TV_EQUIPO11)
        tveq12=findViewById(R.id.TV_EQUIPO12)
        tveq13=findViewById(R.id.TV_EQUIPO13)
        tveq14=findViewById(R.id.TV_EQUIPO14)
        tveq15=findViewById(R.id.TV_EQUIPO15)
        tveq16=findViewById(R.id.TV_EQUIPO16)
        tveq17=findViewById(R.id.TV_EQUIPO17)
        tveq18=findViewById(R.id.TV_EQUIPO18)
        tveq19=findViewById(R.id.TV_EQUIPO19)
        tveq20=findViewById(R.id.TV_EQUIPO20)
        tveq21=findViewById(R.id.TV_EQUIPO21)
        tveq22=findViewById(R.id.TV_EQUIPO22)
        tveq23=findViewById(R.id.TV_EQUIPO23)
        tveq24=findViewById(R.id.TV_EQUIPO24)
        ch1=findViewById(R.id.CH_EQUIPO1)
        ch2=findViewById(R.id.CH_EQUIPO2)
        ch3=findViewById(R.id.CH_EQUIPO3)
        ch4=findViewById(R.id.CH_EQUIPO4)
        ch5=findViewById(R.id.CH_EQUIPO5)
        ch6=findViewById(R.id.CH_EQUIPO6)
        ch7=findViewById(R.id.CH_EQUIPO7)
        ch8=findViewById(R.id.CH_EQUIPO8)
        ch9=findViewById(R.id.CH_EQUIPO9)
        ch10=findViewById(R.id.CH_EQUIPO10)
        ch11=findViewById(R.id.CH_EQUIPO11)
        ch12=findViewById(R.id.CH_EQUIPO12)
        ch13=findViewById(R.id.CH_EQUIPO13)
        ch14=findViewById(R.id.CH_EQUIPO14)
        ch15=findViewById(R.id.CH_EQUIPO15)
        ch16=findViewById(R.id.CH_EQUIPO16)
        ch17=findViewById(R.id.CH_EQUIPO17)
        ch18=findViewById(R.id.CH_EQUIPO18)
        ch19=findViewById(R.id.CH_EQUIPO19)
        ch20=findViewById(R.id.CH_EQUIPO20)
        ch21=findViewById(R.id.CH_EQUIPO21)
        ch22=findViewById(R.id.CH_EQUIPO22)
        ch23=findViewById(R.id.CH_EQUIPO23)
        ch24=findViewById(R.id.CH_EQUIPO24)

        //Volvemos a la pantalla anterior -> Menu
        volver.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        //Seleccionamos el equipo y deshabilitamos su columna (1-12 Local), (13-24 Visitante)
        ch1.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked1: Boolean ->
            if (isChecked1) {
                equipos+=1
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
                ch13.isEnabled = false
                local = tveq1.text.toString()
            }else{
                equipos-=1
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
                ch13.isEnabled = true
            }
        }
        ch2.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked2: Boolean ->
            if (isChecked2) {
                equipos+=1
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
                ch14.isEnabled = false
                local = tveq2.text.toString()
            }else{
                equipos-=1
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
                ch14.isEnabled = true
            }
        }
        ch3.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked3: Boolean ->
            if (isChecked3) {
                equipos+=1
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
                ch15.isEnabled = false
                local = tveq3.text.toString()
            }else{
                equipos-=1
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
                ch15.isEnabled = true
            }
        }
        ch4.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked4: Boolean ->
            if (isChecked4) {
                equipos+=1
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
                ch16.isEnabled = false
                local = tveq4.text.toString()
            }else{
                equipos-=1
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
                ch16.isEnabled = true
            }
        }
        ch5.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked5: Boolean ->
            if (isChecked5) {
                equipos+=1
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
                ch17.isEnabled = false
                local = tveq5.text.toString()
            }else{
                equipos-=1
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
                ch17.isEnabled = true
            }
        }
        ch6.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked6: Boolean ->
            if (isChecked6) {
                equipos+=1
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
                ch18.isEnabled = false
                local = tveq6.text.toString()
            }else{
                equipos-=1
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
                ch18.isEnabled = true
            }
        }
        ch7.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked7: Boolean ->
            if (isChecked7) {
                equipos+=1
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
                ch19.isEnabled = false
                local = tveq7.text.toString()
            }else{
                equipos-=1
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
                ch19.isEnabled = true
            }
        }
        ch8.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked8: Boolean ->
            if (isChecked8) {
                equipos+=1
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
                ch20.isEnabled = false
                local = tveq8.text.toString()
            }else{
                equipos-=1
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
                ch20.isEnabled = true
            }
        }
        ch9.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked9: Boolean ->
            if (isChecked9) {
                equipos+=1
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
                ch21.isEnabled = false
                local = tveq9.text.toString()
            }else{
                equipos-=1
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
                ch21.isEnabled = true
            }
        }
        ch10.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked10: Boolean ->
            if (isChecked10) {
                equipos+=1
                ch2.isEnabled = false
                ch3.isEnabled = false
                ch4.isEnabled = false
                ch5.isEnabled = false
                ch6.isEnabled = false
                ch7.isEnabled = false
                ch8.isEnabled = false
                ch9.isEnabled = false
                ch1.isEnabled = false
                ch11.isEnabled = false
                ch12.isEnabled = false
                ch22.isEnabled = false
                local = tveq10.text.toString()
            }else{
                equipos-=1
                ch2.isEnabled = true
                ch3.isEnabled = true
                ch4.isEnabled = true
                ch5.isEnabled = true
                ch6.isEnabled = true
                ch7.isEnabled = true
                ch8.isEnabled = true
                ch9.isEnabled = true
                ch1.isEnabled = true
                ch11.isEnabled = true
                ch12.isEnabled = true
                ch22.isEnabled = true
            }
        }
        ch11.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked11: Boolean ->
            if (isChecked11) {
                equipos+=1
                ch2.isEnabled = false
                ch3.isEnabled = false
                ch4.isEnabled = false
                ch5.isEnabled = false
                ch6.isEnabled = false
                ch7.isEnabled = false
                ch8.isEnabled = false
                ch9.isEnabled = false
                ch10.isEnabled = false
                ch1.isEnabled = false
                ch12.isEnabled = false
                ch23.isEnabled = false
                local = tveq11.text.toString()
            }else{
                equipos-=1
                ch2.isEnabled = true
                ch3.isEnabled = true
                ch4.isEnabled = true
                ch5.isEnabled = true
                ch6.isEnabled = true
                ch7.isEnabled = true
                ch8.isEnabled = true
                ch9.isEnabled = true
                ch10.isEnabled = true
                ch1.isEnabled = true
                ch12.isEnabled = true
                ch23.isEnabled = true
            }
        }
        ch12.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked12: Boolean ->
            if (isChecked12) {
                equipos+=1
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
                ch1.isEnabled = false
                ch24.isEnabled = false
                local = tveq12.text.toString()
            }else{
                equipos-=1
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
                ch1.isEnabled = true
                ch24.isEnabled = true
            }
        }

        ch13.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked13: Boolean ->
            if (isChecked13) {
                equipos+=1
                ch24.isEnabled = false
                ch1.isEnabled = false
                ch14.isEnabled = false
                ch15.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                visitante = tveq13.text.toString()
            }else{
                equipos-=1
                ch24.isEnabled = true
                ch1.isEnabled = true
                ch14.isEnabled = true
                ch15.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
            }
        }
        ch14.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked14: Boolean ->
            if (isChecked14) {
                equipos+=1
                ch13.isEnabled = false
                ch15.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch2.isEnabled = false
                visitante = tveq14.text.toString()
            }else{
                equipos-=1
                ch15.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch2.isEnabled = true
            }
        }
        ch15.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked15: Boolean ->
            if (isChecked15) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch3.isEnabled = false
                visitante = tveq15.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch3.isEnabled = true
            }
        }
        ch16.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked16: Boolean ->
            if (isChecked16) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch15.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch4.isEnabled = false
                visitante = tveq16.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch15.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch4.isEnabled = true
            }
        }
        ch17.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked17: Boolean ->
            if (isChecked17) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch15.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch5.isEnabled = false
                visitante = tveq17.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch15.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch5.isEnabled = true
            }
        }
        ch18.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked18: Boolean ->
            if (isChecked18) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch15.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch6.isEnabled = false
                visitante = tveq18.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch15.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch6.isEnabled = true
            }
        }
        ch19.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked19: Boolean ->
            if (isChecked19) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch15.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch7.isEnabled = false
                visitante = tveq19.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch15.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch7.isEnabled = true
            }
        }
        ch20.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked20: Boolean ->
            if (isChecked20) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch15.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch8.isEnabled = false
                visitante = tveq20.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch15.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch8.isEnabled = true
            }
        }
        ch21.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked21: Boolean ->
            if (isChecked21) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch15.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch9.isEnabled = false
                visitante = tveq21.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch15.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch9.isEnabled = true
            }
        }
        ch22.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked22: Boolean ->
            if (isChecked22) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch15.isEnabled = false
                ch23.isEnabled = false
                ch24.isEnabled = false
                ch10.isEnabled = false
                visitante = tveq22.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch15.isEnabled = true
                ch23.isEnabled = true
                ch24.isEnabled = true
                ch10.isEnabled = true
            }
        }
        ch23.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked23: Boolean ->
            if (isChecked23) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch15.isEnabled = false
                ch24.isEnabled = false
                ch11.isEnabled = false
                visitante = tveq23.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch15.isEnabled = true
                ch24.isEnabled = true
                ch11.isEnabled = true
            }
        }
        ch24.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked24: Boolean ->
            if (isChecked24) {
                equipos+=1
                ch13.isEnabled = false
                ch14.isEnabled = false
                ch16.isEnabled = false
                ch17.isEnabled = false
                ch18.isEnabled = false
                ch19.isEnabled = false
                ch20.isEnabled = false
                ch21.isEnabled = false
                ch22.isEnabled = false
                ch23.isEnabled = false
                ch15.isEnabled = false
                ch12.isEnabled = false
                visitante = tveq24.text.toString()
            }else{
                equipos-=1
                ch13.isEnabled = true
                ch14.isEnabled = true
                ch16.isEnabled = true
                ch17.isEnabled = true
                ch18.isEnabled = true
                ch19.isEnabled = true
                ch20.isEnabled = true
                ch21.isEnabled = true
                ch22.isEnabled = true
                ch23.isEnabled = true
                ch15.isEnabled = true
                ch12.isEnabled = true
            }
        }


        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    maxid=(snapshot.getChildrenCount().toInt())
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        btconf.setOnClickListener {
            //Si hubiera dos equipos marcados se crea su registro, sino se pide introducir equipos
            if (equipos!=2) {
                Toast.makeText(applicationContext, "FALTAN EQUIPOS", Toast.LENGTH_SHORT).show()
            } else {
                val marcL = 0
                val marcV = 0
                val clave = (maxid + 1).toString()
                val datos = PartidoDB(local, visitante, marcL, marcV)
                val partidoG = "$local - $visitante"

                val sharedPreferences: SharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("partido", partidoG)
                editor.putString("local", local)
                editor.putString("visitante", visitante)
                editor.putString("clave", clave)
                editor.apply()

                db.child(clave).setValue(datos)
                Toast.makeText(applicationContext, "PARTIDO CREADO", Toast.LENGTH_SHORT).show()

                // Se redirige a la pestaña MenuJugadores
                val intent = Intent(this@MenuPartido, MenuJugadores::class.java)
                startActivity(intent)
            }
        }


    }
}