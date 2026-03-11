pipeline {

    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Checkout') {
            steps {
                
                git branch: 'main', url: 'https://github.com/Mafuj-dev/Event-Registration-System.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run JUnit Tests') {
            steps {
                bat 'mvn test'
            }
        }

       

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                bat 'copy target\\*.war "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\"'
            }
        }

        stage('Start Tomcat Server') {
    steps {
        bat '''
        set CATALINA_HOME=C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1
        %CATALINA_HOME%\\bin\\startup.bat
        '''
    }
}

    }
}
