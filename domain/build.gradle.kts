plugins {
    id(BuildPlugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    testImplementation(TestLibraries.junit)

}