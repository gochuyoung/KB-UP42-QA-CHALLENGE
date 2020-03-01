## About The Project

Case study for the QA Automation Engineer position at [UP42](https://up42.com)\
Done by Krzysztof Bursztynowicz


### Built With
List of main tools used in this project
* [Gradle](https://gradle.org/)
* [Spock](http://spockframework.org/spock/docs/1.3/index.html)
* [REST-assured](http://rest-assured.io/)


## How to run


### Prerequisites

Java 8+ installed

### Installation

1 Clone the repository
```sh
git clone https://github.com/gochuyoung/KB-UP42-QA-CHALLENGE.git
```
2 Provide 'api-key' and project-id' values into the config file
```sh
src/test/resources/config.yaml
```

3 Execute the following command in the main project directory
```sh
make test-exec
```

The implemented test case is located in the JobSpec.groovy file\
Project is divided into 5 sections: dtos, factories, services, utils and tests\
Configuration parameters can be set in /resources/config.yaml file

### Reports & logs
Report with all logs is generated in /reports directory, it contains the execution summary
and all generated logs\
Each report folder contains the execution timestamp in the name


## Project ownership

[Krzysztof Bursztynowicz](kbursztynowicz@protonmail.com)





