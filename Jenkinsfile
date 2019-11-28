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
