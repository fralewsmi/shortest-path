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
* The network should be able to be extended
* The solution is able to be integrated with an external interface (e.g. a web application)

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
* Run this API locally using `java -jar target/swagger-spring-1.0.0.jar` (server will be listening on port 8080)
