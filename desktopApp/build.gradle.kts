import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }
    
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.desktop.currentOs)
                implementation(compose.material3)
                implementation(libs.koin.core)
            }
        }
        
        val jvmTest by getting {
            dependencies {
                implementation(compose.desktop.uiTestJUnit4)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose {
    kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:1.5.3")
}

compose.desktop {
    application {
        mainClass = "MainKt"
        
        nativeDistributions {
            val resources = project.layout.projectDirectory.dir("src/jvmMain/resources")
            
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            appResourcesRootDir.set(resources)
            packageName = "Organize"
            packageVersion = "1.0.0"
            
            macOS {
                // Use -Pcompose.desktop.mac.sign=true to sign and notarize.
                bundleID = "uz.otamurod.organize.desktop"
                iconFile.set(resources.file("macos-icon.icns"))
            }
            
            windows {
                iconFile.set(resources.file("windows-icon.ico"))
            }
            
            linux {
                iconFile.set(resources.file("linux-icon.png"))
            }
        }
    }
}