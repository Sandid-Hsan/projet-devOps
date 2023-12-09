pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Sandid-Hsan/projet-devOps/']])
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('SonarQube analysis') {
            steps {
                script {
                    withSonarQubeEnv('sonar-mongo') {
                        sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                    }
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t myapp .'
                }
            }
        }
        stage('Push image to DockerHub') {
            steps {
                script {
                    withCredentials([
                        usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')
                        ]){
                             sh "docker login -u $USER -p $PWD"
                             sh "docker tag myapp:latest hassensandid/spring-app:latest"
                             sh "docker push hassensandid/spring-app:latest"
                          }
                }
            }
        }
        stage('Deploy to Minikube') {
            agent any
            steps {
                script {
                    def kubeconfigCredentialId = 'mykubeconfig'
                    withCredentials([file(credentialsId: kubeconfigCredentialId, variable: 'KUBECONFIG')]) {
                        sh "kubectl apply -f /home/sandid/mongo-demo/Kubernetes/spring-app-deployment.yaml"
                    }
                }
            }
        }
    }
}
