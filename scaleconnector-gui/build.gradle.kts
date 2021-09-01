plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    implementation(project(":scaleconnector-core"))
    implementation(project(":scaleconnector-service"))
    implementation(project(":scaleconnector-client"))

    implementation("org.scream3r:jssc:2.8.0")

    implementation("jline:jline:1.0")
    implementation("info.picocli:picocli:4.6.1")

    implementation("com.miglayout:miglayout-swing:11.0")
    implementation("org.pushing-pixels:radiance-substance:4.0.0")

    implementation("org.slf4j:slf4j-simple:1.7.30")

    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.ingeint.scaleconnector.gui.app.Main")
}
