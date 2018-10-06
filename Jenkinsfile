pipeline {
  agent any
  environment { 
     TMP_PATH = "tmp/${env.BUILD_ID}"
     EXIT_STATUS = """${sh(returnStatus: true, script: "exit 1")}"""
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {                   
              echo  "PATH = ${env.TMP_PATH}"
              echo  "EXIT_STATUS = ${env.EXIT_STATUS}"

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
        echo "Compila..."
      }
    }
    stage('Despliegua') {
      steps {
        echo "Despliegua..."
      }
    }
  }
}
