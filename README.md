# Hotel Management System (Backend)

## Table of Contents

-   [Introduction](#introduction)
-   [Data Model](#data-model)
    -   [Room](#room)
-   [HTTP Requests](#http-requests)
    -   [GET](#get)
    -   [POST](#post)
    -   [PUT](#put)
    -   [DELETE](#delete)

## Introduction and Technologies

Hotel Management System (HMS) is a system designed for the management of the hotel rooms. This allows managers to quickly search, modify and delete rooms from the system from both desktop and mobile devices. This project was created more for learning Full-Stack development then to actually create a complete and bug-free system. Here you will find the backend, the frontend can be found <a href='https://github.com/AleandroPresta/hms-frontend'>here</a>.

## Data Model

The projects uses MySQL as a database with a single table called `room`. Each entry in this database has the following fields:

1. **id**;
2. **type**: can be `single`, `double`, `king`, `queen` and `suite`;
3. **price**;
4. **rating**;
5. **is_available**: a boolean value that determines if the room is booked or not.

## HTTP Requests

### GET

### POST

### PUT

### DELETE
