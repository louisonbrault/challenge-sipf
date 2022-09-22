# Challenge sipf
 Build a message management app based on spring boot and angular

## Run the app
```sh
git clone https://github.com/louisonbrault/challenge-sipf.git
cd challenge-sipf
docker-compose up -d
```

Then go to http://localhost

## Backend
I stared with the backend part. I've created 4 endpoints to manage the messages.

GET /message <br>
GET /message/{id} <br>
POST /message/{id} <br>
PUT /message/{id} <br>
DELETE /message/{id} <br>

I have respected the CRUD standards. I used lombok to avoid writing getters and setters and I use hibernate to validate the fields. I also wrote some test to validate the expected behavior.

## Frontend
I created the front with Angular and I used Ant Design to make it more beautiful. As of now we can only see the messages, create new ones and delete it.

TODO :
- Update a message
- Research using tags
- Write rich content (bold, underline) 
