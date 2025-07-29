plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.example.droidtemplate"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.droidtemplate"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildFeatures {
        buildConfig = true
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.runtime.livedata)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit4.ext)
    testImplementation(libs.turbine)
    testImplementation(libs.mockk)
    testImplementation(libs.mock.agent)
    testImplementation(libs.mock.android)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.google.truth)
    testImplementation(libs.androidx.arch.core.testing)
    testImplementation(libs.robolectric)
    // Instrumentation Testing
    androidTestImplementation(libs.junit4.ext)
    androidTestImplementation(libs.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.coil.compose)

    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    implementation(libs.leakcanary)
    implementation(libs.timber)
    implementation(libs.datastore)
}

tasks.formatKotlinMain {
    exclude { it.file.path.contains("build/")}
}

tasks.lintKotlinMain {
    exclude { it.file.path.contains("build/")}
}
