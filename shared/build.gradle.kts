plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.animation)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api(compose.materialIconsExtended)

                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.negotiation)

                api(libs.koin.core)
                api(libs.koin.compose)
                api(libs.coil3)
                api(libs.coil3.network)
                api(libs.precompose)
                api(libs.precompose.viewmodel)
                api(libs.precompose.koin)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                api(libs.androidx.activity.compose)
                api(libs.androidx.appcompat)
                api(libs.androidx.core)
                implementation(libs.ktor.okhttp)
                api(libs.coil3.gif)
                api(libs.coil3.svg)
                api(libs.coil3.core)
                api(libs.coil3.video)
                implementation(libs.system.ui.controller)
                implementation(libs.accompanist.permissions)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.darwin.ios)
                implementation(libs.ktor.ios)
            }
        }
    }
}

android {
    namespace = "com.techieroid.webviewapplication"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    sourceSets["main"].res.srcDirs("src/commonMain/resources", "src/androidMain/res")
    
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}