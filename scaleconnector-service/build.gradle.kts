plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    implementation("org.scream3r:jssc:2.8.0")
    implementation(project(":scaleconnector-core"))

    testImplementation("org.assertj:assertj-core:3.11.1")

    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}

tasks.test {
    useJUnitPlatform()
}
