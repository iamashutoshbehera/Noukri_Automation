pipeline {

    agent any

    tools {
        jdk 'JDK21'          // Must match the JDK name configured in Jenkins
        maven 'Maven3'       // Must match the Maven name configured in Jenkins
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/<username>/<repository>.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

    }

    post {

        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/**', fingerprint: true
        }

        success {
            echo 'Execution Successful'
        }

        failure {
            echo 'Execution Failed'
        }
    }
}