function timeFunction()
{
    var today = new Date();
    var hourNow = today.getHours();
    var minuteNow = today.getMinutes();
    var secondNow = today.getSeconds();
    minuteNow = checkTime(minuteNow);
    secondNow = checkTime(secondNow);

    var greeting = "GOOD ";

    if (0 <= hourNow && hourNow < 12) {
        greeting += "MORNING";
    }
    else if (12 <= hourNow && hourNow < 18) {
        greeting += "AFTERNOON";
    }
    else if (18 <= hourNow) {
        greeting += "EVENING";
    }

    document.getElementById("timeh4").innerHTML = greeting + "<br>" + hourNow + ":" +
        minuteNow + ":" + secondNow;
}
    /////////////////////////////////////////////////////////////////////////////////////