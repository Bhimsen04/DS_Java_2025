Creational: Singleton, Factory, Builder, Prototype
Structural: Adapter, Decorator, Facade, Proxy
Behavioral: Strategy, Observer, Template, Chain of Responsibility, State, Command

Design Patterns:
    CREATIONAL PATTERNS: Used to create objects in a flexible way.
        Singleton: One instance for entire application (DB connection pool, cache).
        Factory: Create objects without exposing logic to the client.
        Builder: Build complex objects step-by-step.
        Prototype Pattern: Clone existing objects (deep copy). In Spring apps, sometimes heavy objects (like DTO templates, request payload templates) are cached as prototypes.
        
    STRUCTURAL PATTERNS: Used to combine or structure classes.
        Adapter Pattern : Convert one interface into another
        Decorator Pattern : Add features to an object dynamically at runtime without modifying class.
        Facade Pattern : Provides a simple interface over a complex subsystem.
        Proxy Pattern : Add a layer around object access.
    
    BEHAVIORAL PATTERNS: Used to handle interactions between objects.
        Strategy Pattern : Allows switch between multiple algorithms/behaviors at runtime without changing the main logic.
        Observer Pattern : Notify subscribers when state changes.
        Template Method Pattern : Skeleton of algorithm; subclasses override only required steps.
        Chain of Responsibility Pattern : Pass request through handlers.
        State Pattern : Encapsulate request as an object.
        Command Pattern : The Command Pattern converts a request into a standalone object
