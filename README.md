# Handling Multi Tenancy at DB and Caching Level.
This repository shows a small demo of handling multi tenancy at Cache and Database level.
 
## What is Multi Tenancy ?
When a single piece of hardware or software is intended to be used by many different inviduals, organization, or people from different region that is called a multi tenant application. 
## Pros of Multi Tenant Application 
1. Single Deployment
2. Reduced Overall Costs
3. Increased Scalablity
 
## Concerns of Multi Tenant Application
1. The multi tenanat system should be intellijent enough to identify the client or source where the request is originated.
2. User of particular region should be able to access data of that region.
3. Cache data should not be shared among clients. 
4. Log Identification for each client.
 
## Technology Stack
1. Java
2. Jersey (2.X)
3. [Hazelcast](https://docs.hazelcast.org/docs/3.3/manual/html-single/hazelcast-documentation.html#introduction "Hazelcast Introduction")
4. [MongoDB](https://docs.mongodb.com/ "MongoDB Docs")
5. [Morphia](http://morphiaorg.github.io/morphia/1.3/ "Getting Started Morphia") to fire mongo db queries.
6. [Guice](https://github.com/google/guice) for dependency injection
 
## There can be three strategies to handle multi tenancy:
 
1. Using tenant-specific fields for security in the database and filter out data on the basis of this field for a region.
2. Create Collection for each region in the same Database.
3. Create different dataBase for each region.
 
## I have tried implementing variant 3:
 
1. Different region data size may differ. Through this solution it will be easy to work according to the DB size.
2. Sacling out your application will be easier for each database separately.
3. There can be a difference in the structure of data for a region. By the separation of DB it can be handle.
4. Maintaing Versions/ backup of data per tenant will be easier.
5. There can be a legal restriction for the spearation of data for different region.
 
## Scenario
An International Bank A has branches and customer all over the world. Daily thousands of cutomer login and do some transactions globally. So the bank has personal, financial details about all the customers. 
 
### Problem Statement
Many countries like US, EU, India etc. put a restriction on the organizations that they cannot share, move or transfer the data to a entity outside the country. So the bank A needs to isolate the requests, data of the customers depending on there region.
**For example** - Bank A should store and handle all the data intensive request from an Indian customer in a server hosted in India. Even the data in a the cache memory should not be shared among the regions.
 
### Solution
1. Currently I am not implementing the USER login , logout feature to identify the user context or the region of the user. To handle this situation i have created a rest end point to set the user context.
2. Create map of region VS dataBase name to store the dbName for the corresponding region.
3. Create Hazelcast map for each region give Hazelcast Name like "CUSTOMER_REGION1" map to store data of customer.
4. According to the usercontext identify the DBName and Hazelcast map name from the Map created above (i.e. Tenant VS DBName and Tenant VS hazelcast map name).
5. After identifying the DBName and Hazelcast Map name send the request to the corresponding Hazelcast map and DB .
