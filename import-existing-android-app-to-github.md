---
title: "Project 4 - Apps in the Cloud "
subtitle: "Import existing Android app to github"
author: [Stefan Sobek]
date: "2021-01-01"
subject: "Import existing Android app to github"
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

# Import existing Android app to github

You have
a locally existing Android app (just newly created Android application from Android studio), see https://github.com/FontysVenlo/android-introduction of how to do that. 
already a new and (nearly) empty github repository on github, e.g. the github classroom assignment repository

Question is how can you now put your existing Android app code into your repository?

## Make a local Git repo

First of all, make a local git repository in Android studio.

### Enable Version Control Integration

![](assets/1f4340445ef2ff00580e584e6c91395816aef8854be92b9403f3a2b929f6a045.png)

In the top menu of Android Studio, choose "Enable Version Control Integration".

### Choose Git

![](assets/37d3797ed17c7504eae6105d2024c28dff779f8e5344762445ffed7ed4f8f0cc.png)

Choose GIT from the dropdown
Press OK

Now you have a local git repository.

### Commit all files

![](assets/c76fd1191d426e48340d3c57753a884664b8f3fe50e737958395a953ceb749de.png)

Choose in the top menu "VCS"
Click on "Commit" or use as shortcut Command+K or on Windows Control+K

### Add all files and commit

![](assets/3d39fc2d1c4c8a0c8f9f8758cc20b984e6ec6a941326707664553528fc31c863.png)

Add all files by clicking the checkbox 
Add a commit message
and press Commit-Button

Now all your files are locally under Version control thus in GIT (but not remote on a server)

## Connect local Git repository to remote Git repository

Now the local git repository must be connected to the already existing remote git repository. The remote git repository is the repo which most probably was created for your assignment, e.g. URL is probably something like https://github.com/FontysVenlo/PRJ4-assignment-xxxx

You have two options, do it via command line or do it via Android Studio only.

### Add remote via command line

- Open Shell/Bash/Command Line Tool

![](assets/7a83846b198001b57e2105835e5888ff59350fcd1be3ef86f6ce4c4e8037adfc.png)

  Windows: open your command line tool by pressing Windows-key on your keyboard and then type "cmd" 
  press enter
  Mac: Open a terminal by pressing Command+Space and typing "terminal" to open the terminal.app
  press enter

- Goto the directory where your Android app is

  You can change the directory where your Android application code is by using the command on Mac:
  cd ..        for changing to upper directory
  cd Androidxxx     for changing to the directory named Androidxxx
  
  On Windows:
  
  cd..      for changing to upper directory
  cd Androidxxx     for changing to the directory named Androidxxx
  
  
  Show the content of the current directory in Windows: 
  dir
  
  Show the content of the current directory on Mac
  ls -la

	- Example on Mac

		- Show current path
		![](assets/749c084c4f3fb866d6a1bc6e4ac3133546e44d47a50cd13773b86ee6aea4d063.png)
		- Show directory content
		![](assets/6ccec1883035e69c95e22adf18814eade9b8fd6da5dbbcfc4abd02072c34ed2d.png)
		- Change directory to Android projects directory
		![](assets/614db8df3bdd60db940f1fc881dfe1f41dd3de2cec1206981f67d7e378668bfd.png)
		- Show content of Android studio projects folder
		![](assets/e663726651707f84e1b8318b7a78d708f5d9a919b8f8c9d0dc983c6eedb19d1b.png)
		- Goto your project folder
		![](assets/eff456d82c0fd7a51683f97436d8fa8ac9f3dc813333f3aa307adccef0ddf6ee.png)
		- Look up your repository URL on github![](assets/de8884d064b77a69337ffe7a43f1e213a3bae003e9fc3c096884bbe0c6794355.png)

		  Open your repository online on git and click on the  button Clone or download. 
		  Copy this url
		  This one would most probably look like 
		  https://github.com/FontysVenlo/PRJ4-xxxx

		- Goto your bash/shell/terminal
		![](assets/04eed3a8473f110be152c577436f5a38ea26d187ad245dc857640b2c7c601948.png)

		  In your bash/shell/terminal you should now fill in the following commands:
		  
		  git remote add origin https://github.com/FontysVenlo/PRJ4-xxx.git
		  
		  git remote -v
		  
		  git push origin master

### Add remote via Android Studio

- Add remote repo url
![](assets/92135895624f7baca9bf7f2e116d185c146dbede73096ba7901acc345129a106.png)
- Add the url from github
![](assets/f555d11c16c1e8a7f7aeb7a810236e6fd9365595d6e6092b785a4d479387782d.png)
- Push all your changes

	- Choose VCS push in top menu
	![](assets/5d9c509f4ad7bf170436f803ef43f2103a6498a4404d1ac8cc3f5144bfefc7d6.png)
	- Push all your changes to remote git
	![](assets/be7402a3d97bfa74b4f2921d8a525594d2357253cb077f078d0719357ccd52dd.png)

	  Click Push-button.

