SA UI Aautomation Testing
===================================

This testing script is designed for mornitoring if every elements or every step of the SA UI working fine.
Start testing script, it will invoke the browser and http://shoesize.me/plugin_v3, then pass params and starts all testing routs and steps according the designed schema.
This testing script is a Maven project and writen with Java, selenium, testNg.

### Build

- Clone or download the project.
- Make sure you have Java 11 and Maven 3 installed on your system.
- In order to run tests in browser make sure you have geckodriver(chromedriver undetermined) and it is accessibile(different on linux and windows).
  in Linux OS family it would be in /usr/bin/ for example.
  in Windows OS family you should export your chromedriver localization to system path.
- It is a Maven project, it will automaticlly install all Maven dependencies into your project.

### Run test in local

- Run a certain test for a shop---Run with test method name, e.g., test(1),test(2).

- Run a test suit for certain shop---Run with target shop test suit xml file, e.g.,com.shoesizeme.sa.ui.tester.shoeshelf_cleaner.xml,

- Run all tests for all shops---Run with customTestSuite.xml / Run "mvn test" to excute all the package under "com.shoesizeme.sa.ui.tester"

### Trigger remote test from IDEA

This testing script is designed for mornitoring if every elements or every step of the SA UI working fine.

```bash
wget --no-check-certificate --auth-no-challenge --user=****** --password=****** \
"https://jenkins-lb-1367987599.eu-central-1.elb.amazonaws.com/job/ssm_sa_ui_testing/buildWithParameters?token=ssm2o2o&TEST_SUITE_FILES=./tests/******.xml"
```

or for present "note" in Jekins,append "cause" in the end of the file name

 ```bash
 ......&TEST_SUITE_FILES=./tests/lkbennett.xml&cause=LK_Bennett
 ```

### Trigger remote test from jekins

By change default value named with .xml file, build with dev branch by default.
List of TestNG XML suite files separated by comma. Example value: ./tests/shop_a.xml,/tests/shop_b.xml
tests :
./tests/customTestSuite.xml---adult test
./tests/ccustomTestSuit_kids.xml---kids shoe
./tests/shoeshelf_cleaner.xml---help delete shoes from shoeshelf in case filled too many shoe in the shoeshelf caused by too many failed test


### Test result

We would not get all test past for a big test(all shops for adult) due to ram, DOM randering, selenium itself or some expetion or the code error.
Normally it should be good  if there are around 90% test past.
- The test will generate a table with all test and failed in "TestNG Results".
