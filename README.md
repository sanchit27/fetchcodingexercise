<h3 align="center">Fetch Coding Challenge</h3>

  <p align="center">
    By : Sanchit Bhargava
    </p>



<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#Installation">Installation</a></li>
    <li><a href="#dockersetup">Docker Setup</a></li>
    <li><a href="#runproject">Run Project</a></li>
    <li><a href="#demovide">Demo Video</a></li> 
   <li><a href="#testcasessnap">Test Cases Snap(Using In device Firefox)</a></li>
   <li><a href="#testcasessnatwop">Test Cases Snap(Using Docker)</a></li>
    <li><a href="#contact">Contact</a></li>
   
  </ol>
</details>

## About The Project

This project consists of automated tests written in Java using Selenium WebDriver. The tests interact with a web-based balance scale game hosted at http://sdetchallenge.fetch.com/. The game simulates a scenario where a user must determine which coin on a balance scale is fake using a limited number of weighings.


### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

<ul style="font-size: medium;">
  <li>Java</li>
  <li>Selenium WebDriver</li>
  <li>JUnit</li>
</ul>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To run the tests locally, follow these steps:
### Prerequisites

- **Java Development Kit (JDK):** Ensure JDK 11 or higher is installed on your system.
- **Firefox WebDriver:** Download geckodriver and ensure it's accessible via the system path.
- **Gradle:** Make sure Gradle is installed on your system. Here is the snapshot, just change the path of firefox or driver if needed:

![img.png](img.png)

- **Docker (For Windows/linux Users, even mac and other OS devices can also use if needed):** Install Docker and follow the steps given in the README.

### Installation

Below is an example of how you can install the repo:

1. Clone the repo (Below example is using SSH, can also use other methods)
   ```
   git@github.com:sanchit27/fetchcodingexercise.git
   ```
2. Navigate to the project directory:
   ```sh
   fetchcodingexercise/lib/src/main/java/SDETChallengeTest
   ```
3. Update the webdriver.gecko.driver system property in the SDETChallengeTest class with the path(if needed, generally macbook firefox has same path under Applications folder) to geckodriver. 


<img width="905" alt="Screenshot 2024-04-22 at 20 10 12" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/06a885ca-fd5e-4b68-a8ad-d46838a953c2">

4. If not using mac, Uncomment the slenium grid WebDriver setup code in the browserStart method for and run it via docker selenium grid. 
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Docker setup (Can be used to test on any device, you skip this if running locally on macbook)

[For old macbook and windows (non arm64 devices)]
1. Pull selenium hub  
    ```
   docker pull selenium/hub 
    ```
2. Pull the Selenium Grid Node for Firefox Docker image:
    ```
   docker pull selenium/node-firefox
   ```
[For old macbook and windows (non arm64 devices)][[You can change port number if needed]

3. Run the Selenium Grid Node for Firefox

 ```
    docker run -d -p 4444:4444 selenium/standalone-firefox
```
[For macbook M series chip] [You can change port number if needed]

```
docker run -d -p 4444:4444 seleniarm/standalone-firefox
```
4. Then check the status ```http://localhost:4444/grid/console``` and verify firefix is running
<img width="1242" alt="Screenshot 2024-04-22 at 19 56 18" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/ebb378d3-b98a-4b7d-9412-c16673a245da">

5. Comment the code (public static void browserStart()) which is being used by local machine (Only if using docker, else no change is needed)
<img width="980" alt="Screenshot 2024-04-22 at 20 04 15" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/aca1b505-78b3-4ef8-a3e3-7ba4d72037d2">

5. Uncomment the selenium grid code, change the url (GRID_HUB_URL) if running on other ports (Function name: public static void browserStart())  and then run project
<img width="980" alt="Screenshot 2024-04-22 at 20 02 48" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/4c96fff2-92ee-4ed2-935b-590e6b2a2955">


## Run Project

1. Build :
```
gradle build
```
2. Run :

```
gradle run
```

## Demo Video

[![Video Title](https://img.youtube.com/vi/zRotlP_uTpg/0.jpg)](https://youtu.be/zRotlP_uTpg)

## Test Cases Snaps (Using In device Firefox)
<div style="display: flex; justify-content: center;">
    <div>
        <img width="312" alt="Screenshot 2024-04-22 at 13 17 04" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/d6f055f7-9d82-4246-ba0f-d0dee8d95280">
    </div>
    <div>
        <img width="322" alt="Screenshot 2024-04-22 at 13 17 39" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/44f2d961-3224-4746-af2d-f4d515170778">
    </div>
</div>

<div style="display: flex; justify-content: center;">
    <div>
        <img width="322" alt="Screenshot 2024-04-22 at 13 20 35" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/da10b0eb-4493-41bb-bcef-c9f0d171102f">
    </div>
    <div>
        <img width="322" alt="Screenshot 2024-04-22 at 13 20 45" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/3a56c22a-76fe-45e5-a6a2-e2bda087d7bb">
    </div>
</div>



## Test Cases Snaps (Using Docker)

<div style="display: flex; justify-content: center;">
    <div>
        <img width="322" alt="Screenshot 2024-04-22 at 13 47 21" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/2fd5f9df-26b0-48af-9bba-04547568a72b">
    </div>
    <div>
        <img width="331" alt="Screenshot 2024-04-22 at 13 48 00" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/9e02dc42-e405-48bb-8046-23d728a5fac6">
    </div>
</div>

<div style="display: flex; justify-content: center;">
    <div>
        <img width="331" alt="Screenshot 2024-04-22 at 13 48 37" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/80f163bf-45fb-40ae-9d18-5d6ff7cfee2f">
    </div>
    <div>
        <img width="331" alt="Screenshot 2024-04-22 at 13 48 47" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/f344d714-8ed8-4cc5-a196-8d5df0186464">
    </div>
</div>


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Sanchit Bhargava - [Linkedin](https://www.linkedin.com/in/sanchitsdet) 
Email: sanchitbhargava278@gmail.com
Contact: (929) 483-6162
Project Link: [https://github.com/sanchit27/fetchcodingexercise](https://github.com/sanchit27/fetchcodingexercise)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



