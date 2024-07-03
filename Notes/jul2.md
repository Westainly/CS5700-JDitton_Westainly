# Class Notes July 2nd

## Code Reviews
- Design is going to get the most attention
- Git will be looked at, but not much attention
- Code and testing will be looked at and run. That's about it
- Running on my machine

## Discussions
- What your software does/ what it needs
- How you software works -> Changes more often usually.


### Modularity
- Localization of design decisions
    - one class should have 1 responsibility
- Coupling
    - Open for extension, closed for modification
        - insulate yourself from having to make changes if something changes down the road.
        - Deleting is different from modification.
            - deleting can be a very good and needed thing.
            - modifying is when you take an already existing class or function and have to change it due to something you are using or need changes.
- Cohesion
    - How nice do classes and functions fit and work together.
        - Are they working together for a common goal?
        - I have a thing that needs posts, so I have a thing that gets posts.
    - Do the functions feel like they are in the right place?
    - Do the functions seem like they need to be split up?

- If you depend on an object that you don't absolutely need, that adds room for changes to affect the system.
    - You don't need objects/classes that do more than you really need.

- How do you reduce the coupling to increase usability.

### Encapsulation
- You want to hide your design principles.

### Strategy Pattern
- Hide business logic away from user
- You are able to pick strategies at runtime
- Your code reaches out to the code and grabs it when needed

### Observer Pattern
- Have the thing that is changing tell the things that it is changing
- Don't pull from the changing object
    - This can cause overuse
    - Also could cause not updating enough
- Hollywood style
    - We call you, you don't call us.


[Main Notes Page](/Notes/mainNotes.md)