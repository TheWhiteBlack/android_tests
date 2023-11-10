@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.ridery.test.yerih.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "com.ridery.test.yerih.core.testing.HiltTestRunner"
        consumerProguardFiles("consumer-rules.pro")

    }

    buildFeatures {
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
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
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)

    // Arch Components
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.kotlinx.coroutines.android)

    // Local tests: jUnit, coroutines, Android runner
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)


}