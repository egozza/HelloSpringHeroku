# HelloSpringHeroku
Hello world for spring cloud heroku

Пример приложения с Spring Cloud для размещения в heroku


```sh
  $ heroku apps:create
  $ heroku config:set SPRING_CLOUD_APP_NAME=HelloSpringHeroku
  $ heroku config:set SPRING_PROFILES_DEFAULT=cloud
  $ git push heroku master
```
