# Calendly-API
REST APIs for an MVP of a platform similar to Calendly. This service is built with Dropwizard and utilizes:
1. Java, JDK 17
2. Maven 3.8.1
3. Google Guice for dependency injection.

## Refer to `Dockerfile` to run it locally


## APIs
- Create User1
```shell
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "user1",
    "name": "jon",
    "email": "jon@gmail.com"
}'
```

- Create User2
```shell
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "user1",
    "name": "doe",
    "email": "doe@gmail.com"
}'
```

- Add Availability for user1
```shell
curl --location 'localhost:8080/user-availability' \
--header 'Content-Type: application/json' \
--data '{
    "userId": "user1",
    "date": "01/01/2024",
    "slots": [1, 2, 3, 4]
}'
```

- Add Availability for user2
```shell
- curl --location 'localhost:8080/user-availability' \
--header 'Content-Type: application/json' \
--data '{
    "userId": "user2",
    "date": "01/01/2024",
    "slots": [1, 2]
}'
```

- check overlap for user1 & user2
```shell
curl --location 'localhost:8080/user-availability/user1/overlap/user2?date=01/01/2024'
```
- output 
```json
[
    {
        "index": 1,
        "timeStamps": {
            "first": "00:00",
            "second": "00:15"
        }
    },
  {
    "index": 2,
    "timeStamps": {
      "first": "00:15",
      "second": "00:30"
    }
  }
]
```

- create an event 
```shell
curl --location 'localhost:8080/events' \
--header 'Content-Type: application/json' \
--data '{
    "creatorUserId": "user2",
    "opponentUserId": "user1",
    "date": "01/01/2024",
    "slotIndices": [1]
}'
```

- check overlap for user1 and user2 again
```shell
curl --location 'localhost:8080/user-availability/user1/overlap/user2?date=01/01/2024'
```
- output
```json
[
    {
        "index": 2,
        "timeStamps": {
            "first": "00:15",
            "second": "00:30"
        }
    }
]
```

## Strategy
- The 24 hours of each day are divided into 96 time blocks or slots, with each slot representing a 15-minute interval. 
  - The approach assumes that any availability windows or event schedules created on the platform will have a minimum duration of 15 minutes.


========================== Problem Statement Below ======================================

# Harbor Take Home Project

Welcome to the Harbor take home project. We hope this is a good opportunity for you to showcase your skills.

## The Challenge

Build us a REST API for calendly. Remember to support

- Setting own availability
- Showing own availability
- Finding overlap in schedule between 2 users

It is up to you what else to support.

## Expectations

We care about

- Have you thought through what a good MVP looks like? Does your API support that?
- What trade-offs are you making in your design?
- Working code - we should be able to pull and hit the code locally. Bonus points if deployed somewhere.
- Any good engineer will make hacks when necessary - what are your hacks and why?

We don't care about

- Authentication
- UI
- Perfection - good and working quickly is better

It is up to you how much time you want to spend on this project. There are likely diminishing returns as the time spent goes up.

## Submission

Please fork this repository and reach out to Prakash when finished.

## Next Steps

After submission, we will conduct a 30 to 60 minute code review in person. We will ask you about your thinking and design choices.
