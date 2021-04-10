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

      
      stage('Maven Package'){
		steps{
			echo 'Project packaging stage'			
			bat label: 'Project packaging', script: '''mvn package'''
		}
	} 
	
  }
}