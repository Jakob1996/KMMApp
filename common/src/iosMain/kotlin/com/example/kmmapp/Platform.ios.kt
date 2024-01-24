package com.example.kmmapp
actual class Platform {
    actual val osName: String
        get() = UIDevice.currentDevice.systemName
    actual val osVersion: String
        get() = TODO("Not yet implemented")
    actual val deviceModel: String
        get() = TODO("Not yet implemented")
    actual val density: Int
        get() = TODO("Not yet implemented")

    actual fun logSystemInfo() {
    }

}