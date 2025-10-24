package com.example.newble.bluetooth

import android.util.Log
import java.nio.ByteBuffer
import java.nio.ByteOrder

object SensorDataParser {
    private const val EXPECTED_SIZE = 12 // 6 x 2 bytes

    fun parse(bytes: ByteArray): SensorData? {
        if (bytes.size < EXPECTED_SIZE) {
            Log.e("BLE", "Payload too small: ${bytes.size} bytes")
            return null
        }

        val buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)

        return SensorData(
            bmp1Temp = buf.short.toUShort(),
            bmp1Pressure = buf.short.toUShort(),
            bmp1Altitude = buf.short.toUShort(),
            bmp2Temp = buf.short.toUShort(),
            bmp2Pressure = buf.short.toUShort(),
            bmp2Altitude = buf.short.toUShort()
        )
    }
}
