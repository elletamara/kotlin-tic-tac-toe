import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.50"
    kotlin("jvm") version kotlinVersion
}

group = "tic-tac-toe"
version = "1.0-SNAPSHOT"

val junitPlatformVersion = "5.4.1"

repositories {
    mavenCentral()
}

apply {
    plugin("application")

}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("test"))
    implementation(kotlin("test-junit"))

    implementation(kotlin("stdlib-jdk8"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitPlatformVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitPlatformVersion")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

configure<ApplicationPluginConvention> {
    mainClassName = "TicTacToeKt"
    applicationName = "TicTacToe"
}

tasks {
    withType<Test> {
        useJUnitPlatform()

        // make sure test results are printed to console
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
