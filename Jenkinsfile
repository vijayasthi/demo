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
		bat 'jfrog rt u "build/*.zip" jenkins-release/zipFiles/'
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
