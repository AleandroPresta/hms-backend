#!/bin/bash

# Store the data in a variable
DATA='{
  "type": "single",
  "price": 80.5,
  "rating": 4.5
}'

# Print the data
echo "Sending the following data:"
echo "$DATA"

# Make the HTTP call with the data
curl --header "Content-Type: application/json" \
  --request POST \
  --data "$DATA" \
  http://localhost:8080/api/v1/room
