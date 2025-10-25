# Abstract Factory Pattern

Identification:
1. You need to create **families of related products** (e.g. different car models) without specifying their concrete privateClasses.
2. You want to **switch entire product families** at runtime (e.g. economic vs. luxury variants).

What Abstract Factory ensures:
1. Client code depends only on **abstract interfaces**; factories and products can be interchanged without recompiling client code.
2. All creation logic for a family of products is **centralized** in one factory implementation.
3. Adding a new family (e.g. `SportCarFactory`) requires no changes to client code—just a new factory class.







# How to think

---

RULE OF THUMB: jaha kahi bhi multiple factories hain, try to thing of creating an interface for those factories and then there will be one abstract factory that will be returning that interface type and this abstract factory ka job will be ki konsa concrete factory dun.

---

Example 1: (Yaha hume 2 factories bananin padi)

There are multiple objects for an interface, here car interface have multiple privateClasses of cars.
We then identify any criteria on the basis of which they can be grouped here Economic cars can be grouped together and Luxury cars can be grouped together
Now since we have made the grouping, there will be seperate factory for each of this group. Basically agar tumhe is group ki car chahiye to ye factory se milega. To aisi humare paas 2 factories banengi
Ab factory bhi to ek class hi hai, ab uske andar ya to hum ek hi method bana dein jo kuch input lega and kuch conditions ke basis pe jo bhi type ki (economic or luxury) chahiye hogi wo dega. Otherwise har car ke liye apna method. ya kuch aur bhi logic.

Jo bhi karenge. Ab kyuki 2 factories ho gayi hain. to hame iske liye bhi ek factory lagegi ki bhai konsi type ki factory chahiye (luxury factory or economic factory). and kyuki ye factory hai to iska return type kuch common hoga to iska matlab ki luxuryFactory and economicFactory ko jodne wala ek interface banega(AbstractFactory). And AbstractFactoryProducer isko return karega.

---

Example 2: (Yaha bhi 2 factories banani padi, reason thoda alag tha depending on use case.)


Sara game grouping ka hai.
Agar multiple hierarchy ban rahi to -> Abstract factory pattern
Agar single ban rahi to sirf -> factory pattern




