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
        sh '''
        echo "Simulating deployment locally..."
        docker pull medayoubelmaftouhi/simple-maven-app:1.0
        docker run -d -p 8091:8091 medayoubelmaftouhi/simple-maven-app:1.0
        echo "Application running at http://localhost:8081"
        '''
	    }
	}
    }
}
