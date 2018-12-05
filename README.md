# Shortest Path
Find the shortest path between two points in a rail network

## Problem
* The train network graph is an example of a simple directed graph with non-negative edge weights.
* Stations are nodes and the distances between stations are the weights of the edges.
* Attempting to find the shortest route between two stations is an example of the shortest path problem. 
* Two commonly cited algorithms for solving the shortest path between two points are Dijkstra's algorithm and A* algorithm.
* A* is an improvement on Dijkstra's, it uses a heuristic to guide the search.
* It will be reasonable to implement Dijkstra's algorithm first with the ability to extend it in the future.

## Solution
An API must be designed so that:
* A user can search the shortest route by giving two stations in the network
* Search algorithms can be swapped out and enhanced conveniently by developers
* The solution is able to be integrated with an external interface (e.g. a web application)

## Sorting Algorithm
Initial sorting algorithm is an implementation of Dijkstra's algorithm from https://www.baeldung.com/java-dijkstra
An interface is used to enable further development of other algorithms without breaking integration with the API

## API Design
The simplest approach is to have a restful endpoint for getting a shortest route by supplying the starting point and the destination

    GET /route?origin=A&destination=B

This endpoint should return a list of the stations to go through in order to take this shortest path. 
The entities required are therefore:
* Route - contains an ordered list of stations in the route
* Station - has a name attribute which matches the name provided in the query parameters

## API Development
I have created a swagger spec to document this stage of the design (see: swagger.json)
Using this swagger spec I have generated a sample API, with a controller for the /route endpoint.
* Build this API using `mvn package` from the spring-server/ directory
* Run this API locally using `java -jar server/target/server-0.0.1-SNAPSHOT.jar` (server will be listening on port 8080)

## User Interface
The API is accessible by performing HTTP requests against http://localhost:8080
The simplest way to do so is to go to this address in your browser and use the swagger UI to enter an origin and a destination. 
 
## Future work, enhancements and shortcomings 
* Implementing custom response types would give more meaningful feedback for developers to work with when integrating with the API
* A web application would be simple to integrate with the API and provide a better interface than the swagger UI,
* Additional restful methods should be added which allow users to add stations to the rail network themselves, instead of it being hardcoded
* A database should be setup to store the rail network information, having the network setup in the local Java is okay for demo purposes but a database would scale up far better if the API was grown.
* I'm not convinced having separate models for Graphs, Nodes, Routes and Stations is a good idea. I would like to have had a Station as a subclass of a Node, with a Route a subclass of a Graph. This would make the conversion between the output of a sorting algorithm into the API response more intuitive.
* Using a factory pattern to construct the shortest path alogrithm would provide more encapsulation for that module and allow developers to switch algorithms on the fly
