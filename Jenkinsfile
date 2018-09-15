pipeline {
  agent any
  environment { 
     path_tmp = ''
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {
              echo ("value : " + env.path_tmp)       
              script {
                      path_tmp=tmp/$BUILD_ID
                      mkdir -p $path_tmp
              }
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
