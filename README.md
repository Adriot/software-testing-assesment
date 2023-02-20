# software-testing-assesment

1. Cloning: git clone https://github.com/Adriot/software-testing-assesment.git

2. Import the project on the directory: automationSolution

3. Run: mvn clean install

4. Run Test: mvn test -Dtest="AddProductsToCarAndCheckoutRunner"

5. Get Report from: /target/cucumber-reports/swaglabs/Add Products To Cart And Checkout.html

# Jenkins

1. Download and install jenkins

2. Setup a multi-branch piprline:
    - Repository Source: https://github.com/Adriot/software-testing-assesment.git
    - Set the jenkinsfile path to: automationSolution/Jenkinsfile
    - Manualy run the job
    
    Please ensure that you setup plugins for maven, and cucumber (including ports).
