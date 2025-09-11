# Abstract Factory Pattern

Identification:
1. You need to create **families of related products** (e.g. different car models) without specifying their concrete classes.
2. You want to **switch entire product families** at runtime (e.g. economic vs. luxury variants).

What Abstract Factory ensures:
1. Client code depends only on **abstract interfaces**; factories and products can be interchanged without recompiling client code.
2. All creation logic for a family of products is **centralized** in one factory implementation.
3. Adding a new family (e.g. `SportCarFactory`) requires no changes to client code—just a new factory class.