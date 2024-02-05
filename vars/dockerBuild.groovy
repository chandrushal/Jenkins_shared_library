def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
   // sh "docker buildx install"
    //sh "docker buildx version"
    //sh "docker buildx create --use"
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=c1739b9755msh560c0c819a18c28p1a18a4jsnc6077673e214 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-hub']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
