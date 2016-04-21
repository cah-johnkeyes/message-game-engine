# Message Game Engine

## Registering a Player
__`POST`__ `/player`
##### Body
```javascript
{
  "username": "the_fish",
  "deviceToken": "3920293ac910d0f00d90939dfn29200203"
}
```
#### Response
```javascript
{
  "username": "the_fish",
  "deviceToken": "3920293ac910d0f00d90939dfn29200203"
}
```
> NOTE: Username should only contain letters, numbers, _ and -


## Creating a Game
__`POST`__ `/game`


## Joining a Game
__`POST`__ `/game/{gameId}/player/{username}`
> NOTE: All players must join a game (including the creator)

## Sending a Message
__`POST`__ `/game/{gameId}/player/{username}/message`
```javascript
MESSAGE
```
> NOTE: When all players have sent messages, a broadcast will be sent out. If a player sends another message before other players, the server will respond with a 406
