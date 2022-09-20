# Challenge sipf
 Build an message management app based on spring boot and angular
 
## Run the app
```sh
git clone https://github.com/louisonbrault/challenge-sipf.git
cd challenge-sipf
docker-compose up -d
```
 
## Backend
I stared with the backend part. I've created 4 endpoints to manage the messages.

GET /message
GET /message/{id}
POST /message/{id}
PUT /message/{id}
DELETE /message/{id}

I have respected the CRUD standards. I used lombok to avoid writing getters and setters and I use hibernate to validate the fileds. I also witted some test to validate the expected behavior.
