pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build App-----'
            }
        }

        stage('Test') {
            steps {
                echo 'Test App'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy App...'
            }
        }
    }

    post{

      always{
        echo "reached post section of pipeline...completed pipeline"

      }
    }
}
