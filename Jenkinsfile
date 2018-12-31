node('java8') {
        stage('Checkout') {
              checkout scm
        }

        stage('Build') {
            sh 'mvn -U -s settings.xml clean install'
        }

        stage('Publish Artifacts') {
            sh 'mvn -U -s settings.xml deploy'
        }
}
