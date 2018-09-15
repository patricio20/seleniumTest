pipeline {
  agent any
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {
            sh '''## Crea temporales
TMP=tmp/$BUILD_ID
mkdir -p $TMP'''
          }
        }
        stage('Notifica') {
          steps {
            slackSend(message: 'Iniciando CI', botUser: true, baseUrl: 'https://nkcom.slack.com', channel: 'general')
          }
        }
      }
    }
    stage('Compila (CC)') {
      steps {
        sh '''echo "Compila..."
echo $TMP
echo "Compila..." > $TMP"/testcompila"
'''
      }
    }
    stage('Despliegua') {
      steps {
        sh '''echo "Despliega..."
echo "Despliega..." > tmpdespliega'''
      }
    }
  }
}