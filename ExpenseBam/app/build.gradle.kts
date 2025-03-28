plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "bam.budget"
    compileSdk = 35

    defaultConfig {
        applicationId = "bam.budget"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.common)
    implementation("androidx.compose.ui:ui:1.5.0") // Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // ViewModel
    implementation("androidx.navigation:navigation-compose:2.7.2") // Navigation
    implementation("androidx.room:room-runtime:2.5.2")
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.runner) // Room Database
    kapt("androidx.room:room-compiler:2.5.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit API
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // JSON Converter
    implementation("com.google.firebase:firebase-auth:22.1.0") // Firebase for email alerts
    implementation("com.google.firebase:firebase-firestore:24.7.0") // Firestore for backup

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation ("androidx.room:room-testing:2.5.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation ("io.mockk:mockk:1.13.2")
    androidTestImplementation ("io.mockk:mockk-android:1.13.2")
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation(kotlin("test"))
}