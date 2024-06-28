# June 27 Class notes

# Assignments
- feedback assignments are anonymous

# Discussions

## Pitfalls
- Uncommunicative Names
    - variable and function names should tell you exactly what you need to know.
- Inconsistent Names
    - Naming Conventions need to be followed if they are in place
    - Past Tense vs Present Tense
    - Verbs for actions
- Types Embedded in Names
- Long Methods
    - Something with more than a single purpose
    - Complexity
    - Harder to test
- Duplicate Code
    - Has to be changed in multiple locations


## Unit Tests

- Unit tests make you think about use cases and edge cases
- 100% test coverage says nothing about the quality of tests

### Structure
- src
    - main
        - kotlin
            - Person.kt
        - resources
    - test
        - kotlin
            - PersonTest.kt
        - resources
    - build.gradle.kts
    gradle.properties


## Inheritance vs. Composition
- Always try to favor Composition/Aggregation over Inheritance

- Relationships / associations
- Types of relationships
    - Aggregation -- 
        - Open diamond in UML    Ledger <>----- Transactions   denotes  ledger has many transactions
            - Along the line, you also state how many of something is involved in the relationship
        - denotes a form of ownership
        - A course, has many students
        - User has an account
        - Not exclusive ownership

    - Composition
        - Black diamond in UML
        - My hand belongs to me, if I go away, then my hand goes away.
        - A plane has a cockpit. A cockpit is nothing without a plane, and a plane is nothing without a cockpit

- Types of Relationships
    - Has one
    - Has many


## Encapsulations
- If you see yourself copy pasting code, you most likely have poor encapsulation.
    - you do not want things spread across the software
    - Try to localize everything
- Strategy Pattern
    - Similar implementations that require minor differences between them.
    - All the shared logic is maintained in a single locations
    - needed logic for separate needs has added logic on top of the shared logic.

## Policy
- Program to an interface(abstraction) rather than an implementation.


[Main Notes Page](/Notes/mainNotes.md)