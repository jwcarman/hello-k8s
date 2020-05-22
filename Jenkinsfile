pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK-14'
    }

//     agent {
//         docker {
//             image 'maven:3-jdk-14'
//         }
//     }

    stages {

        stage('CI Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Build Container') {
            steps {
                configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -DskipTests -s $MAVEN_SETTINGS spring-boot:build-image'
                }

            }
        }

        stage('Push Image') {
            steps {
                configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -s $MAVEN_SETTINGS k8s:push'
                }
            }
        }
    }
}