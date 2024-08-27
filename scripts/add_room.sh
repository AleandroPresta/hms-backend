curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "room_type": "single",
    "price": 25.5,
    "rating": 4.5
}' \
http://localhost:8080/api/v1/room
