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
                sh 'mvn spring-boot:build-image'
            }
        }
    }
}