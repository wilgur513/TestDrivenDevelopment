node('master') {
  checkout scm
  stage('Build') {
    sh "echo 'Build Start'"
    withMaven(maven: 'M3') {
      sh 'mvn -Dmaven.test.failuer.ignore clean package' 
    }
  }
  stage('Results') {
    sh "echo 'Results Start'"
    junit '**/target/surefire-reports/TEST-*.xml'
    archive 'target/*.jar'
  }
}
