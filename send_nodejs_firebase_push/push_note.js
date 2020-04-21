var FCM = require('fcm-push');

var serverkey = '';

var fcm = new FCM(serverkey);
var message = {
    // app package name: com.example.dos.simplefirebase
    to : '',
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

fcm.send(message, function(err,response){  
    if(err) {
        console.log("Something has gone wrong !", err);
    } else {
        console.log("Successfully sent with response :",response);
    }
});
