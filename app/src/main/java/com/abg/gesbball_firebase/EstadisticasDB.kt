package com.abg.gesbball_firebase

data class EstadisticasDB(
    val nombre:String? = null,
    val puntos:Int? = null,
    val tlibresA:Int? = null,
    val tlibresT:Int? = null,
    val faltas:Int? = null,
    val faltasT:Int? = null,
    val asistencias:Int? = null,
    val rebotesA:Int? = null,
    val rebotesD:Int? = null,
    val contraataque:Int? = null,
    val robos:Int? = null,
    val perdidas:Int? = null,
    val partido:String?=null,
    val fecha:String?=null
)
