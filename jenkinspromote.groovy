pipeline {
    agent any
    triggers {
           cron('* 17 * * *')
    }
    stages {
        stage ('vcs') {
            steps{
                git url: 'git@github.com:rohi3369/shopizer.git'
            }
        } 
         stage('merge'){
            steps{
            sh 'git checkout release'
            sh 'git merge origin/develop --no-ff'
            sh 'git push origin release'
            }
        }
    }  
    
}