---
title: "Project 4 - Apps in the Cloud "
subtitle: "Introduction to Android - Exercises"
author: [Stefan Sobek]
date: "2021-01-01"
subject: "PRJ4 - Introduction to Android - Exercises"
keywords: [Fontys, Markdown, Apps, Cloud]
lang: "en"
titlepage: "true"
logo: "images/fontyslogo.png"
titlepage-rule-color: "400070"
page-background : "images/fontyslogo-background.png"
# reveal settings
# simple black white league beige sky night serif simple solarized blood moon
theme: black
separator: <!-- s -->
verticalSeparator: <!-- v -->
notesSeparator: <!-- n -->
revealOptions:
  # None - Fade - Slide - Convex - Concave - Zoom
  transition: 'concave'
  transition-speed: fast
  slideNumber: true
  history: true
  progress: true
  width: 1248
  height: 800
  parallaxBackgroundImage: 'images/fontys-parallax-all-dark.jpg'
  parallaxBackgroundSize: '2100px 1024px'
  #autoSlide: 4000
  #loop: true

  # center: false
...
---

# Android introduction for project 4
<!-- .slide: data-background="https://media.giphy.com/media/10mzF0YmVmZNuw/giphy.gif" -->
Tutorials and exercises

<!-- s -->

## Preparation

- Install android studio version (latest)<!-- .element: class="fragment fade-down" -->
=> [Android Studio](https://developer.android.com/studio)<!-- .element: class="fragment fade-down" -->

- Read “Everything you need to build on Android”<!-- .element: class="fragment fade-down" -->
=> [Android Studio features](https://developer.android.com/studio/features/)<!-- .element: class="fragment fade-down" -->

- Read and execute the introduction tutorial (chapter 1-3 optional), starting in Chapter 4 – up to 7.4 (gridlayout is deprecated) 8, 9 and 10:<!-- .element: class="fragment fade-down" -->
=> [Android Tutorial starter](http://www.vogella.com/tutorials/Android/article.html#androidstudio_starter)<!-- .element: class="fragment fade-down" -->

- ⚠ How to put your local code into github<!-- .element: class="fragment fade-down" -->
=> [import existing android app to github](import-existing-android-app-to-github.md)<!-- .element: class="fragment fade-down" -->

<!-- s -->

## Assignment 1

- Individual deliverable => implement the following app:<!-- .element: class="fragment fade-down" -->
- Based on constraint layout, this app should contain<!-- .element: class="fragment fade-down" -->

**3 rows of each 2 buttons and one image view**<!-- .element: class="fragment fade-down" -->
- If you click the first button then<!-- .element: class="fragment fade-down" -->

**same image should appear in the image view**<!-- .element: class="fragment fade-down" -->
- if you click the second button that image should change.<!-- .element: class="fragment fade-down" -->
- Per row you should use different images, so in total you need 6 image resources.<!-- .element: class="fragment fade-down" -->
- More information about constraint layout you find <!-- .element: class="fragment fade-down" -->
=> [Layout information](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)<!-- .element: class="fragment fade-down" -->

<!-- s -->

**You must commit the solution to your personal assignments repository**

[➡ Individual Repository](https://classroom.github.com/a/a9PfAFrI)<!-- .element: class="fragment fade-down" -->

<!-- s -->

## Preparations

- Continue reading and executing the introduction tutorial, starting in Chapter 11 – 17.<!-- .element: class="fragment fade-down" -->  

[➡ Android tutorial](http://www.vogella.com/tutorials/Android/article.html#androidstudio_starter)<!-- .element: class="fragment fade-down" -->

- List views - more specific recycler views, read and execute:<!-- .element: class="fragment fade-down" -->

[➡ Android Recycler View](http://www.vogella.com/tutorials/AndroidRecyclerView/article.html) <!-- .element: class="fragment fade-down" -->

- Find out what a LayoutInflater is/does.<!-- .element: class="fragment fade-down" -->

- For more background info on recycler views: <!-- .element: class="fragment fade-down" -->

[➡ Recycler view](https://developer.android.com/guide/topics/ui/layout/recyclerview)<!-- .element: class="fragment fade-down" -->

<!-- s -->

## Assignment 2

- Individual deliverable => implement the following app:<!-- .element: class="fragment fade-down" -->

- Based on the previous discussed recycler view, create an app which<!-- .element: class="fragment fade-down" -->

**displays a list of items 📄, each item contains a picture 🖼, 2 text views 📃 and a checkbox ☑**<!-- .element: class="fragment fade-down" -->

- Be sure to have enough pictures, one text view should contain a person’s name, the other one some additional text. <!-- .element: class="fragment fade-down" -->
- See example, but instead of date and o/p/n mark a checkbox ☑, which controls background colour of the item, checked is red 🟥 unchecked is green 🟩.<!-- .element: class="fragment fade-down" -->

<!-- s -->

- Recycler view uses the adapter pattern.

According your Head First Design Pattern textbook this pattern comprises a client, target, adapter and adaptee. See the example discussed by A. Vogella, and indicate client, target, adapter and adaptee.

<!-- s -->

- Describe when to use a LayoutInflater, describe typical situations where you could apply layout inflaters.

<!-- s -->
Make sure you do<!-- .element: class="fragment fade-down" -->

**all assignments from the Vogella Android tutorial!**<!-- .element: class="fragment fade-down" -->

which are<!-- .element: class="fragment fade-down" -->

- [Exercise first UI](https://www.vogella.com/tutorials/Android/article.html#exercise_first_ui_interface) <!-- .element: class="fragment fade-down" -->
- [Exercise add radio buttons](https://www.vogella.com/tutorials/Android/article.html#exercise-adding-radio-buttons) <!-- .element: class="fragment fade-down" -->
- [Exercise temperature converter](https://www.vogella.com/tutorials/Android/article.html#tutorialtemperature)<!-- .element: class="fragment fade-down" -->

<!-- s -->

## Assignment 3

> Consume a local REST-API (Presidents)<!-- .element: class="fragment fade-down" -->

<!-- s -->

### Preparation

For this assignment you will just run an easy REST-API based on the president database. This will be run locally!<!-- .element: class="fragment fade-down" -->

(used that in PPAR as well)<!-- .element: class="fragment fade-down" -->

<!-- s -->

For the setup, do the following steps:<!-- .element: class="fragment fade-down" -->

[Clone: https://github.com/FontysVenlo/president-postgrest-restapi](https://github.com/FontysVenlo/president-postgrest-restapi)<!-- .element: class="fragment fade-down" -->

Start the application with:<!-- .element: class="fragment fade-down" -->

```bash
docker-compose up
```
<!-- .element: class="fragment fade-down" -->

or<!-- .element: class="fragment fade-down" --> 

```bash
docker-compose up -d
```
<!-- .element: class="fragment fade-down" -->

for daemon mode.<!-- .element: class="fragment fade-down" -->

<!-- s -->

Goto http://localhost:8080 for your swagger api documentation.

The REST-API is available via http://localhost:3000

Now you are ready.

<!-- s -->

### Test your API with Swagger

- Goto your local [Swagger UI](http://localhost:8080/)
- Test your API if you want:

![Swagger](images/swagger.jpg)

<!-- s -->

- Scroll down and click on execute:

![Swagge execute](images/swagger-02.jpg)

<!-- s -->
- Scroll down and see the JSON result:

![Swagger JSON result](images/swagger-03.jpg)

👍

<!-- s -->

- Read and execute Chapter 1-5: <!-- .element: class="fragment fade-down" -->
[➡ Using Retrofit 2.x as REST client - Tutorial](https://www.vogella.com/tutorials/Retrofit/article.html)<!-- .element: class="fragment fade-down" -->

- Read and execute exercise Chapter 8: 
[➡ Exercise: Using Retrofit to access GitHub API in Android](https://www.vogella.com/tutorials/Retrofit/article.html#exercise-using-retrofit-to-access-github-api-in-android)

<!-- s -->

### Assigment 

- Create a UI and consume the REST-API under <!-- .element: class="fragment fade-down" -->

http://localhost:3000 <!-- .element: class="fragment fade-down" -->

to receive all the presidents.<!-- .element: class="fragment fade-down" -->

**Show a list of all presidents in your Android App**<!-- .element: class="fragment fade-down" -->

<!-- s -->

**Push all assignments to your individual repository**

🖥 ➡ 📄 👀