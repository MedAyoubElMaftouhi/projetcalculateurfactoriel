pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t medayoubelmaftouhi/simple-maven-app:1.0 .'
            }
        }
stage('Push to DockerHub') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-password', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            sh '''
            echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
            docker push medayoubelmaftouhi/simple-maven-app:1.0
            '''
        }
    }
}
        stage('Deploy') {
            steps {
                sshagent(['remote-server-ssh']) {
                    sh 'ssh user@remoteserver "docker pull medayoubelmaftouhi/simple-maven-app:1.0 && docker run -d -p 80:80 medayoubelmaftouhi/simple-maven-app:1.0"'
                }
            }
        }
    }
}
