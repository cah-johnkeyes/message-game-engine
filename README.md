Message Game Engine
===================

Registering a Player
--------------------
`POST /player`
```javascript
{
  "username": "the_fish"
}
```

> NOTE: username should only contain letters, numbers, _ and -

Creating a Game
---------------
`POST /game`

Joining a Game
--------------
`POST /game/{gameId}/player/{username}`

> NOTE: all players must join a game (including the creator)
