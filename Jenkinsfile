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
             	   sh " mvn sonar:sonar -Dsonar.projectKey=yassine -Dsonar.host.url=http://192.168.1.200:9000   -Dsonar.login=f02dc50ee19c3a56d28b6f1ecdff128cd891ab1a"

                }
            }
        }
     
     
         stage("publish to nexus") {
            steps {
                script {
                configFileProvider([configFile(fileId: 'yassine', variable: 'settings')]) {
                    sh 'mvn  -B -DskipTests deploy -s $settings'

}                }
            }
        }
	
	stage("Create Docker Image") {
            steps {
                script {
                   sh 'docker build -t yassinezaghdane/spring:latest .'
                }
            }
        }
       stage("LOGIN to docker hub") { 
             steps { 
                  
			 sh 'docker login -u yassinezaghdane -p M3ra2j118*'
                        
                    
                 } 
             } 
	stage("Push Docker Hub")
	{
		steps{
			script{
				sh 'docker push yassinezaghdane/spring:latest'
				}

			 }
	}
         
                  stage("Docker compose") {
            steps {
                script {
                   sh 'docker compose up -d'
                }
            }
         }



     
 }
   
}