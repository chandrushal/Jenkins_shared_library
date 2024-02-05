def call() {
    sh 'trivy image shalinichandru/youtube:latest > trivyimage.txt'
}
