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
       
      
       stage('SonarQube Analysis'){
		steps{		 		
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.analysis.mode= \
				-Dsonar.login=d51e7f6380a528b36cea3db64f4ee21870015682'''
			}
   		}
	
	
	/*
	stage('SonarQube Analysis') {
          steps {
              withSonarQubeEnv('SonarQube') {
                 sh 'mvn clean package sonar:sonar'
              }
          }
      }
      */
	/*
      stage("Quality Gate"){
        steps{
          waitForQualityGate abortPipeline: true
         } 
      }
     */
      
      /*
      stage("Sonar Analysis ") {
        agent any
            steps {
                withSonarQubeEnv('SonarTiss'){
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    sh "mvn -B clean deploy sonar:sonar"
                }
            }
        }
       */ 
              
        stage ("Quality Gate ") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
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