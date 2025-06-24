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
                        message: 'QA approval needed',
                        ok: 'Approve',
                        cancel: 'Reject'
                    )
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Working on deploy QA'
            }
        }
        stage('Approval') {
            steps {
                script {
                    def userInput = input(
                        message: 'Waiting for approval in stage Deploy',
                        ok: 'Approve',
                        cancel: 'Reject'
                    )
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Working on deploy Stage'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed'
        }
    }
}