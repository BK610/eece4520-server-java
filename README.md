# Bot or Not

This repository contains all server-side code for Bot or Not. For client-side, check out [https://github.com/BK610/eece4520-client-react](https://github.com/BK610/eece4520-client-react).

## To Use

Open the latest deployed version of Bot or Not at [https://eece4520-server-java.herokuapp.com](https://eece4520-server-java.herokuapp.com).

The homepage for the server-side deployment points to the client-side deployment, as all intended points of user interaction with the system happen with the actual product. That being said, for the sake of testing, a few API calls can be made through simply changing the URL to GET information via HTTP Request.

## Available API Calls

All API calls assume a starting URL root of _https://eece4520-server-java.herokuapp.com/api_. Append the listed URLs to the base, and the browser will automatically make a request to the server and return the JSON-formatted response.

Calls that require an input, such as a user ID to search by, indicate this using braces in the URL. For example, `{userId]`.

### Users

Get all users - `/user`

Get user by ID - `/user/{userId}`

Check if user exists - `/user/exists/{userId}`

### Tweets

Get all Tweets - `/tweet`

Get Tweet by ID - `/tweet/{tweetId}`

Get all Tweets by user ID - `/tweet/user/{userId}`

### BotOrNot

Get BotOrNotScore by user ID - `/botornot/{userId}`