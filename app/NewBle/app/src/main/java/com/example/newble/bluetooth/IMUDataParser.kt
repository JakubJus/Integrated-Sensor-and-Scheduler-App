package com.example.newble.bluetooth

import android.util.Log
import java.nio.charset.Charset

/**
 * Tries to interpret the incoming characteristic value in two ways:
 *  1.  If it *looks* like ASCII text starting with "A", "G", or "M", parse it as CSV.
 *  2.  Otherwise, treat it as the 12-byte `sensor_data` struct and decode with [SensorDataParser].
 *
 * Returns:
 *  •  Pair<String,String>  – when the payload was an "A/G/M, x, y, z" string
 *  •  SensorData           – when the payload was the binary struct
 *  •  null                 – on any error
 */
object IMUDataParser {

    fun parseData(data: ByteArray): Any? {
        if (data.isEmpty()) return null

        // -------- 1) Try ASCII / CSV path --------------------------
        val rawText = kotlin.runCatching {
            String(data, Charset.forName("US-ASCII")).trim()
        }.getOrNull()

        if (!rawText.isNullOrEmpty()) {
            val imuDataList = rawText.split(",").map { it.trim('(', ')', ' ') }
            when (imuDataList.getOrNull(0)) {
                "A", "G", "M" -> {
                    if (imuDataList.size >= 4) {
                        Log.d("BLE", "Parsed CSV: $rawText")
                        return imuDataList[0] to
                                "${imuDataList[1]},${imuDataList[2]},${imuDataList[3]}"
                    }
                }
            }
        }

        // -------- 2) Try binary struct path ------------------------
        SensorDataParser.parse(data)?.let { sensorData ->
            Log.d("BLE", "Parsed binary struct: $sensorData")
            return sensorData
        }

        Log.e("BLE", "Failed to decode payload (${data.size} bytes)")
        return null
    }
}