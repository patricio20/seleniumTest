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
tmpjob="tmp/"$BUILD_ID
mkdir $tmpjob   
echo "Compila..." > $tmpjob"/testcompila"
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