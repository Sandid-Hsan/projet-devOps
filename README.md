In this project, We established a fully automated Continuous Integration/Continuous Deployment (CI/CD) pipeline for a Spring Boot application hosted on Github.

Steps: 
1. Version Control:
    - Clone the Spring Boot application from the provided GitHub repository.

2. Continuous Integration (CI) with Jenkins:
    - Set up a Jenkins pipeline that triggers on each code commit.
    - Configure Jenkins to clone the repository, initiate the build process, and execute automated tests on the Spring Boot application.

3. Dockerization:
    - Implement a Docker build step within the Jenkins pipeline to create container images from the Spring Boot application.
    - Push the built Docker image to a private Docker registry to securely manage and store container images.

4. Private Registry Authentication in Jenkins:
    - Configure Jenkins to authenticate and securely pull the Docker image from the private registry.
    - Implement proper authentication mechanisms to ensure secure retrieval of container images during the deployment process.

5. Database Connectivity with Docker Compose:
    - Utilize Docker Compose to define and manage a multi-container Docker environment.
    - Set up a Dockerized environment that includes the Spring Boot application and a MongoDB database.
    - Implement data persistence for MongoDB using Docker Compose to ensure that data is preserved across container restarts.

6. Container Orchestration with Kubernetes:
    - Integrate Kubernetes into the pipeline for container orchestration.

7. Code Quality Analysis with SonarQube:
    - Incorporate SonarQube into the Jenkins pipeline for continuous code quality assessment.
  