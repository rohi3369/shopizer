pipeline {
    agent {label 'merge'}
    triggers {
           cron('* 17 * * *')
    }
    stages {
        stage ('vcs') {
            steps{
                git branch: 'master',
                url: 'git@github.com:rohi3369/shopizer.git'
            }
        } 
         stage('merge'){
            steps{
            sh 'git checkout develop'      
            sh 'git checkout release'
            sh 'git merge develop --no-ff'
            sh 'git push -u origin release'
            }
        }
    }  
    
}
