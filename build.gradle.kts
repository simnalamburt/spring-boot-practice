plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    compile("com.google.guava:guava:22.0")
    compile("com.sparkjava:spark-core:2.6.0")
    compile("com.sparkjava:spark-template-mustache:2.5.5")
}

application {
    mainClassName = "App"
}
