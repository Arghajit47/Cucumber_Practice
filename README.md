BDD :- Behaviour Driven Development

In traditional Development Process;

1. Stakeholders tells Product owners/ Business Analyst about the business requirement.
2. PO/BA Writes the requirements.
3. Developer team Starts writing the Code.
4. Testers starts writing Test Cases.
5. Finish Product.
6. Tech Writters write the documentations.

But in BDD methodology/ Framework;

1. Stakeholders and PO/BA talks about the business requirement.
2. PO+DEV+QA Collaborate around requirement ( These 3 are together called Amigo).
3. Agreed upon requirement defined as Emglish formatted Scenarios(Gherkin)
	{Given................}
	{When.................}
	{Then...................}
4. QA team uses these scenarios for Automated tests.
5. Developer uses Scenarios for Automated Tests.
6. Automated Test Report generated against Features/ Scenarios.
7. Finish Product.
8. Tech Writters write the documentations.

As we can see, in BDD framework there is superior collaboration.

Difference between TDD, BDD, ATDD:- 

TDD:- 

1. TDD is Development Centric Approach.
2. Unit Test (White Box Tetsing)
3. Write Test Cases before code is written.
4. Test first Approach.
5. Key Focus will be is code working correctly or not.
6. Mostly done by the Developers.









BDD:- 

1. BDD is an extension of TDD.



2. Works on higher level of abstraction as compared to TDD.
3. Always need to cover all possible scenarios.
4. Test first approach.
5. Participants will be three Amigos (QA, DEV, BA/PO)









ATDD:-

1. Higher level abstraction as compared to BDD/TDD.
2. Focus on high level requirement .
3. Authors:- PO/BA





















What is POM:- 

	Design pattern to create Object Repository. A class is created for each page to identify web elements of that page. Also contains methods to do action on the obejct.

Advantages in POM:- 

1. Makes code maintainable
2. Chnages and updates are easier
3. Makes code reusable
4. Improves readability
5. Provides a kind of Objects documentation at a single place
6. Saves time and efforts
7. Avoid rework
8. Makes tests less brittle
9. New tests creation is easier and faster
10. Improves overall quality and efficiency

Page Factory:-

A simple and easier implementation of Page Object Model in Selenium

Selenium's inbuilt and optimized Page Object Model concept

As POM , has separation of objects and tests


Uses annotation @FindBy to find WebElements
@FindBy can use id , name , css , xpath , tagName , linkText , partialLinkText etc

Uses method initElements to initialize web elements
on calling initElements method all objects on that page gets initialized


What are HOOKS:-

Blocks of code that runs before OR after each scenario
Hooks in Cucumber are like Listeners in TestNG
Can define hooks by using annotations @Before @After
Scenario Hooks
-
runs before and after each scenario
Step Hooks runs before and after each step
Conditional Hooks - hooks associated with tags for conditional execution

How to use HOOKS
Step 1 - Create a new or use an existing Feature File
Step 2 - Create the steps for the scenario in the feature file
Step 3 - Create setup and teardown methods and mark with annotation
@Before
@After
@BeforeSteps
@AfterSteps
