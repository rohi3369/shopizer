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
            sh 'git checkout release'
            sh 'git merge develop --no-ff'
            sh 'git push origin release'

         }
    }  
    
}