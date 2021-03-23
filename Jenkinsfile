pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos' 
    gradle 'Gradle5.6_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
	 checkout([
		$class: 'GitSCM',
		branches: [[name: '*/main']],
		doGenerateSubmoduleConfigurations: false,
		extensions: [],
		gitTool: 'Default',
		submoduleCfg: [],
		userRemoteConfigs: [[
		credentialsId: 'Github_karenLopez',
		url:'https://github.com/karenlopezceiba/coworking.git'
		]]
		])     
      	}
    }
	
    stage('clean') {
      steps{
        echo "------------>Clean<------------"
        sh 'gradle --b ./microservicio/build.gradle clean'
      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
	sh 'gradle --b ./build.gradle compileJava'
        sh 'gradle --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
          withSonarQubeEnv('Sonar') {
		sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
	  }
      }
    }

    stage('Build') {
	  steps{
	  echo "------------>Build<------------"
          sh 'gradle build -x test'
  	}
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
	  echo 'This will run only if failed'
	  mail (to: 'karen.lopez@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
	}
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
