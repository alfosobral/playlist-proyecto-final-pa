pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'JDK 17'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
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
                echo 'Desplegando aplicación...'
                bat 'scripts\\deploy_windows.bat'
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado correctamente'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo 'Error en el pipeline'
        }
    }
}
