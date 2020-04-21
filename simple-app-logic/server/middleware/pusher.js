var FCM = require('fcm-push');

// copy your server key
var serverkey = '';

var fcm = new FCM(serverkey);
var message = {
    // copy your device id
    to : '',

    collapse_key : 'collapse-key',
    data : {
        hallo : 'allemaal',
        wereld : 'is rond'
    },
    notification : {
        title : 'Hello TIK class',
        body : 'It works'
    }
};

module.exports = function() {
  return function pusher(req, res, next) {
    console.log('Request pusher trigggered on %s.', req.url);

    fcm.send(message, function(err,response){  
        if(err) {
            console.log("Something has gone wrong !", err);
        } else {
            console.log("Successfully sent with response :",response);
        }
    });
    
    next();
  };
};
  