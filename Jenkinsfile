pipeline {
    agent any
    
stages {

    stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        } 
          stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
        
        
    /*
          stage('MVN test') {
            steps {
               
              script {

                  sh 'mvn -f backend-spring/pom.xml test'

 
                      }
                   }        
         }*/

          
          stage('SONAR') {
            steps {
               
              script {

                  sh 'mvn  sonar:sonar  -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://172.16.1.132:9000/ -Dsonar.login=admin   -Dsonar.password=sonar'

 
                      }
                   }   
                   
         }
         
         stage('nexus') {
            steps {
               
              script {

sh 'mvn  deploy -e'                      }
                   }         
         }
    /*
          stage('Build Docker Image'){
                      steps {
                          script{
          				    sh 'docker image build . -t haifa123456/backcicd -f backend-spring/Dockerfile '
                          }
                      }
          		}
          		stage('Docker login') {
                                steps {
                                    script {

                                        sh 'docker login -u haifa123456 -p haifabrineg'}
                                }
                                }
                          stage('Pushing Docker Image') {
                                steps {
                                    script {

                                     sh 'docker push haifa123456/backcicd'
                                    }
                                }
                          }
                          stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh ' docker-compose -f backend-spring/docker-compose.yml up -d '
                                    }
                                }
                            }*/
     }
     
     }
