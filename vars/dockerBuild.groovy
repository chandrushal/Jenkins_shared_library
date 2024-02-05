def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker buildx install"
    sh "docker buildx version"
    sh "docker buildx create --use"
    sh "docker buildx build --build-arg REACT_APP_RAPID_API_KEY=c1739b9755msh560c0c819a18c28p1a18a4jsnc6077673e214 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://hub.docker.com/repositories/shalinichandru', credentialsId: 'docker-hub']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
