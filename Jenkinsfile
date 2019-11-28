pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat --no-daemon --warning-mode all'
            }
		}
        stage('Test') {
            steps {
                echo 'Test build automation'
			}
		}
	stage('Archive') {
            steps {
                echo 'Test build automation'
		//bat 'C:/jfrog-artifactory-oss-6.15.0/artifactory-oss-6.15.0 jfrog rt u "build/*.zip" jenkins-release/zipFiles/'
		rtUpload (
    serverId: 'Artifactory 6.15.0',
    spec: '''{
          "files": [
            {
              "pattern": ""build/*.zip",
              "target": "jenkins-release/zipFiles/"
            }
         ]
    }''',
 
    // Optional - Associate the uploaded files with the following custom build name and build number,
    // as build artifacts.
    // If not set, the files will be associated with the default build name and build number (i.e the
    // the Jenkins job name and number).
    buildName: 'holyFrog',
    buildNumber: '42'
)
			}
		}
	}
	    post {
        success {
            echo 'I succeeeded!'
	    echo "Succeeded Pipeline: ${currentBuild.fullDisplayName}"
            echo "${env.BUILD_URL}"
        }
        failure {
            echo 'I failed :('
	    echo "Failed Pipeline: ${currentBuild.fullDisplayName}"
            echo "${env.BUILD_URL}"
        }
    }
}
