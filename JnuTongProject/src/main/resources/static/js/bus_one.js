var submit = document.getElementById("bt");
var list = document.getElementById("opt");

submit.onclick = function () {
    var listText = list.options[list.selectedIndex].text;
    if (listText == "학기중") {
        alert("학기중");
    } else if (listText == "방학/공휴일") {
        alert("방학/공휴일");
    } else if ("선택") {
        var bustable = document.getElementById("busSchedule").innerHTML = "<table>\n" +
            "                            <h4>제주버스 스케줄</h4>\n" +
            "                            <tr>\n" +
            "                                <th>스케줄No</th>\n" +
            "                                <th>노선ID</th>\n" +
            "                                <th>출발시간</th>\n" +
            "                                <th>평일/휴일</th>\n" +
            "                            </tr>\n" +
            "                            <tr th:each=\"busSchedule : ${busScheduleList}\">\n" +
            "                                <td th:text=\"${busSchedule.scheduleNo}\"></td>\n" +
            "                                <td th:text=\"${busSchedule.lineId}\"></td>\n" +
            "                                <td th:text=\"${busSchedule.departureTime}\"></td>\n" +
            "                                <td th:text=\"${busSchedule.day}\"></td>\n" +
            "                            </tr>\n" +
            "                        </table>";

        return bustable;
    }

};