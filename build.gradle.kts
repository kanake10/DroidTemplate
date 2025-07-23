// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
  //  alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.devtools.ksp) apply false
}

apply(from = "buildscripts/githooks.gradle")

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

afterEvaluate {
    // We install the hook at the first occasion
    tasks.named("clean") {
        dependsOn(":installGitHooks")
    }
}