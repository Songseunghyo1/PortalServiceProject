var no = $(".schedule_no");
var line = $(".schedule_line");
var time = $(".schedule_time");
var day = $(".schedule_day");

var noList = [];
for(i  = 0; i < no.length; i++) {
    var noObj = no[i]
    noList.push(noObj.innerText);
}

var lineList = [];
for(i  = 0; i < line.length; i++) {
    var lineObj = line[i]
    lineList.push(lineObj.innerText);
}

var timeList = [];
for(i  = 0; i < time.length; i++) {
    var timeObj = time[i]
    timeList.push(timeObj.value);
}

var dayList = [];
for(i  = 0; i < day.length; i++) {
    var dayObj = day[i]
    dayList.push(dayObj.value);
}

console.log(noList);
console.log(lineList);
console.log(timeList);
console.log(dayList);

var scheduleList = [];
for(i = 0; i < noList.length; i++){
    var schedule = {
        "scheduleNo" : noList[i],
        "lineId" : lineList[i],
        "departureTime" : timeList[i],
        "day" : dayList[i]
    };
    scheduleList[i] = schedule;
}

console.log(scheduleList)

var jsonStr = JSON.stringify(scheduleList);
console.log("jsonStr : " + jsonStr);

$.ajax({
    url : '/bus_one/editweekday'
    , method : "post"
    , dataType : 'json'
    , data : jsonStr
    , processData : true /*querySTring make false*/
    , contentType : "application/json; charset=UTF-8"
    , success : function(data, stat, xhr) {
        alert("success");
    }
    , error : function(xhr, stat, err) {
        alert("error");
        console.log(err);
    }
});
