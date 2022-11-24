pipeline{
    agent any
    
    stages {
        stage('continuous download') {
            steps {
                git 'https://github.com/Varsha28jan/Jeknins_Student_App.git'
            }
               
        }
        stage('continuous build') {
            steps {
                sh 'mvn package'
            }
            }
            
            }
            }
