# Event API



This API encapsulates Event related domain logic. 



## What is an Event

Event is consisted of following attributes

- Id - Unique Id of Event
- Created Timestamp - Creation timestamp with time-zone information
- Component - From which component this event was created    
- Environment - From which environment this was created
- Message - main event message
- Data - support payload



## Supported Operations

- Creation of Event
- Retrieval of Event by Id
- Search by
  - Creation date
  - Component
  - Environment
  - Data
  - *Partial match* on Message



## How to run

1. Install Docker

2. Run

   ```bash
   docker-compose up event-api
   ```



## How to test

Use the https://www.getpostman.com/collections/9317068f55a2a0ea6231 *Postman* API collection to test the API.

[^]: Please refer to https://learning.getpostman.com/docs/postman/collections/intro_to_collections to learn about importing Postman collections



## Known Issues

1. Search Event operation has a bug that it always requires *createdDate* field

2. Full Text Search function works only on complete tokens. eg: a message with "Hello Kitty" is searchable by input arguments "Hello" or "kitty" but not "kit"

   

## TODO

- ~~Created OAS API specification for REST Endpoint~~
- ~~Generate Java models from the OAS API yaml~~
- ~~Created Postgresql database with Full Text Search Index~~
- ~~Separate API, Domain, Persistence level logic~~
- ~~Dockerize Event API and Event Database~~
- ~~Create README.md file~~
- ~~Attempted to demonstrate the potential for CQS/CQRS~~ 
- Create Unit Tests
- Create client application
- Expose gRPC endpoint
- Benchmarking on Hibernate/Apache Lucence Index vs Postgresql Full Text Search 

