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
       stage('SonarQube Analysis'){
		steps{		 		
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.analysis.mode= \
				-Dsonar.login=d51e7f6380a528b36cea3db64f4ee21870015682'''
			}
   		}
	*/
	
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
              
      /*
        stage ("Quality Gate ") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
      */
      /*
      stage ("SonarQube analysis") {
  		 steps {
      		withSonarQubeEnv('SonarQube') {
         		sh "../../../sonar-scanner-2.9.0.670/bin/sonar-scanner"   
      		}

      		def qualitygate = waitForQualityGate()
      		if (qualitygate.status != "OK") {
         		error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
      		}
   		 }
		}
	*/
      
   /*
       stage('SonarQube Analysis'){
		steps{		 		
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.analysis.mode= \
				-Dsonar.login=d51e7f6380a528b36cea3db64f4ee21870015682'''
			}
   		}
	
      
      stage("Quality Gate"){
    	steps {
        	script {
            	timeout(time: 1, unit: 'HOURS') {
                	def qg = waitForQualityGate()
                	if (qg.status != 'OK') {
                    	error "Pipeline aborted due to quality gate failure: ${qg.status}"
            	}
        	}
    	}
	  }
	}
      
   */
      
      
      stage('SonarQube Analysis') {
    	withSonarQubeEnv('My SonarQube Server') {
      	sh 'mvn clean package sonar:sonar'
    	} // SonarQube taskId is automatically attached to the pipeline context
  	}


// No need to occupy a node
stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
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