def call(){
    sh 'docker stop youtube2'
    sh 'docker rm youtube2'
}
