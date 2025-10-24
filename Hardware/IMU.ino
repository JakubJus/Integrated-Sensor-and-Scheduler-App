#include "LSM6DS3.h"
#include "Wire.h"
#include <ArduinoBLE.h>

BLEService imuService("19B10000-E8F2-537E-4F6C-D104768A1214"); 
BLECharacteristic imuDataCharacteristic("19B10001-E8F2-537E-4F6C-D104768A1213", BLERead | BLENotify, 24); 
LSM6DS3 myIMU(I2C_MODE, 0x6A); 

#define CONVERT_G_TO_MS2 9.80665f  
#define FREQUENCY_HZ 50          
#define INTERVAL_MS (1000 / FREQUENCY_HZ)  

static unsigned long last_interval_ms = 0;

void setup() {
    Serial.begin(115200); 
    while (!Serial);       

    if (!BLE.begin()) {
        Serial.println("Starting Bluetooth® Low Energy module failed!");
        while (1);
    }
  
    BLE.setLocalName("IMU_Device");
    BLE.setAdvertisedService(imuService);

    imuService.addCharacteristic(imuDataCharacteristic);

    BLE.addService(imuService);

    BLE.advertise();

    Serial.println("BLE IMU Peripheral");

    if (myIMU.begin() != 0) {
        Serial.println("IMU Device error");
    } else {
        Serial.println("IMU Device OK!");
    }
}

void loop() {
    BLEDevice central = BLE.central();
    if (central) {
        Serial.print("Connected to central: ");
        Serial.println(central.address());

        while (central.connected()) {
            if (millis() > last_interval_ms + INTERVAL_MS) {
                last_interval_ms = millis();
                float accelX = myIMU.readFloatAccelX();
                float accelY = myIMU.readFloatAccelY();
                float accelZ = myIMU.readFloatAccelZ();
                float gyroX = myIMU.readFloatGyroX();
                float gyroY = myIMU.readFloatGyroY();
                float gyroZ = myIMU.readFloatGyroZ();
                float temp = myIMU.readTempC();
                // Format the data as a comma-separated string
                String imuData = "A,"+String(accelX) + "," + String(accelY) + "," + String(accelZ) + ","
                                 +"G,"+ String(gyroX) + "," + String(gyroY) + "," + String(gyroZ) + ","
                                 +"M,"+ String(temp);
                Serial.println(imuData);
                //Serial.println(imuData);
                imuDataCharacteristic.writeValue(imuData.c_str());// Send data as string over BLE
            }
        }
        Serial.print(F("Disconnected from central: "));
        Serial.println(central.address());
    }
}