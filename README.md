[![Build Status][travis-badge]][travis-badge-url]


Activiti Developer Quickstart
===============================
This is a quick start example of [Activiti](https://www.activiti.org) 
Business Process Management (BPM) engine shown [here](https://www.activiti.org/quick-start).

This is an example which creates Activiti Process Engine using a memory-based h2 embedded database.
It loads a simple `onboarding.bpmn20.xml` BPMN model and deploys it to the Activiti Process Engine.

The process prompts for user name and experience. If the years of experience is above 3, a task for a 
personalized onboarding welcome message is issued. The task prompts the user to manually enter data into 
a faux backend system. If the years of experience is 3 years or below, it automatically integrates data
with a faux backend system.

### Build
Execute the following command from the parent directory to build the project:
```
mvn clean install
```

### Run
To run the application from the terminal,
```
java -jar target/activiti-developer-quickstart-1.0.0-SNAPSHOT-full.jar 
```

You should notice the application starting:
```
ProcessEngine [default] Version: [6.0.0.4]
Found process definition [Onboarding] with id [onboarding:1:4]
Onboarding process started with process instance id [5] key [onboarding]
Active outstanding tasks: [1]
Processing Task [Enter Data]
Full Name?
```

When prompted for name, enter a name. For example, Jane Doe and hit return.

```
Full Name?
Jane Doe
Years of Experience? (Must be a whole number)
```
When prompted for experience, enter 3.

```
Years of Experience? (Must be a whole number)
3
Faux call to backend for [Jane Doe]
-- Start [startOnboarding] 1 ms
-- Enter Data [enterOnboardingData] 137704 ms
-- Years of Experience [decision] 4 ms
-- Generic and Automated Data Entry [automatedIntro] 1 ms
-- End [endOnboarding] 1 ms
```

You should notice the Java service class `AutomatedDataDelegate` being called. 
It prints out the following message.

```
Faux call to backend for [Jane Doe]
```

[travis-badge]: https://travis-ci.org/indrabasak/activiti-developer-quickstart.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/activiti-developer-quickstart/