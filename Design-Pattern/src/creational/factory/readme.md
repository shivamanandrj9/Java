Identification:
1. If else condition and on the basis of which we are creating a class.
2. You need to map external input (config files, user choices, database flags and multiple parameters) to different classes at runtime.


What does factory pattern should ensure?

1. Client should have no idea which concrete class it is dealing with. It should use interface and never use the concrete class.
2. Based on condition we might need different class. So this conditioning logic should be with the factory and not with the client.