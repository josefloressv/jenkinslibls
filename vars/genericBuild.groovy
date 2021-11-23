def call(Map config=[:]) {
    node {
        stage('SCM') {
            echo 'Gathering code from version control'
            git branch: 'main', url: 'https://github.com/josefloressv/simple-maven-project-with-tests.git'
        }
        stage('Build') {
            try {
                echo 'Building project'
            } catch (e) {
                echo 'Build failed'
                throw e
            }
        }
        stage('Test') {
            echo 'Testing project'
        }
        stage('Deploy') {
            echo 'Deploying artifacts'
            createReleaseNotesFile changes : "false"
        }
    }
}