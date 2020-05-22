pipeline {

    agent {
        docker {
            image 'maven:3-jdk-14'
        }
    }
    stages {

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}