// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false // For KSP (Alternative to KAPT)
    id("org.jetbrains.kotlin.kapt") version "1.9.22" apply false
}