# Game ui

This API is implemented to saw all trainer and their pokemon  

# Configuration 

This project run with mustache 

## Set env variable 

`USER` : the user to connect to the spring boot app

`PASSWORD`: the password to connect to the spring boot app
 
## Run the project 

After configure all env variable do
`mvn clean install && mvn spring-boot:run`

The application is started on port 9000

# Implementation 

This API is available on this link : [`https://game-ui-adrien1251.herokuapp.com/`](https://game-ui-adrien1251.herokuapp.com/)

You can login with trainer name password. Contact the administrator to have an test account

Available routes:

`GET /`                 : Professor screen  

`POST /registerTrainer`           : Register new trainer

`GET trainers/`    : Saw all trainers team

`GET pokedex/`    : Saw the pokedex

`GET profile/`    : Saw your profile and the other trainer profile

`GET fight/<name>`    : Fight the opponent of your choice

