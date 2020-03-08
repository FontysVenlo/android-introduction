# Android introduction for project 4

Introduction to Android - PRJ4 course of Fontys Venlo

## Preparation

* Install android studio version (latest), see: [Android Studio](https://developer.android.com/studio)
* Read “Everything you need to build on Android”, see: [Android Studio features](https://developer.android.com/studio/features/)
* Read and execute this introduction tutorial, starting in Chapter 5 –up to 7.4 (gridlayout is deprecated), 9 and 10: [Android Tutorial starter](http://www.vogella.com/tutorials/Android/article.html#androidstudio_starter)

## Assignment 1

* Individual deliverable, implement the following app: Based on constraint layout, this app should contain **3 rows of each 2 buttons and one image view**. If you click the first button then **same image should appear in the image view**, if you click the second button that image should change. Per row you should use different images, so in total you need 6 image resources.
More information about constraint layout you find in: [Layout information](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)
* Next you *must commit the solution to your personal assignments repository*, follow the guidelines in the document android_ignorelists.pdf. These guidelines are important, you prevent ending up your repository with al lot of generated files. In case you use subversion the principles are the same and the ignore lists also.

## Preparations
* Continue reading and executing the introduction tutorial, starting in Chapter 11 – 17.  
[Android tutorial](http://www.vogella.com/tutorials/Android/article.html#androidstudio_starter)
* List views more specific recycler views, read and execute: http://www.vogella.com/tutorials/AndroidRecyclerView/article.html
Find out what a LayoutInflater is/does.
* For more background info on recycler views  see:
[Recycler view](https://developer.android.com/guide/topics/ui/layout/recyclerview)

## Assignment 2

* Individual deliverable, implement the following app: Based on the previous discussed recycler view, create an app which **displays a list of items, each item contains a picture, 2 text views and a checkbox**. Be sure to have enough pictures, one text view should contain a person’s name, the other one some additional text.  See example, but instead of date and o/p/n mark a checkbox, which controls background colour of the item, checked is red unchecked is green.
* Recycler view uses the adapter pattern. According your Head First Design Pattern textbook this pattern comprises a client, target, adapter and adaptee. See the example discussed by A. Vogella, and indicate client, target, adapter and adaptee.
* Describe when to use a LayoutInflater, describe typical situations where you could apply layout inflaters. 
* Download example dhapp-one, install this app on your android device and run it.
The back-end is up and running, so you should be able to add and delete items.
Also solve the issues mentioned in PostTask:

![Bild](https://github.com/FontysVenlo/android-introduction/raw/master/docs/img/image.png)

*still some android issues to be solved, like updating UI from async thread
See line 52, 55, 58
Possible solution, see GetTask where id is passed as parameter in the constructor*


* Based on dhapp-one implement get, post, put, delete and getall for your own back-end entity which you already created last week.



