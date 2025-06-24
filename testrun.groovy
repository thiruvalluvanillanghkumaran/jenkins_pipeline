pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Working on build stage'
            }
        }
        stage('Approval') {
            steps {
                script {
                    def userInput = input(
                        message: 'Waiting for approval...',
                        ok: 'Approve',
                        cancel: 'Reject'
                    )
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Working on deploy stage'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed'
        }
    }
}