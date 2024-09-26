plugins {
  id("java")
  application
}

repositories { mavenCentral() }

dependencies {
  // Use JUnit Jupiter for testing.
  testImplementation(libs.junit.jupiter)
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
  testLogging.showStandardStreams = true
  testLogging { events("passed", "skipped", "failed") }
}

java { toolchain { languageVersion = JavaLanguageVersion.of(22) } }

application { mainClass = "DataStructures" }
