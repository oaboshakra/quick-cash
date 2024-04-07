buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath ("com.google.gms:google-services:4.3.2")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}