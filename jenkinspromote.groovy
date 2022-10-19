pipeline {
    agent any
    triggers {
           cron('* 17 * * *')
    }
    stages {
        stage ('vcs') {
            steps{
                git url: 'https://github.com/rohi3369/shopizer.git'
                 git branch: 'promote'          
            }
        } 
         stage('merge'){
            steps{
            sh 'git pull --all'
            sh 'git checkout release'
            sh 'git merge origin/develop --no-ff'
            sh 'git push -u origin release'
            }
        }
    }  
    
}