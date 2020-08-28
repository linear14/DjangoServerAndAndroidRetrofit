package com.dongldh.movietestapp.util

object Util {
    fun isYearNumber(year: String): Boolean {
        var isYearNumber = true
        for(i in year) {
            if(!i.isDigit()) {
                isYearNumber = false
                break
            }
        }
        return isYearNumber
    }
}