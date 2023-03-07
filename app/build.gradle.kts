plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.android)
}

android {
    compileSdk = ProjectVersions.compileSdk

    defaultConfig {
        applicationId = "com.example.testreport"
        minSdk = ProjectVersions.minSdk
        targetSdk = ProjectVersions.targetSdk
        versionCode = ProjectVersions.versionCode
        versionName = ProjectVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

}

dependencies {

    //modules
    implementation(project(":domain"))
    implementation(project(":data"))

    //test libraries
    testImplementation(TestLibraries.junit)

}