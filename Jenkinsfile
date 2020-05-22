pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'JDK-14'
    }

    stages {

        stage('CI Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Build Image') {
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

        stage('Deploy K8S') {
            steps {
                configFileProvider([configFile(fileId: 'kubert-config', variable: 'KUBECONFIG')]) {
                    sh 'mvn k8s:resource k8s:apply'
                }
            }
        }
    }
}