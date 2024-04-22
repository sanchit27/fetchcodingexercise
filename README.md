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

- **Docker (For Windows Users):** Install Docker and follow the steps given in the README.

### Installation

Below is an example of how you can install the repo:

1. Clone the repo (Below example is using SSH, can also use other methods)
   ```
   git@github.com:sanchit27/fetchcodingexercise.git
   ```
2. Navigate to the project directory:
   ```sh
   cd fetchcodinfexercide
   ```
3. Update the webdriver.gecko.driver system property in the SDETChallengeTest class with the path to geckodriver. 


4. Uncomment the appropriate WebDriver setup code in the browserStart method for  windows devices and run it via docker selenium grid. 
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Docker setup (Can be used to test on any device )

[For old macbook and windows (non arm64 devices)]
1. Pull selenium hub  
    ```
   docker pull selenium/hub 
    ```
2. Pull the Selenium Grid Node for Firefox Docker image:
    ```
   docker pull selenium/node-firefox
   ```
[For old macbook and windows (non arm64 devices)]
3. Run the Selenium Grid Node for Firefox

 ```
    docker run -d -p 4444:4444 selenium/standalone-firefox
```
[For macbook M series chip]

```
docker run -d -p 4444:4444 seleniarm/standalone-firefox
```


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
![](../Desktop/Screenshot <img width="312" alt="Screenshot 2024-04-22 at 13 17 04" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/d6f055f7-9d82-4246-ba0f-d0dee8d95280">
2024-04-22 at 13.17.04.png)
![](../Desktop/Screenshot 2024-04-22 at 13.17.<img width="322" alt="Screenshot 2024-04-22 at 13 17 39" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/44f2d961-3224-4746-af2d-f4d515170778">
39.png)

![](../Desktop/Screenshot 2024-04-22 at 13<img width="322" alt="Screenshot 2024-04-22 at 13 20 35" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/da10b0eb-4493-41bb-bcef-c9f0d171102f">
.20.35.png)
![](../Desktop/Screenshot 2024-04-22 at 13<img width="322" alt="Screenshot 2024-04-22 at 13 20 45" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/3a56c22a-76fe-45e5-a6a2-e2bda087d7bb">
.20.45.png)


## Test Cases Snaps (Using Docker)

![](../Desktop/Screenshot 2024-04-<img width="322" alt="Screenshot 2024-04-22 at 13 47 21" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/2fd5f9df-26b0-48af-9bba-04547568a72b">
22 at 13.47.21.png)
![](../Desktop/Screenshot 2024-04<img width="331" alt="Screenshot 2024-04-22 at 13 48 00" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/9e02dc42-e405-48bb-8046-23d728a5fac6">
-22 at 13.48.00.png)

![](../Desktop/Screenshot 2024-0<img width="331" alt="Screenshot 2024-04-22 at 13 48 37" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/80f163bf-45fb-40ae-9d18-5d6ff7cfee2f">
4-22 at 13.48.37.png)
<img width="331" alt="Screenshot 2024-04-22 at 13 48 47" src="https://github.com/sanchit27/fetchcodingexercise/assets/18355760/f344d714-8ed8-4cc5-a196-8d5df0186464">


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Sanchit Bhargava - [Linkedin](https://www.linkedin.com/in/sanchitsdet) 
Email: sanchitbhargava278@gmail.com
Contact: (929) 483-6162
Project Link: [https://github.com/sanchit27/fetchcodingexercise](https://github.com/sanchit27/fetchcodingexercise)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



