# Message Game Engine

## Running the Services
1. Download and Install Git - https://git-scm.com/downloads
2. Open `Command Prompt` on Windows or `Terminal` on Mac 
3. Run the following commands
```shell
git clone https://github.com/cah-johnkeyes/message-game-engine.git
cd message-game-engine
gradlew.bat bootRun
```

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
#### Body 
_No Body Required_
#### Response
```javascript
{
  "id": 293, 
  "players": []
}
```

## Joining a Game
__`POST`__ `/game/{gameId}/player/{username}`
#### Body
_No Body Required_
#### Response
> NOTE: All players must join a game (including the creator)
```javascript
{
  "id": 293,
  "players": [
    {
      "username": "the_fish",
      "deviceToken": "3920293ac910d0f00d90939dfn29200203"
    }
  ]
}
```

## Sending a Message
__`POST`__ `/game/{gameId}/player/{username}/message`
#### Body
```
MESSAGE
```
#### Response
```
MESSAGE
```

> NOTE: When all players have sent messages, a broadcast will be sent out. If a player sends another message before other players, the server will respond with a 406

## Ending a Game
__`DELETE`__ `/game/{gameId}`
#### Body
TBA
#### Response
_No Response_
