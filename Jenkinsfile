pipeline {
  agent any
  environment { 
     TMP_PATH = "tmp/${env.BUILD_ID}"
     CMD = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties")}"""
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {                   
              echo  "PATH = ${env.TMP_PATH}"
              echo  "CMD = ${env.CMD}"

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
