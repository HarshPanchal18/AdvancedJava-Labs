plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    runtimeOnly("mysql:mysql-connector-java:8.0.+")

    implementation("com.sun.mail:javax.mail:1.5.5")
}

tasks.test {
    useJUnitPlatform()
}