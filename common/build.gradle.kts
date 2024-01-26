plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
    kotlin("plugin.serialization") version "1.9.20"
    id("co.touchlab.skie") version "0.4.19"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "common"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //Coroutines
            implementation(libs.kotlinx.coroutines.core)
            //Ktor
            implementation(libs.io.ktor.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.core)
            //DataTime
            implementation(libs.kotlinx.datetime)
            //Koin
            implementation(libs.koin.core)
            //SqlDelight coroutines
            implementation(libs.coroutines.extensions)
        }

        androidMain.dependencies {
            //ViewModel
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            //Ktor
            implementation(libs.ktor.client.android)
            //SqlDelight
            implementation(libs.android.driver)
        }

        iosMain.dependencies {
            //Ktor
            implementation(libs.ktor.client.darwin)
            //SqlDelight
            implementation(libs.native.driver)

        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.kmmapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}

sqldelight {
    databases {
        create("KMMAppDatabase") {
            packageName.set("com.example.kmmapp.db")
        }
    }
}