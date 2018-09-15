pipeline {
  agent any
  environment { 
     TMP_PATH = 'tmp/'${env.BUILD_ID}
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {
                   
              sh '''
                     echo ${env.path_tmp}
              '''
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
echo ("value : " + env.path_tmp)
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
