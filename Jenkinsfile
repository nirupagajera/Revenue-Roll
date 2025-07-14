pipeline
{
  agent any
  stages
  {
    stage('build')
    {
      steps
      {
        echo "Build Process is completed successfully."
        bat "mvn clean"
      }
    }

    stage('test')
    {
      steps
      {
        echo "Test Process is completed successfully."
        bat "mvn test"
      }
    }

    stage('compile')
    {
      steps
      {
        echo "Compile Process is completed successfully."
        bat "mvn compile"
      }
    }

    stage('deploy')
    {
      steps
      {
        echo "Deploy Process is completed successfully."
      }
    }
    
  }
  
}
