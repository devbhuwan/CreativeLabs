import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.50"
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    compile("org.springframework.data:spring-data-commons:2.0.8.RELEASE")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}