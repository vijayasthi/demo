pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat --no-daemon --warning-mode all'
		bat './gradlew build'
		bat './gradlew clean build -x test'
		//bat './gradlew clean build -x test -x integTest'
            }
		}
        stage('unitTest') {
            steps {
                echo 'Test build automation'
		bat './gradlew test'
			}
		}
	stage('e2eTest') {
            steps {
                echo 'Test e2e build automation'
		//bat './gradlew test'
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
