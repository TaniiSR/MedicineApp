package com.task.medicineapp.utils

import java.util.Calendar
import java.util.Date

fun getGreetings(): String {
    val date: Date = Date()
    val cal: Calendar = Calendar.getInstance()
    cal.time = date
    val hour: Int = cal.get(Calendar.HOUR_OF_DAY)

    //Set greeting
    var greeting = ""
    if (hour in 6..11) {
        greeting = "Good Morning"
    } else if (hour in 12..16) {
        greeting = "Good Afternoon"
    } else if (hour in 17..20) {
        greeting = "Good Evening"
    } else if (hour in 21..23) {
        greeting = "Good Night"
    }
    return greeting
}