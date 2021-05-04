Service Framework skeleton. It includes the basic functionalities ans addons of our microservice framework. its nowhere complete, just a start, please submit a PR if you are interested.
It includes.
1. Swagger, hit /index or /swagger
2. Health, hit /health
3. Logging, => a generic logger appender config is provided, we need to
improve.
4. Version => As of now, its provied in the service-bootstrap, we need to enforce the service to set the version, then we can remote /version from the app and include in service framework
5. Actuator and Prometheus, hit /actuator, basic metrics are provided, you can create custom ones
6. SpringBoot related dependency.

