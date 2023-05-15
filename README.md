# Getting Started

You can run the project locally with IntelliJ or via the commands:

`./gradlew clean build`

`./gradlew bootRun`

### Guides

This is a drone controller app, which enables the drone to move on a 10x10 field in 4 direction (South, North, East and West). 

The API is documented via swagger and is available for testing: 

`http://localhost:8080/swagger-ui/index.html`

### Next Steps

Some ideas for developing this app further would be:
* handling invalid input with specific exceptions and corresponding http status codes
* adding more unit tests
* saving the points in the field that were already sprayed by the drone so that it uses the fertilizer in an optimized way
* creating a database to store multiple drones and drone fields