#!/bin/bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 5 ]; then
  echo "Usage: $0 <id> <type> <price> <rating> <available>"
  exit 1
fi

# Assign arguments to variables
ID=$1
TYPE=$2
PRICE=$3
RATING=$4
AVAILABLE=$5

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
  --request PUT \
  --data "$DATA" \
  http://localhost:8080/api/v1/room/$ID/update