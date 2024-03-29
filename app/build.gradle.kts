plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.NoteApp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.NoteApp"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-auth:22.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("androidx.compose.material:material:1.5.4")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.4")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.4.1"))
    //authentication
    implementation ("com.google.firebase:firebase-auth-ktx")
    //firestore
    implementation ("com.google.firebase:firebase-firestore-ktx")
    // coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")
    //navigation
    implementation("androidx.navigation:navigation-compose:2.4.2") {
        isTransitive = true
    }

//    implementation("me.saket.swipe:swipe:1.0.0")

    implementation("com.airbnb.android:lottie-compose:5.2.0")

    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
}