plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    implementation("com.googlecode.json-simple:json-simple:1.1.1")

    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    implementation(project(":scaleconnector-core"))
}

tasks.test {
    useJUnitPlatform()
}
