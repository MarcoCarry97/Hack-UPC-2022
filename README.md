# Hack UPC Project

## Team members:

- Monika Dziedzic
- Marco Carega
- Nitish Arya
- Pablo Galván Calderón.

## Requirements:

- install Java 11
- install Dart

## Inspiration

Our team is international and we shared a common problem, renting a room! Many of our friends were scammed and we had to
look very carefully and consult everyone before renting a property. The people who got scammed want to help out others
so they don't face the same situation. This inspired us to make a platform where the victims can post the scam property
and other people can upvote and downvote it.

## What it does

So we came up with the idea of ScamSlam, a stop website where you can see all the potential scam properties posted by
people who were already scammed. You can view the confidence percent of a property being a scam which is a combined
percentage of user votes and an AI system which rates the property according to the images(restb.ai). You can also
upvote or downvote a property if you feel it is a right or a wrong listing.

The full demonstration of what our application is capable of is available in the root project folder in the file
named `app_video.mp4`.

## How we built it

We built a functional website with the Frontend implemented in Flutter while testing UI iterations on a mobile device
and the Backend implemented in Spring Boot with Hibernate with a RESTful API connecting them. For image dataset we used
an open database of property photos on github. For getting the score of an image we used restb.ai's API and integrated
that into our Spring Boot backend. For testing we used postman and manual testing.

## Challenges we ran into

Integrating Flutter with Spring Boot was a real challenge. Also the UI creation from scratch was iterative and
implementing was time consuming. For the given time, implementing more functionality, fetching data for our problem set
and Spring boot bugs were a real issue.

## Accomplishments that we're proud of

That we were able to implement a functional backend, a cute frontend, a minimalist but functional design and integration
of restb.ai's API. The biggest accomplishment was the incomplete integration of Flutter with Spring Boot given our
almost zero experience in development.

## What we learned

How a full application design takes place and what are the components involved. How to cut down your expectations to
achieve a realistic goal in limited time. How to be patient and not lose your confidence in your work. How to
communicate as a team. And how to be satisfied with what you created.

## What's next for ScamSlam

Reverse image search so a user can upload image and check if it is a scam listing. Advanced AI image processing for
determining potential listing is a scam or not, for ex. comparing the photos of the property with its location and
pricing and raise a flag when they don't comply. Area search, owner search, and cross sectional search(with photos of
one and location of another). To help more people from our product and enjoy a beautiful experience of renting.

## Built With

- Dart
- Flutter
- Java
- restb.ai
- REST API
- Spring Boot
- IntelliJ Idea
- Android Studio
- Postman

## How to run:

- run frontend written in Dart
- if you cannot run both frontend and backend on the same computer, you can expose e.g., backend services through
  ngrok: `ngrok http 8080` and then call the freshly-obtained URL from the frontend level.

## Show db connection:

- Go to http://localhost:8080/h2-console/
- JDBC URL: `jdbc:h2:mem:testdb`

