# Class Notes July 9th

## Discussion

### Code reviews
- Impressed with most things
- Grades are not final when they get posted, but may get shifted slightly later.

### Assignment 2
- UI
    - As long as it works, that's all.
    - It can't be outright ugly

- view helper is going to deal with the shipments

- Observer pattern is big in this upcoming assignment

### Observer Pattern
- It is easier to react to something than be proactive about something
- Almost all UI components are going to be reactive, not proactive
- Adding some complexity to a design can make it easier to work with in implementation
    - Simple is not always necesarrily better
- A lot of observer patterns are implemented in UI's

- Observers don't NEED to do anything with the data they receive.
    - Some observers may need some of the data not all
    - Subjects also don't care if the observer is using the data

- The fewer places you can instantiate objects, the better off you'll be

#### Simple observer
- ties 2 concrete objects together
- one object needs to know when 1 other object changes
- really simple to implement, but not great for extending...



### Decorator Pattern
- Python decorators
- Seen a lot in industry but almost never in the textbook form
- decorator and class have to have the same abstraction.
- user doesn't care if they are using decorator or real thing


[Main Notes Page](/Notes/mainNotes.md)