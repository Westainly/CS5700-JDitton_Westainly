# Class Notes June 25

## Discussions
- Code Reviews
    - Don't fall in love with your code
    - The best way is always changing
    - There is always going to be a better way
- 4Ps
    - Principles
    - Practices
    - Patterns
    - Pitfalls

- Requirements change
    - can something be null? Maybe not now, but maybe later


- Mission Statement of Software Engineer
    - High quality software, on-time and within budget


## Principles
- Abstraction
    - Open for extension, but closed for modification
    - In design, is when you change your abstraction
    - What you can or cannot do with a function
    - what is the public portions
    - How can you change it?
    - happens at all layers
        - functions
            - arguments
                - forced types
            - return value
                - Forced types on returns
                - If you return a string, it should never change
        - variables
        - classes
    - Bad abstraction is when you don't have the information needed for a function explicitly stated
- Modularity
- Encapsulation

## Practices

## Patterns
- Factory
- Observer
- Strategy
- Iterator
- Flyway


# Kotlin
- JDK-21
- Using gradle

## Variables
- declarations
    - val: final/const
    - var: variable
- Type inference
- type system is almost the same as java
- ?: elvis operator if it resolves to null, it will then perform the operator on the right.  printName(name ?: "anonymous")

## Functions
- functions can be bare

## Loops
- No for loop in kotlin
    - Only has "for each" loop
    - until is up to and not including
    - .. is up to inclusive
- while loops are the same as most languages

# Modelling
- Outline or scale of something
- Abstraction of the code
- Higher level view of something more concrete
- Clay model of vehicles
- Easier to fix things in the conceptual model than it is in the "concrete code"

## UML
- Unified Modeling Language
- using + means it's public
    - has public getter and setter
    - No need to put down getters and setters
- using - means it's private
- Does your diagram communicate the intent of the final product
    - make it look nice
    - will you understand it in a week
    - what about a month



-------------
Name of object
-------------
what it is
- variables
-------------
What it does
- behaviors
- functions
- returns
-------------

Arrows tell relationship
- Big open arrow is inheritance
- reads in present tense
    - Student -> extends -> User
    - only put the things in an inherited class that are specific to it.




[Main Notes Page](/Notes/mainNotes.md)