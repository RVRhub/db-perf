import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.2.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("com.gradle.build-scan") version "2.1"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
	id("com.palantir.docker") version "0.22.1"
}


group = "com.rvr"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

val reactorKotlinExtensionsVersion = "1.0.2.RELEASE"
val  springBootBomR2DbcVersion = "0.1.0.M3"
val  r2dbch2Version = "0.8.2.RELEASE"
val h2Version = "1.4.200" // with 200 there are errors as data-r2dbc is not yet updated

dependencies {
	//react
	implementation("org.springframework.boot.experimental:spring-boot-actuator-autoconfigure-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:$reactorKotlinExtensionsVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	//TODO: postgres
	implementation("io.r2dbc:r2dbc-h2:$r2dbch2Version")
	implementation("com.h2database:h2:$h2Version")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:$springBootBomR2DbcVersion")
	}
}

//buildScan {
//    termsOfServiceUrl = "https://gradle.com/terms-of-service"
//    termsOfServiceAgree = "yes"
//}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}