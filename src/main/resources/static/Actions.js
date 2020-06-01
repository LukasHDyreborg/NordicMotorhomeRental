function time() {
    var start, end, result, first, second, date;
    start = document.getElementById("fromDate");
    end = document.getElementById("toDate");

    date = start.value.split("-", 3);
    first = new Date(date[0], date[1], date[2]);

    date = end.value.split("-", 3);
    second = new Date(date[0], date[1], date[2]);

    result = (((((second.getTime() - first.getTime())/1000)/60)/60)/24);
    document.contract.numberOfDays.value = result;
}