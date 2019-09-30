[![Build Status](https://travis-ci.com/elletamara/kotlin-tic-tac-toe.svg?branch=master)](https://travis-ci.com/elletamara/kotlin-tic-tac-toe)
# Kotlin Tic Tac Toe 

- A Kotlin application, which allows the user to play Tic Tac Toe on the command line.
- The user can select from various player types: human, easy computer or unbeatable computer.

## Getting Started

This application has been created with [Kotlin 1.3.50](https://kotlinlang.org/), using [Gradle](https://docs.gradle.org/current/userguide/what_is_gradle.html) for build automation.

- Install [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- In your terminal, type the following:

```
git clone https://github.com/elletamara/kotlin-tic-tac-toe.git
cd kotlin-tic-tac-toe
./gradlew clean build
./gradlew --console plain run
```

## Game Play

### Game Mode Selection
- When starting the application, the user is prompted to enter their player type choices for both players
- The user can select from the following player types:
    - Human - the player will be prompted to select a move by entering 1 - 9
    - Easy - a computer player, which selects an available move at random
    - Unbeatable - a computer player, which uses the minimax algorithm to select an optimum move

## Testing
- The testing framework used is [JUnit 5](https://junit.org/junit5/).
- Tests can be run by typing `./gradlew clean test` in your terminal

### Test Coverage
The test coverage report can be found here: `./build/reports/tests/test/index.html.`

### Mocking
[MockK](https://github.com/mockk/mockk) (a mocking library) is used to mock input and output in the tests.

