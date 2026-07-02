<div align="center">

# 📷 QR Code Scanner

**A lightweight Android QR scanner that reads codes in real time and opens the detected link.**

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.20-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)
![Material 3](https://img.shields.io/badge/Material%203-6E48AA?style=flat-square&logo=materialdesign&logoColor=white)
![Stars](https://img.shields.io/github/stars/ahmetbostanciklioglu/QRCodeScanner?style=flat-square&color=6E48AA)
![Last Commit](https://img.shields.io/github/last-commit/ahmetbostanciklioglu/QRCodeScanner?style=flat-square&color=4776E6)

</div>

## 📖 Overview

QR Code Scanner is a single-screen Android app that turns the device camera into a live QR reader. It renders a CameraX preview with Jetpack Compose, analyzes each frame with the ZXing library, and surfaces the decoded value in a read-only field. Once a URL is detected, a single tap launches it in the browser.

## ✨ Features

- 📹 Live camera preview powered by CameraX and displayed inside a Jetpack Compose UI.
- 🔍 Real-time QR code decoding with ZXing, restricted to the `QR_CODE` format for fast, focused detection.
- 🔗 Detected content shown in a read-only field, with a **Launch** button that opens the URL in Chrome (falling back to any available browser).
- 🔐 Runtime camera permission handling with automatic re-prompting and clear on-screen status messages.
- 💾 State preservation across configuration changes so the last detected URL survives screen rotation.
- 🎨 Material 3 theming with edge-to-edge system UI.

## 📸 Preview

<div align="center">
  <img src="https://github.com/user-attachments/assets/47a88825-6d3e-4a83-ab65-a50a923897ce" width="400" height="700" alt="QR Code Scanner Screenshot">
</div>

## 🚀 Getting Started

```bash
git clone https://github.com/ahmetbostanciklioglu/QRCodeScanner.git
cd QRCodeScanner
```

Then open the project in **Android Studio**, let it **sync the Gradle files**, and press **Run** (`Shift + F10`) with a connected device or emulator that has a camera.

## 📋 Requirements

- Android Studio (Ladybug or newer recommended)
- Android SDK: `minSdk 24`, `targetSdk 34`, `compileSdk 35`
- Kotlin 2.0.20 · Android Gradle Plugin 8.7.2
- JDK 11
- A physical device or emulator with camera support

## 🧑‍💻 Author

**Ahmet Bostancıklıoğlu** — [@ahmetbostanciklioglu](https://github.com/ahmetbostanciklioglu) · ahmetbostancikli@gmail.com

> ⭐ If this helped you, consider giving the repo a star!
