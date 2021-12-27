dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
        maven {
            isAllowInsecureProtocol = true
            setUrl("http://47.97.251.64:8081/repository/maven-releases/")
        }
    }
}
rootProject.name = "OpenEye"
include(":app")
