pipeline {
  agent any
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {
            sh '/var/jenkins_home/scripts/deploy.sh DESA'
          }
        }
        stage('') {
          steps {
            slackSend(message: 'Iniciando CI', botUser: true, baseUrl: 'https://nkcom.slack.com', channel: 'general')
          }
        }
      }
    }
  }
}