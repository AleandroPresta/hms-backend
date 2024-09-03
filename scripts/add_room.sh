#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 4 ]; then
  echo "Usage: $0 <type> <price> <rating> <available>"
  exit 1
fi

# Assign arguments to variables
TYPE=$1
PRICE=$2
RATING=$3
AVAILABLE=$4

# Store the data in a variable
DATA=$(cat <<EOF
{
  "type": "$TYPE",
  "price": $PRICE,
  "rating": $RATING,
  "available": $AVAILABLE
}
EOF
)

# Print the data
echo "Sending the following data:"
echo "$DATA"

# Make the HTTP call with the data
curl --header "Content-Type: application/json" \
  --request POST \
  --data "$DATA" \
  http://localhost:8080/api/v1/rooms