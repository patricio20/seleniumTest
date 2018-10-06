pipeline {
  agent any
  environment { 
     TMP_PATH = "tmp/${env.BUILD_ID}"
     CO = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties | grep INDRA_DESA | cut -d '=' -f 2 ")}"""
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {                   
              echo  "PATH = ${env.TMP_PATH}"
              echo  "CMD = ${env.CO}"

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
