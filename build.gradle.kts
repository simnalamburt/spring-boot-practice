plugins {
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-mustache:2.2.1.RELEASE")
}
