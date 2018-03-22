# ankka-palvelin

This is a Maven spring boot project.
To get this app running you need to have Apache Maven and Java version: 1.8.0_144 or newer. 
The project uses H2 database but can be modified to use mysql or postgres if wanted so.

To get started clone the repository to your local directory.

You can run a Spring Boot application from your IDE as a simple Java application. However, you first need to import your project. 
Import steps vary depending on your IDE and build system. 
Most IDEs can import Maven projects directly. 
For example, Eclipse users can select Import…​ → Existing Maven Projects from the File menu.

In IDEA IntelliJ you can import the project by clicking "File ->  New -> Project From Existing Sources.. 
-> then a window pops up and you need to navigate to the just cloned repository 
-> select the root directory (there should be the pom.xml file) -> click ok
-> select Maven from the list -> click next 
-> then you can just click next until you get to a window which asks you to select project SDK.
Be sure to select 1.8 -> click next and just keep clicking until you get to click finish and click that.

It might take some time while maven does its magic and sorts everything out. But after that you're good to go!

If you dont want see the project source code you can simply use the maven tools to run the server from command line.
In windows first navigate to the cloned repositorys root folder and check if it finds maven by writing "mvnw --version"

it should print something like

Apache Maven 3.5.2 

Maven home: C:\Users\{XXXXXX}\.m2\wrapper\dists\apache-maven-3.5.2-bin\{somehash}\apache-maven-3.5.2

Java version: 1.8.0_144, vendor: Oracle Corporation

Java home: C:\Program Files\Java\jdk1.8.0_144\jre

Default locale: en_GB, platform encoding: xxxx

OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

Then you can check if the project has everything need to run it by typing "mvnw validate" and it should return

[INFO] BUILD SUCCESS

you can try running tests by typing "mvnw test" or just run it with "mvnw spring-boot:run".
For other platforms i dont know the command line commands.

Requests root url is "http://localhost:8081".
For GET requests "/sightings" and "/species".
You can also use POST for "/sightings" to post new sighting to database.
At the moment the API only accepts Application/JSON so if you have trouble posting to the server check that your format is correct.

And there are some rules for the POST request.

1.The Duck must be listed in "Species".

2.Count cant be 0 or empty (null).

3.If there's no given time it will post the current time automatically.
