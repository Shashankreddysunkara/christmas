node {
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
