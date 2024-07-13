// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.ksp) apply false
    id("de.mannodermaus.android-junit5") version "1.10.0.0" apply false
}
tasks.withType<Test> {
    useJUnitPlatform()
}