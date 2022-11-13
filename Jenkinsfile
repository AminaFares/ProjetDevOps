pipeline {
    agent any
     tools {
        maven 'maven'
    }
 stages {
         stage("get code from git"){
            steps{
                script{
                    checkout([$class: 'GitSCM', branches: [[name: '*/yassine_zaghdane']], extensions: [], userRemoteConfigs: [[credentialsId: 'git', url: 'https://github.com/AminaFares/ProjetDevOps.git']]])
                }
            }
         }
                
         stage("cleaning code") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean '
                }
            }
        }
         stage("building") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean package'
                }
            }
         }
            stage("testing") {
            steps {
                script {
                   sh 'mvn test'
                }
            }
        }
        stage("code QualityCheck Sonar") {
            steps {
                script {
             sh " mvn sonar:sonar -Dsonar.projectKey=anis -Dsonar.host.url=http://http://192.168.1.200:9000   -Dsonar.login=282d7fa8f09ba135e4cd32e1c6aeefd1b8ab7b7a"

                }
            }
        }
     
     
         stage("publish to nexus") {
            steps {
                script {
                configFileProvider([configFile(fileId: 'anis', variable: 'setting')]) {
                    sh 'mvn  -B -DskipTests deploy -s $setting'

}                }
            }
        }

     
 }
   
}