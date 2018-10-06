pipeline {
  agent any
  environment { 
     TMP_PATH = "tmp/${env.BUILD_ID}"
     TMP = "INDRA_DESA"
     CO = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 1 ")}"""
     AC = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 2 ")}"""
     DE = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 3 ")}"""
     PU = """${sh(returnStdout: true, script: "cat /var/jenkins_home/scripts/deploy.properties | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 4 ")}"""
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {                   
              echo  "PATH = ${env.TMP_PATH}"
              echo  "CO = ${env.CO}"
              echo  "AC = ${env.AC}"
              echo  "DE = ${env.DE}"
              echo  "PU = ${env.PU}"

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
