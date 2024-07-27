plugins {
    val agpVersion = "8.2.2"
    val kotlinVersion = "1.9.23"
    val jetbrainsComposeVersion = "1.6.11"
    
    id("com.android.application").version(agpVersion).apply(false)
    id("com.android.library").version(agpVersion).apply(false)
    id("org.jetbrains.compose").version(jetbrainsComposeVersion).apply(false)
    
    kotlin("android").version(kotlinVersion).apply(false)
    kotlin("multiplatform").version(kotlinVersion).apply(false)
    kotlin("jvm").version(kotlinVersion).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}