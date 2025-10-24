package com.example.newble.bluetooth

data class SensorData(
    val bmp1Temp: UShort,
    val bmp1Pressure: UShort,
    val bmp1Altitude: UShort,
    val bmp2Temp: UShort,
    val bmp2Pressure: UShort,
    val bmp2Altitude: UShort
)
