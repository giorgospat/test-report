buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradleLibraries.androidPlugin)
        classpath(GradleLibraries.kotlinPlugin)
    }
}

val testReport = tasks.register<TestReport>("testReport") {

    destinationDirectory.set(file("$buildDir/reports/tests/test"))

    //for kotlin/java modules
    testResults.from(subprojects.mapNotNull {
        it.tasks.findByPath("test")
    })

    // run unit tests for specific flavor (e.g. debug/release etc)
    testResults.from(subprojects.mapNotNull {
        it.tasks.findByPath("testDebugUnitTest")
    })

}

subprojects {
    tasks.withType<Test> {
        useJUnit()
        testLogging {
            events("passed", "skipped", "failed")
        }

        // disable reports on each module
        reports.html.required.set(false)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}