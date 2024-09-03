#!/bin/bashù

# Usage
# ./test.sh <id>
if [ $# -ne 1 ]; then
  echo "Usage: $0 <id>"
  exit 1
fi

# Assign arguments to variables
TYPE=SINGLE
PRICE=25.5
RATING=4.5
AVAILABLE=1

# Take the id as an argument
ID=$1

# Function to check the exit status and print a message
check_status() {
  if [ $? -eq 0 ]; then
    echo "$1 succeeded"
  else
    echo "$1 failed"
  fi
}

# Execute the add_room.sh script
./add_room.sh $TYPE $PRICE $RATING $AVAILABLE 2>/dev/null
check_status "Add room"

# Execute the get_room.sh script
./get_room.sh $ID 2>/dev/null
check_status "Get room"

# Execute the update_room script
NEWTYPE=2
./update_room.sh $ID $NEWTYPE $PRICE $RATING $AVAILABLE 2>/dev/null
check_status "Update room"

# Execute the delete_room script
./delete_room.sh $ID 2>/dev/null
check_status "Delete room"

# Execute the get_all.sh script
./get_all.sh 2>/dev/null
check_status "Get all rooms"