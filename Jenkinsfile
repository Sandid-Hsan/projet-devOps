pipeline {
    agent any
    stages {
        stage('SonarQube analysis') {
            steps {
                script {
                    withSonarQubeEnv('GTE3-sonar') {
                        sh 'mvn clean install -DskipTests'
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
                             sh "docker tag myapp:latest ahmedamin1998/tp-devops:latest"
                             sh "docker push ahmedamin1998/tp-devops:latest"
                          }
                }
            }
        }
        stage('Deploy to Minikube') {
            agent any
            steps {
                script {
                    // Define the Kubernetes configuration credentials
                    def kubeconfigCredentialId = 'mykubeconfig'
                    // Use withCredentials to set KUBECONFIG from the credential file
                    withCredentials([file(credentialsId: kubeconfigCredentialId, variable: 'KUBECONFIG')]) {
                        sh "kubectl apply -f /home/amine/mongo-project/Kubernetes/spring-app-deployment.yaml"
                    }
                }
            }
        }
    }
}