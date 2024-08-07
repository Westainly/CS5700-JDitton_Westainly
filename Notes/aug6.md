# Review for Final Exam
30 questions

open note, book, "Internet" you really shouldn't need the internet....

Cumulative: 80 from after midterm 20 from before

Couple of repeats from midterm

## Encapsulation
- Hiding design decisions

## Modularity
- Localizing design decisions
    - reduces coupling and increases cohesion

## Abstraction
- An abstraction is any componennt of a system that has an interface to be used by anything else in the system.
- Any public methods or attributes(Should be no public attributes(poor encapsulation))
- Everything should be explicitly declared

## Common phrases
- Favor composition over inheritance
- seperate the things that vary from the things that stay the same
- Program to an interface rather than an implementation
- Loosley coupled designs between components that interact

## Hollywood Principle
- Don't call us we'll call you
- Observer Pattern

## Dependency Inversion Principle
- Anything in a system should only depend on things as abstract or more abstract than it
- Also applies on a architecture level as well

## Command Pattern
- Looks like strategy
- Three parts
    - Invoker/Controller
    - Commands/Executor
    - Reciever of command, what the command is operating on

## Iterator Pattern
- Deals with encapsulation
    - Encapsulates iteration, one place for loops
- Iterating without the iterator pattern has to be different for each type of object.
- Usually baked into programming languages now

## Template Method Pattern
- Encapsulates Algorithms
    - a set of steps to accomplish but steps could be different
- Primitive Method
    - Has to be overriden by subclass
- Hook Method
    - Optional to override by subclass
    - Default implementation

## Facade Pattern
- Hides things away :D
- Makes a complex subsystem easier to use
- You have one object very tightly coupled to everything in the subsystem
- Reduces coupling is the goal
- Can be good for abstraction
- Mostly for encapsulation
- Usually end up with a big class with a lot of methods.

## State Pattern
- Looks like the strategy pattern
- Intent is the difference between the two
- Used to represent changes in the program
- Solid black circle represents the start
- Rounded blobs represent the states
- Lines represent the actions
- Supports principles:
    - Interface not implementation
    - Single responsibility principle
    - Open Closed
    - Dependency inversion
    - Seperating the things that vary
- All software is stateful

- Context object : thing that holds the state
- Any one of the states might result in a new state replacing it

