# Notes for class July 24th

## Discussion
### Assignment 4
- Program for a simulated PC that can do a few different operations


### Midterm Review

Abstraction
- Hide the things you don't need to know about
- Expose the things they need to use

Encapsulation
- Abstraction and encapsulation
- Hide the things you don't need to see
- Hide design decisions

Modularity
- Localizing the idea to a single place

Coupling

Cohesive
- Works together nicely
- Works to solve problems well


Strategy pattern
- groups together a family of algorithms
- can choose methods at run time

Using design patterss DOES NOT mean your code will be shorter


Interface or class is not necessary for the strategy pattern

Program to an interface not an implementation

Advantages to observer pattern
- Hollywood principle
    - they call us, we don't call them
- Loosely coupling

abstract observer, abstract subject class


Conceptual modelling
- easier to change in design
- Documentation
- Communication
- Solving problems
- helps understand domain
- visulization

Why favor composition
- More flexible
- Don't end up with fewer classes necesarrily
- doesn't usually end up affecting performance


Class Explosion
- A lot of subclasses with slight variations
- Combination of features
- Solved by decorator pattern
- Also favoring composition

Classes should be open for extension but closed for modification


All good software systems don't necessarily implement the open closed principle everywhere


Overall goal of software engineering
- In Budget
- On Time
- High Quality


Modularity
- Localization of design decisions
- coupling


New keyword violates the interface principle
- can be helped by the factory pattern

Factory PAttern
- encapsulate object instantiation


Simple Factory idiom
- not considered a pattern
    - Not the same in every language
    - implementation is going to vary
- Not due to not being used. This idiom is used in many ways.


Singleton Pattern
- One Instance
- NOT THREAD SAFE
- Unit Tests are rough in singleton

Global variables
- can't control who and when writes to them
- hard to test
- very tightly coupled....


Long Method
- method that does too many things
- Method that solves more than one thing


[Main Notes Page](/Notes/mainNotes.md)