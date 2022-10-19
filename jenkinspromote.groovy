pipeline {
    agent any
    triggers {
           cron('* 17 * * *')
    }
    stages {
        stage ('vcs') {
            steps{
                git url: 'https://github.com/rohi3369/shopizer.git'
            }
        } 
         stage('merge'){
            sh 'git pull --all'
            sh 'git add .'
            sh  'git commit -m "added jenkins file"'
            sh  'gi push --all'

         }
    }  
    
}