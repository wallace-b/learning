function anotherAddEventListener(typeOfEvent, callback) {

  var eventThatHappened = {
    eventType: "keydown",
    key: "p",
  }

  if (eventThatHappened.eventType === typeOfEvent) {
    callback(eventThatHappened);
  }
};

anotherAddEventListener("keydown", function(event) {
  console.log(event);
});
