pipeline {

    agent {
        docker {
            image 'maven:3-jdk-14'
        }
    }

    stages {

        stage('CI Build') {
            steps {
                sh 'mvn clean install'
            }
        }

    stage('Build Container') {
            environment {
                DOCKER_HOST='tcp://docker:2376'
            }
            steps {
                sh 'mvn spring-boot:build-image'
            }
        }
    }
}