plugins {
	java
	groovy
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.pw"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springframework.boot:spring-boot-starter-data-redis:3.3.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.redis:testcontainers-redis:2.2.2")
	testImplementation("org.springframework:spring-test:6.1.14")
	testImplementation("org.spockframework:spock-core:2.4-M4-groovy-4.0")
	testImplementation("org.spockframework:spock-spring:2.4-M4-groovy-4.0")
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
