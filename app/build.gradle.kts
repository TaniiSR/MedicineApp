plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

android {
    namespace = "com.task.medicineapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.task.medicineapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.compose.viewModel)
    implementation(libs.androidx.compose.ui)
    implementation(libs.compose.navigation)
    implementation(libs.navigation.hilt)
    implementation(libs.hilt.android)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.interceptor)
    implementation(libs.gson)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    ksp(libs.hilt.compiler)
    api(libs.kotlin.reflect)
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.core.ktx.test)
    testImplementation(libs.junit5.test)
    testImplementation(libs.turbine.test)
    testImplementation(libs.truth.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.junit5.extension)
    androidTestImplementation(libs.androidx.core.test)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testRuntimeOnly(libs.junit5.engine.test)
    testRuntimeOnly(libs.vintage.test)
    testImplementation(libs.arch.testing)
    testImplementation(kotlin("test"))

}