node('master') {
        stage('Checkout') {
              checkout([$class: 'GitSCM', branches: [[name: '*/master2']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/shashankreddysunkara/christmas.git']]])
        }

        stage('Build') {
            sh 'mvn clean install'
        }

        stage('Publish Artifacts') {
            sh 'mvn deploy'
        }
}
