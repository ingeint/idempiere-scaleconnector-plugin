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
    implementation("com.miglayout:miglayout-swing:11.0")
    implementation("jline:jline:1.0")
    implementation("org.pushing-pixels:radiance-substance:4.0.0")
    implementation("org.scream3r:jssc:2.8.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.ingeint.scaleconnector.gui.app.Main")
}
