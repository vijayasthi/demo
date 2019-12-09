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
        		withSonarQubeEnv('sonarqube-server') {
            		//bat "${scannerHome}/bin/sonar-scanner"
				//C:\sonar-scanner-cli-4.2.0.1873-windows\sonar-scanner-4.2.0.1873-windows\bin
			bat 'C:/sonar-scanner-cli-4.2.0.1873-windows/sonar-scanner-4.2.0.1873-windows/bin/sonar-scanner \
  		-Dsonar.projectKey=demoproject \
  		-Dsonar.host.url=http://localhost:9000 \
  		-Dsonar.login=378a17da3005b6b711b99d4bae3bd20b0b179079 \
		-Dsonar.sources="C:/Program Files (x86)/Jenkins/workspace/demo_master/src/main/java"'
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
              				"pattern": "C:/Program Files (x86)/Jenkins/workspace/demo_master/build/distributions",
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
