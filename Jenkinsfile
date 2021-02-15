pipeline {
  agent {
    label 'master'
  }
  environment {
    GIT_CREDS = credentials('ssm-codebuild-git-credentials')
  }
  stages {
    stage('Build') {
      agent {
        dockerfile {
          filename 'Dockerfile.ssm_tester'
          additionalBuildArgs  '--build-arg UID=$(id -u) --build-arg GID=$(id -g) --build-arg USER_NAME=$(id -un) --build-arg GROUP_NAME=$(id -gn)'
          args '-v $HOME:/ssm_app -v /opt/ssm_jenkins_misc/java/.m2:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2'
          reuseNode true
        }
      }
      steps {
        sh "mvn clean compile -DskipTests=true"
      }
    }
    stage ('Test') {
      agent {
        dockerfile {
          filename 'Dockerfile.ssm_tester'
          additionalBuildArgs  '--build-arg UID=$(id -u) --build-arg GID=$(id -g) --build-arg USER_NAME=$(id -un) --build-arg GROUP_NAME=$(id -gn)'
          args '-v $HOME:/ssm_app -v /opt/ssm_jenkins_misc/java/.m2:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2 -e MOZ_HEADLESS=1'
          reuseNode true
        }
      }
      steps {
        sh "mvn test -DsuiteFiles=${params.TEST_SUITE_FILES}"
      }
      post {
        always {
          step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
      }
    }
  }
}
