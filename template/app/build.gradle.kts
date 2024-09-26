plugins { application }

repositories { mavenCentral() }

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") { useJUnitPlatform() }

java {
    toolchain { languageVersion = JavaLanguageVersion.of(22) }
}

application {
    mainClass = "App"
}

