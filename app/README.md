Gå vidare till innehållet
Chatthistorik

Du sade:
add isntructiosn png to hardware # Integrated Sensor & Scheduler App

This project consists of two components:

1. 🧠 **Sensor Firmware (Hardware)**  
   Arduino-based firmware running on a **Seeed Studio XIAO nRF52840 Sense** that measures **temperature, acceleration, and gyroscope data**, and transmits it via **Bluetooth Low Energy (BLE)**.

2. 📱 **Android App (Software)**  
   An Android application built with **Jetpack Compose** that connects to the BLE device, visualizes sensor data in real-time, and saves sessions to **Firebase** for later viewing. The application works also as an scheduler to plan an activity.

---

## 📦 Repository Structure

App-and-hardware-for-temperature-and-angle-sensor/
├── sensor/       # Arduino firmware for the XIAO nRF52840 BLE IMU
├── app/          # Android app to connect, visualize, and store data
└── README.md     # This file


---

## ⚙️ How to Set It Up

### 🔧 Hardware Setup

To set up the **BLE sensor firmware**, visit the [sensor/](sensor/) folder and follow the instructions in the [README.md](sensor/README.md) inside.

- Connect your XIAO nRF52840 Sense
- Libaries needed in Arduino studio are: Seeed Arduino LSM6DS3 by Seeed Studio version 2.0.5, ArduinoBLE by Arduino version 1.3.7 or above. Seeed nRF52 Boards bt seed stdio 1.1.8 or above. Seeed nRF52 mbed-enabled Boards by Seed stio 2.9.2 or abobe Go to Toools Board "xxxx" select Seeed nRF52 mbed-enabled Boards -> Seeed XIAO BLE Sense - nrf52840
- Upload the Arduino sketch
- Power the device

### 💻 Software Setup

To set up the **Android app**, visit the [app/](app/) folder and follow the instructions in the [README.md](app/README.md).

- Connect to the BLE device
- View real-time graphs activity
- Add new activity to schedule
- Remove activity from schedule
- Save data to Firebase
- View historical sessions and plan future ones

---

## 📋 Summary

| Component | Folder | Technology | Purpose |
|----------|--------|-------------|---------|
| 🔌 Sensor Firmware | sensor/ | Arduino + BLE + IMU | Streams sensor data via BLE |
| 📲 Android App | app/ | Jetpack Compose + Firebase | Graphs & stores the data |

---

## 🧪 Sensor Output Example

0.01,0.02,9.81,0.05,0.00,0.01,27,8
accelX,accelY,accelZ,gyroX,gyroY,gyroZ,temp


---

## 🛠️ Future Work

- Improve user profile section in the app
- Export session as CSV or PDF
- Orientation or tilt visualizer

---

## 📄 License

MIT License – see individual folders for full license details.
ChatGPT sade:
Got it 👍 — to add setup instruction images (PNGs) to the Hardware section, here’s how you can modify your README:

✅ Updated Hardware Section with PNG Instructions
### 🔧 Hardware Setup

To set up the **BLE sensor firmware**, visit the [`sensor/`](sensor/) folder and follow the instructions in the [`README.md`](sensor/README.md) inside.

1. **Connect your XIAO nRF52840 Sense**  
   Plug the board into your computer via USB-C.

   ![Connect Board](docs/images/connect_board.png)

2. **Install Required Libraries in Arduino IDE**
   - Seeed Arduino LSM6DS3 by Seeed Studio (v2.0.5)
   - ArduinoBLE by Arduino (v1.3.7 or above)
   - Seeed nRF52 Boards by Seeed Studio (v1.1.8 or above)
   - Seeed nRF52 mbed-enabled Boards by Seeed Studio (v2.9.2 or above)

   ![Arduino Libraries](docs/images/arduino_libraries.png)

3. **Select the Correct Board and Port**  
   Go to **Tools → Board → Seeed nRF52 mbed-enabled Boards → Seeed XIAO BLE Sense - nRF52840**.

   ![Board Selection](docs/images/board_selection.png)

4. **Upload the Firmware Sketch**  
   Open the sketch located in the `sensor/` folder and click **Upload**.

   ![Upload Sketch](docs/images/upload_sketch.png)

5. **Power the Device**  
   Once uploaded, you can power the device via USB or battery. The onboard LED should blink to indicate it’s active.

   ![Powered Device](docs/images/powered_device.png)
📁 Folder Structure Suggestion
To keep images organized, create a new folder for them:

App-and-hardware-for-temperature-and-angle-sensor/
├── sensor/
├── app/
├── docs/
│   └── images/
│       ├── connect_board.png
│       ├── arduino_libraries.png
│       ├── board_selection.png
│       ├── upload_sketch.png
│       └── powered_device.png
└── README.md
Would you like me to generate example hardware setup PNG diagrams (like connection, board selection, upload process, etc.) for you next?

Du sade:
scale them down
ChatGPT sade:
Perfect 👍 — to scale down the PNGs in Markdown (since GitHub Markdown doesn’t natively support image resizing with syntax like width=""), you can use HTML <img> tags instead of ![]().

Here’s the hardware setup section updated with scaled-down PNGs (using width 400 px as a good visual balance):

### 🔧 Hardware Setup

To set up the **BLE sensor firmware**, visit the [`sensor/`](sensor/) folder and follow the instructions in the [`README.md`](sensor/README.md) inside.

1. **Connect your XIAO nRF52840 Sense**  
   Plug the board into your computer via USB-C.

   <img src="docs/images/connect_board.png" alt="Connect Board" width="400"/>

2. **Install Required Libraries in Arduino IDE**  
   - Seeed Arduino LSM6DS3 by Seeed Studio (v2.0.5)  
   - ArduinoBLE by Arduino (v1.3.7 or above)  
   - Seeed nRF52 Boards by Seeed Studio (v1.1.8 or above)  
   - Seeed nRF52 mbed-enabled Boards by Seeed Studio (v2.9.2 or above)

   <img src="docs/images/arduino_libraries.png" alt="Arduino Libraries" width="400"/>

3. **Select the Correct Board and Port**  
   Go to **Tools → Board → Seeed nRF52 mbed-enabled Boards → Seeed XIAO BLE Sense - nRF52840**.

   <img src="docs/images/board_selection.png" alt="Board Selection" width="400"/>

4. **Upload the Firmware Sketch**  
   Open the sketch located in the `sensor/` folder and click **Upload**.

   <img src="docs/images/upload_sketch.png" alt="Upload Sketch" width="400"/>

5. **Power the Device**  
   Once uploaded, you can power the device via USB or battery. The onboard LED should blink to indicate it’s active.

   <img src="docs/images/powered_device.png" alt="Powered Device" width="400"/>
💡 Tips
You can adjust the width (e.g., 300, 350, 450) if you want smaller or larger images.

These <img> tags will render fine on GitHub, GitLab, and most markdown viewers.

If you want consistent alignment, wrap them in <p align="center"> … </p>.

Example:

<p align="center">
  <img src="docs/images/connect_board.png" alt="Connect Board" width="400"/>
</p>
Would you like me to also center all the images in the section for a cleaner, consistent layout?




Ingen fil har valtsIngen fil har valts
ChatGPT kan begå misstag. Kontrollera viktig information.
