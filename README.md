# TransportRoute_Algorithm
Best Route Transportation with the Minimum Vehicles.

## Problem Statement
If someone has to deliver/export goods, his key priorities are:
  * to utilise as few vehicles as possible and to export as much goods as possible.
  * To transport items via the shortest path possible between locations.

## Proposed Solution
We decided to create an algorithm that will take the weight of the goods to be transported as input and output the minimum number of vehicles required to transport the goods.
Furthermore, by providing the destination, we can easily obtain the shortest route available from the warehouses to that destination, as well as the total travel cost for exporting those goods via that route.

## Project Features
 * Gives minimum number of vehicles.
 * Provides the shortest route from the source to the given destination. 
 * We can also transport goods via city on route regardless of the goods to be transported at the final destination.
 * Displays the total cost of travel.

## Implementation
To begin, in order to solve the minimum vehicle problem, we created an algorithm based on coin denomination and modified it to meet the needs of our project. When a user enters a weight, the algorithm will automatically divide that weight by the vehicle's capacity, which we have already specified in the code, and output the smallest number of vehicles required to transport the goods. And to find the shortest route for goods transportation, we used Dijkstra's algorithm with a (33x33) adjacency matrix, using all of Rajasthan's districts as nodes/vertices and routes between them as edges. And we have chosen our sources/warehouses in Jaipur, Udaipur, and Jaisalmer, and when the user enters the destination, it will show the shortest route distance available as well as the via cities that will come in that route. It will also show the cost of travelling on that route.

## Group Members
* Keshaw Soni
* Kondrolla Dinesh Reddy
* Rahul Jain
* Somya Gautam
