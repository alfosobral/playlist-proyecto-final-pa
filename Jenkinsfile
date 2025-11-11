pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando repositorio...'
                git 'https://github.com/alfosobral/playlist-proyecto-final-pa.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Construyendo el proyecto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando tests...'
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando aplicación Spring Boot...'
                bat 'java -jar target/mi-playlist-0.0.1-SNAPSHOT.jar'
            }
        }
    }

    post {
        success {
            echo '✅ Build completado correctamente'
        }
        failure {
            echo '❌ Error en el pipeline'
        }
    }
}
