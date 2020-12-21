plugins {
    java
    id("org.springframework.boot") version "2.4.1"
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.4.1")
    implementation("org.springframework.boot:spring-boot-starter-mustache:2.4.1")
}
