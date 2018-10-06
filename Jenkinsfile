pipeline {
  agent any
  environment { 
     TMP_PATH = "tmp/${env.BUILD_ID}"
     TMP = "INDRA_QA"
     PATH_SCRIPTS="/var/jenkins_home/scripts/deploy.properties"
     CO = """${sh(returnStdout: true, script: "cat ${env.PATH_SCRIPTS} | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 1 ")}"""
     AC = """${sh(returnStdout: true, script: "cat ${env.PATH_SCRIPTS} | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 2 ")}"""
     DE = """${sh(returnStdout: true, script: "cat ${env.PATH_SCRIPTS} | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 3 ")}"""
     PU = """${sh(returnStdout: true, script: "cat ${env.PATH_SCRIPTS} | grep ${env.TMP} | cut -d '=' -f 2 | cut -d ',' -f 4 ")}"""
  }
  stages {
    stage('Inicio') {
      parallel {
        stage('Inicio') {
          steps {                   
              echo  "PATH = ${env.TMP_PATH}"
              echo  "TMP = ${env.TMP}"
              echo  "PATH_SCRIPTS = ${env.PATH_SCRIPTS}"
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
    stage('Compilación') {
      steps {
        echo "Compila..."
      }
    }
    stage('Análisis de código') {
      steps {
        echo "Despliegua..."
      }
    }
    stage('Publicación') {
      steps {
        echo "Publicacion..."
      }
    }
    stage('Despliegue') {
      steps {
        echo "Publicacion..."
      }
    }
    stage('Pruebas unitarias') {
      steps {
        echo "Publicacion..."
      }
    }
  }
}
