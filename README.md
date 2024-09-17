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

### Tecnologies

The main tecnology utilized in the backend of this project is `Java Spring Boot`. To manage the access to the data I utilize `JPA`. To reduce the boilerplate code I use `lambok`.

## Data Model

The projects uses MySQL as a database with a single table called `room`. Each entry in this database has the following fields:

1. **id**;
2. **type**: can be `single`, `double`, `king`, `queen` and `suite`;
3. **price**;
4. **rating**;
5. **is_available**: a boolean value that determines if the room is booked or not.

## HTTP Requests

### GET

The user can access either the single room using the URL:

```
/{id}
```

or by accessing all the data. The data can be paginated using the options:

-   `pageSize`: indicates the size of a page;
-   `pageNo`: indicates the number of the page to access.

For example, if we wanted to divide the data in pages of 10 and access the 3th page, we would use the URL:

```
/search?pageNo=3&pageSize=10
```

There is also a filter available for each attribute of the Room class:

-   `types`: allows the user to filter the data per room type, using one or more values. Example:

    ```
    /search?types=SINGLE,DOUBLE,SUITE
    ```

    All the values need to be uppercased.

-   `price`: to access the data in price ranges we can use the values `minPrice` and `maxPrice`. For example:

    ```
    /search?minPrice=25.5&maxPrice=100.0
    ```

-   `rating`: we can also access the data filtering for rating:

    ```
    /search?minRating=3&maxRating=5
    ```

-   `available`: we can filter the data based on the availability of the room:

    ```
    /search?isAvailable=true
    ```

The data can also be sorted, specifying the field (i.e. `price`):

```
/search?sortBy=price
```

All this filtering combined allows the user to access only the data that he needs. For example:

```url
/search?pageNo=1&pageSize=10&minPrice=25.0&maxPrice=100&minRating=3&soryBy=rating
```

### POST

To POST a new room to the server all we need to do is a POST request on the `rooms` URL. The server will automatically assign an ID to the newly added room.

### PUT

To modify a room we use a `PUT` request on the `rooms/{id}/update` URL.

### DELETE

To delete a room we use a `DELETE` request on the `rooms/{id}/delete` URL.
