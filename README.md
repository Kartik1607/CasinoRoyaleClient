# CasinoRoyaleClient

This is frontend client side tier of Casino Royale application.
The application exposes REST API to do CRUD operations on a user, contains the game logic and serve a angular based web page made to client.
This project was part of training at <a href='http://www.nagarro.com/en'>Nagarro</a>.

<img src='https://i.imgur.com/8wuvuN0.gif'/>

| <img src='https://imgur.com/SzkmJlu.png'/> | <img src='https://imgur.com/jjcjgNn.png'/> |
| --- | --- |
| <img src='https://imgur.com/GmA8nTQ.png'/> | <img src='https://imgur.com/kPWlBTn.png'/> |

## Live Demo

Live Demo is hosted using [Heroku](http://casino-client.herokuapp.com/) <br>

## Development server

Clone the repo or download the zip file.<br>
Modify `application.properties` to change port if required. Default port is 4200<br>
The [backend server](https://github.com/Kartik1607/CasinoRoyale) must be running at `http://localhost:8080`.<br>
Make changes to API_URL inside the [Constants file](https://github.com/Kartik1607/CasinoRoyaleClient/blob/master/src/main/java/com/stfo/helper/Constants.java) incase server is running at different address.
Run `mvn spring-boot:run` for a dev server. Navigate to `http://localhost:4200/`.

## Built With&nbsp; :heart: &nbsp;using

* [Java](https://www.java.com)
* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Tomcat](http://tomcat.apache.org/) 
* [JSTL](https://javaee.github.io/jstl-api/) 
* [HTML](https://html5.org)
* [JS](https://www.javascript.com/) 
* [CSS](https://www.w3.org/Style/CSS/Overview.en.html) 
* [Bootstrap 4](https://getbootstrap.com)
* [Jquery](https://jquery.com/) 
* [Angular](http://angular.io/)

## License

This project is licensed under the MIT License - see the LICENSE.md file for details
