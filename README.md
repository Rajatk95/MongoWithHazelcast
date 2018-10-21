# Handling Multi Tenancy at DB and Caching Level.
This repository shows a demo of handling multi tenancy at Cache and Database level.

## What is Multi Tenancy ?
When a single piece of hardware or software is intended to be used by many different inviduals, organization, or people from different region that is called a multi tenant application. 
## Pros of Multi Tenant Application 
1. Single Deployment
2. Reduced Overall Costs
3. Increased Scalablity

## Concerns of Multi Tenant Application
1. The multi tenanat system should be intellijent enough to identify the client or source where the request is originated.
2. Seperate Persistant Data for each tenant and its user.
3. Cache data should not be shared among clients. 
4. Log Identification for each client.

## Technology Stack
1. Java
2. Jersey (2.X)
3. [Hazelcast](https://docs.hazelcast.org/docs/3.3/manual/html-single/hazelcast-documentation.html#introduction "Hazelcast Introduction")
4. [MongoDB](https://docs.mongodb.com/ "MongoDB Docs")
5. [Morphia](http://morphiaorg.github.io/morphia/1.3/ "Getting Started Morphia") to fire mongo db queries.
6. [Guice](https://github.com/google/guice) for dependency injection

## Scenario
An International Bank A has branches and customer all over the world. Daily thousands of cutomer login and do some transactions globally. So the bank has personal, financial details about all the customers. 

### Problem Statement
Many countries like US, EU, India etc. put a restriction on the organizations that they cannot share, move or transfer the data to a entity outside the country. So the bank A needs to isolate the requests, data of the customers depending on there region.
**For example** - Bank A should store and handle all the data intensive request from an Indian customer in a server hosted in India. Even the data in a the cache memory should not be shared among the regions.


