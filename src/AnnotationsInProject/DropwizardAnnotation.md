## @Api ##

### Usecase ###
It marks a class as a resource that should be included in the Swagger documentation.

### Attributes ### 
value: A short description of the API or its purpose.
tags: Categorizes the API for better organization in the Swagger UI.<br>
description: A detailed explanation of the resource class or API.<br>
produces / consumes: Specifies the media types the API produces or consumes.<br>
authorizations: Used to define security mechanisms (e.g., OAuth, API keys).<br>
hidden: If set to true, it hides the API from the Swagger UI.

### Library ###
io.swagger.annotations

## @Resource ##

### Usecase ###
It automatically provides the log instance without requiring you to define it explicitly. It does this inside the class which has been annotated. <br>
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CurrentClassName.class);

Now we can use log.info("Message"), log.debug("Message"), log.error("Message"), etc for logging purpose.


### Attributes ### 
Depending on the type of log we want to have, there are multiple attributes.

### Library ###
lombok.extern.slf4j

## @Slf4j ##

### Usecase ###
It automatically provides the log instance without requiring you to define it explicitly. It does this inside the class which has been annotated. It is based on logback in spring and DW. <br>
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CurrentClassName.class);

Now we can use log.info("Message"), log.debug("Message"), log.error("Message"), etc for logging purpose based on the severity of the issue.

### Attributes ### 
Depending on the type of log we want to have, there are multiple attributes.

### Library ###
lombok.extern.slf4j





