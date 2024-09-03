#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <id>"
  exit 1
fi

# Assign arguments to variables
ID=$1

# Make the HTTP call with the data
curl --header "Content-Type: application/json" \
  --request DELETE \
  http://localhost:8080/api/v1/rooms/$ID/delete