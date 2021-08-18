# Travelin-Salesman
>The Travelling Salesman Problem (TSP) is the challenge of finding the shortest yet most efficient route for a person to take given a list of specific destinations. It is a well-known algorithmic problem in the fields of computer science and operations research.
There are obviously a lot of different routes to choose from, but finding the best one—the one that will require the least distance or cost—is what mathematicians and computer scientists have spent decades trying to solve for.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Status](#status)
* [Contact](#contact)

## General info
TSP has commanded so much attention because it’s so easy to describe yet so difficult to solve. In fact, TSP belongs to the class of combinatorial optimization problems known as NP-complete. This means that TSP is classified as NP-hard because it has no “quick” solution and the complexity of calculating the best route will increase when you add more destinations to the problem. 
The problem can be solved by analyzing every round-trip route to determine the shortest one. However, as the number of destinations increases, the corresponding number of roundtrips surpasses the capabilities of even the fastest computers. With 10 destinations, there can be more than 300,000 roundtrip permutations and combinations. With 15 destinations, the number of possible routes could exceed 87 billion.Popular Travelling Salesman Problem Solutions  

Here are some of the most popular solutions to the Traveling Salesman Problem:  

The Brute-Force Approach  

The Brute Force approach, also known as the Naive Approach, calculates and compares all possible permutations of routes or paths to determine the shortest unique solution. To solve the TSP using the Brute-Force approach, you must calculate the total number of routes and then draw and list all the possible routes. Calculate the distance of each route and then choose the shortest one—this is the optimal solution. 

The Branch and Bound Method  

This method breaks a problem to be solved into several sub-problems. It’s a system for solving a series of sub-problems, each of which may have several possible solutions and where the solution selected for one problem may have an effect on the possible solutions of subsequent sub-problems. To solve the TSP using the Branch and Bound method, you must choose a start node and then set bound to a very large value (let’s say infinity). Select the cheapest arch between the unvisited and current node and then add the distance to the current distance. Repeat the process while the current distance is less then the bound. If the current distance is less than the bound, you’re done. You may now add up the distance so that the bound will be equal to the current distance. Repeat this process until all the arcs have been covered.

The Nearest Neighbor Method  

This is perhaps the simplest TSP heuristic. The key to this method is to always visit the nearest destination and then go back to the first city when all other cities are visited. To solve the TSP using this method, choose a random city and then look for the closest unvisited city and go there. Once you have visited all cities, you must return to the first city.  


## Screenshot
<img src= width="400"  height="320">  

## To do
- [x] - GUI redesign  
- [ ] - fix bugs in score.java


## Technologies
* Java - version 1.8

## Status
Project is under development.  

## Contact
Created by @Danisoft Arad 2021(https://danipedro2006.github.io/) - feel free to contact me!  