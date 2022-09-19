#!/usr/bin/env groovy

def call(){
    echo "Building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo',passwordVariable: 'PASS',usernameVariable: 'USER')]){
    sh 'docker build -t himanshupant4899/demo-app:jma-1.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push himanshupant4899/demo-app:jma-2.0'
}
}
