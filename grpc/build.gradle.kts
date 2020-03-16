import com.google.protobuf.gradle.*

plugins {
    id("idea")
    id("java-library")
    id("com.google.protobuf") version "0.8.12"
}

val grpcVersion = "1.28.0"
val protocVersion = "3.11.4"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")

    if (JavaVersion.current().isJava9Compatible) {
        implementation("javax.annotation:javax.annotation-api:1.3.2")
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protocVersion"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }
    generatedFilesBaseDir = "$projectDir/src/"
    generateProtoTasks {
        all().forEach {task ->
            task.plugins {
                id("grpc") {
                    task.doFirst {
                        delete("$generatedFilesBaseDir/main/grpc")
                        delete("$generatedFilesBaseDir/main/java")
                    }
                }
            }
        }
    }
}
