#!/bin/bash

# Check if the user provided the request count argument
if [ -z "$1" ]; then
  echo "Usage: $0 <request_count>"
  exit 1
fi

# Set the request count from the command-line argument
REQUEST_COUNT=$1

# Array of possible room types
ROOM_TYPES=("single" "double" "suite" "queen" "king")

# Function to generate random floating point number between two values
random_float() {
  min=$1
  max=$2
  echo "$(awk -v min=$min -v max=$max -v seed=$RANDOM 'BEGIN{srand(seed); printf "%.1f\n", min + rand() * (max - min)}')"
}

# Function to generate random integer within a range
random_int() {
  shuf -i $1-$2 -n 1
}

# Loop to send multiple requests
for ((i=1; i<=REQUEST_COUNT; i++))
do
  # Select a random room type
  ROOM_TYPE=${ROOM_TYPES[$(random_int 0 $((${#ROOM_TYPES[@]} - 1)))]}

  # Generate random price between 50 and 500
  PRICE=$(random_float 25 125)

  # Generate random rating between 1 and 5
  RATING=$(random_float 1 5)

  DATA=$(cat <<EOF
{
  "type": "$ROOM_TYPE",
  "price": $PRICE,
  "rating": $RATING,
  "available": true
}
EOF
)

  # Send the POST request
  curl --header "Content-Type: application/json" \
    --request POST \
    --data "$DATA" \
    http://localhost:8080/api/v1/rooms

  # Optional: add a sleep interval to avoid overwhelming the server
  sleep 0.1
done