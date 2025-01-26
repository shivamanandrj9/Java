## Types of Software Testing ##

1) Unit Testing: Focus on smallest unit, like loops, methods or function.

2) Integration Testing: Focus on integration of multiple components output, like validation or verification.

3) Regression Testing: Focus on whole component or module works properly.

4) Stress Testing: Checks different system, load and performance of the application.


## Annotations ##

### @Test ###
1. We put this to identify that this method contains a testcase and will run this method and after successful execution of this method, this testcase will be considered passed.
2. These methods should be public.
3. We can use parameter (expected = Exception.class) to test if the testcase is throwing exception or not. 
4. (timeout = 5000), this parameter helps in testing if the method is taking longer than given time(here 5000).
5. 

### @Before ###
This method runs before running any of the testcases in that class.

### @After ###
This method runs after running any of the testcases in that class.

### @BeforeClass ###
1. This method runs only once before running any of the testcases present in that class.
2. This method should be public static.

### @AfterClass ###
1. This method runs only once before running any of the testcases present in that class.
2. This method should be public static.

### @Ignore ###
1. This will ignore the annoted testcase or method.
2. A class level @Ignore will ignore all the test cases of that class.

### @RunWith ###
1. We can use this to run parameterized test that means we can have set of parameters and the testcase will run that many number of time with those parameters.
2. @RunWith(Parameterized.class) this marks the class as parameterized class.
3. Create an instance variable for each "column" of test data(here param1 and param2). i.e. create variables that need to be put inside each testcase.
4. @Parameterized.Parameters is put above the method that is going to provide us with the parameters in the form of list. The values inside the list will be passed down to the constructor to initialize those parameters. It should be public static method.
5. Create a public constructor that takes in what is equivalent to one "row" of test data i.e each item of the list that was put in @Parameterized.Parameters annotated method. You can use this row to initialize the parameters.
