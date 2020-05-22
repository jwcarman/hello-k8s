pipeline {

    agent {
        docker {
            image 'maven:3-jdk-14'
        }
    }
    environment {
        DOCKER_HOST=tcp://docker:2376
    }
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