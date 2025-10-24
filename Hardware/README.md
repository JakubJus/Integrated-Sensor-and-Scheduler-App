## ⚙️ Hardware Setup

1. **Connect your XIAO nRF52840 Sense**  
   Plug the board into your computer via USB-C.

2. **Install Required Libraries in Arduino IDE**  
   - Seeed Arduino LSM6DS3 by Seeed Studio (v2.0.5)  
   - ArduinoBLE by Arduino (v1.3.7 or above)  
   - Seeed nRF52 Boards by Seeed Studio (v1.1.8 or above)  
   - Seeed nRF52 mbed-enabled Boards by Seeed Studio (v2.9.2 or above)

3. **Select the Correct Board and Port**  
   Go to **Tools → Board → Seeed nRF52 mbed-enabled Boards → Seeed XIAO BLE Sense - nRF52840**.

   <img src="../Images/instructions.png" alt="Board Selection" width="400"/>

4. **Upload the Firmware Sketch**  
   Open `firmware.ino` and click **Upload** in Arduino IDE.

5. **Power the Device**  
   - Via USB, the device powers automatically.  
   - **If using a battery**, you must **disconnect the Serial Communication (USB)** to avoid conflicts.

The onboard LED should blink to indicate the device is active.

---

## 🧪 Sensor Output Example

0.01,0.02,9.81,0.05,0.00,0.01,27,8
accelX,accelY,accelZ,gyroX,gyroY,gyroZ,temp
