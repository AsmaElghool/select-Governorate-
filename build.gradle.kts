// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0") // Use the latest version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}
