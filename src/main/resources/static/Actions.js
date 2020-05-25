function time() {
    var start, end, result, first, second, date;
    start = document.getElementById("startDate");
    end = document.getElementById("endDate");

    date = start.value.split("-", 3);
    first = new Date(date[0], date[1], date[2]);

    date = end.value.split("-", 3);
    second = new Date(date[0], date[1], date[2]);

    result = (((((second.getTime() - first.getTime())/1000)/60)/60)/24);
    document.contract.totalDays.value = result;
}