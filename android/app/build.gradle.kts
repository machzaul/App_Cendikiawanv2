plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services") // ← penting untuk Firebase
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.Appcendikiawan"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "29.0.13113456"

    defaultConfig {
        applicationId = "com.example.Appcendikiawan"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false // ← ini ditambahkan agar aman
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Tambahkan dependensi Firebase di sini
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))

    // Dependensi Firebase Analytics (opsional tapi direkomendasikan)
    implementation("com.google.firebase:firebase-analytics")

    // Tambahkan dependensi Firebase lain sesuai kebutuhan
    // implementation("com.google.firebase:firebase-auth")
    // implementation("com.google.firebase:firebase-firestore")
}

flutter {
    source = "../.."
}