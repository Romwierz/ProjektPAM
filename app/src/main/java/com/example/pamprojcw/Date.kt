package com.example.pamprojcw

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

import java.time.LocalDateTime


class Date
    (var day: Int, var month:Any, var year:Int)

{

 init {
     val monthName = when (month) {
         is Int -> month
         is Month -> month
         else -> throw java.lang.IllegalArgumentException("Month must be a number 1-12 or name")
     }
 }







}