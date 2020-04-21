# Android push notifications

This tutorial explains how to implement android push notifications using a nodejs backend.

For a better understanding we split this in three steps:

- notification-to-android
- nodejs-sends-notification
- loopback-app-logic.

Firstly we will discuss sending messages to backgrounded app, in section 4 we will briefly address messages to foregrounded apps.§

## Notification to android app

First set up your android client:

<https://firebase.google.com/docs/cloud-messaging/android/client>

For step 1 see also:

<https://firebase.google.com/docs/cloud-messaging/android/first-message>

which explains how to send a message to a backgrounded app.

![2020-04-21 at 10 08](https://user-images.githubusercontent.com/764295/79841732-223f0d00-83b8-11ea-8b57-4b0e214eef7e.png)

Example code [android-simplefirebase](/SimpleFireBase)

Next send messages to multiple devices, see:

<https://firebase.google.com/docs/cloud-messaging/android/send-multiple>

After subscribing an app for a specific topic, you can test.

To test "Subscribe the client app to a topic" use the firebase console: 
- Cloud Messaging -\> New Notification -\> step 1 -\>next -\> in target select topic -\> next -\> in Scheduling set "Send to eligible users" to Now -\> Review -\> Publish.

See example code [android-lesssimplefirebase](/LessSimpleFireBase).

## Nodejs sends push notification request

You already have a firebase project. For this part you need the device id and the server key.

The first one already obtained in section "Retrieve the current registration token" of <https://firebase.google.com/docs/cloud-messaging/android/first-message>.

The server key is your firebase server key. Open [https://console.firebase.google.com](https://console.firebase.google.com).

Go to the Project Settings tab CLOUD MESSAGING, if not already done, add a server key by pushing the ADD SERVER KEY button.

Copy and past the server key.

![send-nodes-firebase-push](https://user-images.githubusercontent.com/764295/79841875-531f4200-83b8-11ea-9bb5-514663528ab8.png)

Set up a nodejs folder (in my case) send\_nodejs\_firebase\_push, cd to this folder.

See example code [android-send_nodejs_firebase_push](/send_nodejs_firebase_push).

\$ cd send\_nodejs\_firebase\_push

Create and edit a nodejs file (in my case) **push\_note.js**, this file should have the following content:

```javascript
var FCM = require('fcm-push');

var serverkey = '.....O.; // your server key var fcm = new FCM(serverkey);

var message = {
  to : '......', // your android device id collapse_key : 'collapse-key',
  data : {
    hallo : 'allemaal',
    wereld : 'is rond' },
    notification : {
      title : 'Title of the notification', body : 'Body of the notification'
    }
  };
    
  fcm.send(message, function(err,response){ if(err) {
     console.log("Something has gone wrong !", err); } else {
     console.log("Successfully sent with response :",response); 
  }
});
```
Execute:

\$ npm install fcm-push

\$ node push\_note

Response is like the following json string

Successfully sent with response : {\"multicast\_id\":6834835332327396821,\"success\":1,\"failure\":0,\"canonical\_ids\":0,\"results\":\[{\"message\_id\":\"0:1555511063680783%a7a2e6b0a7a2e6b0\"}\]}

## Loopback application logic
 
Download example: [android-simple-app-logic](/simple-app-logic) 

![2020-04-21 at 10 11](https://user-images.githubusercontent.com/764295/79842037-9679b080-83b8-11ea-877c-e2e9b8b4c04b.png)

Affected folders/files:

\- server/middleware.json

\- server/middleware/tracker.js

Suppose you have created a nodejs app with two models Car and Employee like in simple simple-app-logic.zip.

The middleware folder is going to contain the application logic, in this case trackter.js, which just prints some logging info.

Please note: middleware should be a sub folder of the server folder.

```javascript
// tracker.js

module.exports = function() {
  return function tracker(req, res, next) {

    console.log(\'Request tracking middleware triggered on %s.\', req.url);

    var start = process.hrtime();

    res.once(\'finish\', function() {
      var diff = process.hrtime(start);
      var ms = diff\[0\] \* 1e3 + diff\[1\] \* 1e-6;
      console.log(\'The request processing time is %d ms.\', ms)
    });

    next();

  };
};
```
And the \"initial\" entry in middleware.json has been extended as follows:
```javascript
// middleware.json
//..
    "initial": {
        "./middleware/tracker": {
        "paths" : ["/api/Employees"],
        "methods" : ["POST"]
    },

//..
}
```
The app logic will be executed when a http POST request is executed on **/api/Employees**.

Next adding push notification logic, but first run in the app folder:

\$ npm install fcm-push

Extend the initial entry of middleware.json with:
```javascript
"./middleware/pusher": {
    "paths" : ["/api/Employees"],
    "methods" : ["POST"]
},
```
And add pusher.js to the middleware folder:
```javascript
//pusher.js
var FCM = require(\'fcm-push\');
var serverkey = \'\.....\';
var fcm = new FCM(serverkey);
var message = {
    to : '.....',
    collapse_key : 'collapse-key',
    data : {
        hallo : 'allemaal',
        wereld : 'is rond'
    },
    notification : {
        title : 'Title of the notification',
        body : 'Body of the notification'
    }
};

module.exports = function() {
    return function pusher(req, res, next) {
    console.log('Request pusher trigggered on %s.', req.url);

    fcm.send(message, function(err,response) {

        if(err) {
            console.log("Something has gone wrong !", err); 
        } else {

        console.log("Successfully sent with response :",response);

        }

    });

    next();

    };

};
````


## Foregrounded apps

See

<https://www.codementor.io/flame3/send-push-notifications-to-android-with-firebase-du10860kb>

section 4.1 and see [android-lesssimplefirebase](/LessSimpleFireBase) and [android-simplefirebase](/SimpleFireBase)

To receive messages in a foregrounded app should extend the **FirebaseMessagingService** class like:
```java
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";
    
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and
        // notification messages here.
        // Also if you intend on generating your own notifications as a
        // result of a received FCM
        // message, here is where that should be initiated.
        
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        
        final String msg = remoteMessage.getNotification().getBody();
        
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
      
            @Override
            public void run() {        
                Toast.makeText(getApplicationContext(),            
                msg,Toast.LENGTH_SHORT).show();        
            }
        
        });
    
    }

}
```

**Toast.makeText()** should run on the main ui thread, Looper solves this issue.

Register this class in **AndroidManifest.xml** file, like:
```xml
<service android:name=".MyFirebaseMessagingService" >
    <intent-filter>
        <action android:name="com.google.firebase.MESSAGING_EVENT" />
    </intent-filter>
</service>
```


## References

<http://loopback.io/doc/en/lb3/Adding-application-logic.html>

<http://loopback.io/doc/en/lb3/Defining-middleware.html>

<https://porter.io/github.com/strongloop/loopback-example-app-logic>

<https://firebase.google.com/docs/cloud-messaging/android/client>

<https://firebase.google.com/docs/cloud-messaging/android/first-message>

<https://www.codementor.io/flame3/send-push-notifications-to-android-with-firebase-du10860kb>
