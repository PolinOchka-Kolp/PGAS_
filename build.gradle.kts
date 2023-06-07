plugins {
    kotlin("js") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotlinWrappersVersion = "1.0.0-pre.490"
val kotlinWrappers = "org.jetbrains.kotlin-wrappers"

dependencies {

    implementation(
        project.dependencies.enforcedPlatform(
            "$kotlinWrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"
        )
    )

    testImplementation(kotlin("test"))
    implementation("$kotlinWrappers:kotlin-tanstack-react-query")
    implementation("$kotlinWrappers:kotlin-tanstack-react-query-devtools")
    implementation(npm("cross-fetch", "3.1.5"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.9.3-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.3.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.2-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.6-pre.346")
    implementation(npm("jszip", "3.6.0"))
}

kotlin {
    js (IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}