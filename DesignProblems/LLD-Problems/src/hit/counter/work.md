# Problem statement

Design a webpage visit counter. There are n webpages in a website numbered 0 to n-1. Hunderes of users visit webpages of this website simultaneously. You to record visit count of each page and return them when required. Consider multi concurrency environment.

# Functional Requirement

1. Request will be coming to the system like hit(webpageId, timestamp), notifying that this webpage was visited at this timestamp.

2. 