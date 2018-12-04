pipeline{
    agent any
    stages {
		// Checkout code from repository and update any submodules
        stage ('Checkout'){
            steps{
                  checkout([$class: 'GitSCM', 
				  branches: [[name: '*/master']], 
				  doGenerateSubmoduleConfigurations: false, 
				  extensions: [], 
				  submoduleCfg: [], 
				  userRemoteConfigs: [[url: 'https://github.com/YaraH92/CI-ClicktheDot.git']]])
            }
        }
		
		//build the app gradle
		stage ('Build'){
			steps{
				powershell "./gradlew assembleDebug"
				echo "bbbb"
			}
			echo "aaaa"
		}
	    
	    //tell Jenkins to archive the apks
		stage('Archive'){
			steps{
				archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
			}
		}
  		
    }
}
