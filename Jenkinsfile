pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat --no-daemon --warning-mode all'
		//bat './gradlew clean build'
		bat './gradlew clean build -x test'
            }
		}
        stage('Test') {
            steps {
                echo 'Test build automation'
		bat './gradlew test'
			}
		}
	stage('Sonarqube') {
		environment {
        		scannerHome = tool 'SonarQubeScanner'
    				}
    		steps {
        		withSonarQubeEnv('sonarqube') {
            		sh "${scannerHome}/bin/sonar-scanner"
        		}
		    }
		}
	stage('Publish') {
            steps {
                echo 'Test publish automation'
		//bat 'C:/jfrog-artifactory-oss-6.15.0/artifactory-oss-6.15.0 jfrog rt u "build/*.zip" jenkins-release/zipFiles/'
		//    "target": "jenkins-release/zipFiles/${env.BUILD_NUMBER}/"
		rtUpload (
    			serverId: 'Artifactory 6.15.0',
    			spec: '''{
          			"files": [
            				{
              				"pattern": "C:/Users/vasthi/demo/build/distributions/",
					"target": "jenkins-release/zipFiles/${env.BUILD_NUMBER}/"
            				}
         				]
    				}'''
				)
		}
		}
	}
	post {
	always {
            junit 'build/test-results/test/*.xml'
        }
        success {
            echo 'I succeeeded!'
	    echo "Succeeded Pipeline: ${currentBuild.fullDisplayName}"
            echo "${env.BUILD_URL}"
	    echo "${env.BUILD_NUMBER}"
        }
        failure {
            echo 'I failed :('
	    echo "Failed Pipeline: ${currentBuild.fullDisplayName}"
            echo "${env.BUILD_URL}"
        }
    }
}
