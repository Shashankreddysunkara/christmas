node('java8') {
    withCredentials(
        [usernamePassword(
         credentialsId: 'artifactory-credentials',
         passwordVariable: 'ARTIFACTORY_ENCRYPTED_PASSWORD',
         usernameVariable: 'ARTIFACTORY_USERNAME')]) {

        env.PATH = "${tool 'M3'}/bin:${env.PATH}"

        stage ('Checkout'){
              checkout([$class: 'GitSCM',
              branches: [[name: '*/master']],
              doGenerateSubmoduleConfigurations: false,
              extensions: [],
              submoduleCfg: [],
              userRemoteConfigs: [[credentialsId: 'git-credentials', url: 'https://github.deere.com/JDCP/jdcp-microservice-parent.git']]])
        }

        stage ('Build') {
            sh 'mvn -U -s settings.xml -gs settings.xml clean install'
        }

        stage('Publish Artifacts') {
            sh 'mvn -U -s settings.xml -gs settings.xml deploy'
        }
    }
}
