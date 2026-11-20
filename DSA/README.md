## How to run

- Install Java version 27.0.1.1 from the [Java website](https://openjdk.org/projects/jdk/27/)
- Execute `java Main.java`

## Introduction

In this assignment, you will determine all possible flight plans for a person wishing
to travel between two different cities serviced by an airline (assuming a path exists). You will also
calculate the total cost incurred for all parts of the trip. For this assignment, you will use
information from two different input files to calculate the trip plan and total cost.

## Input Files

Origination and Destination Data: flights.dat

### Flights Format

```
Initial integer value indicates the number of records in the file
Record:
Origin | Destination | $ | time <minutes>
```

Requested Flights: requests.dat

### Request Format

```
Initial integer value indicates the number of records in the file
Record:
Origin | Destination | T/C
```
