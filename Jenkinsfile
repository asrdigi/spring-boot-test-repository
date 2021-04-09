pipeline {
  agent any
  stages {	
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			echo ' compile'			
			bat label: 'Compilation running', script: '''mvn compile'''
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			echo 'test'			
			bat label: 'Test running', script: '''mvn test'''
	     }
   	}

	stage('Jacoco Coverage Report') {
        	steps{  			
        			jacoco()            		
		}
	}
       
       /*
       stage('SonarQube'){
		steps{		 		
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.login=4e786f6325bc6bac3fca0554d8f0dbf7a3a5b719'''
			}
   		}
	*/
	
	
	stage("build & SonarQube analysis") {
          steps {
              withSonarQubeEnv('My SonarQube Server') {
                 sh 'mvn clean package sonar:sonar'
              }
          }
      }

      stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
      
      stage('Maven Package'){
		steps{
			echo 'Project packaging stage'			
			bat label: 'Project packaging', script: '''mvn package'''
		}
	} 
	
  }
}