plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:28.1-jre")
    implementation("com.sparkjava:spark-core:2.8.0")
    implementation("com.sparkjava:spark-template-mustache:2.7.1")
}

application {
    mainClassName = "App"
}
