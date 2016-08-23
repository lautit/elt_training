function operar(n1, n2, op) {

    switch (op) {
        case "sum":
            return n1 + n2;
        case "res":
            return n1 - n2;
        case "mul":
            return n1 * n2;
        case "div":
            return n1 / n2;
    };

};

window.onload = function () {
    var calculate = document.getElementById("calculate");
    
    calculate.onclick = function () {
        var number1 = document.getElementById("number1"),
            number2 = document.getElementById("number2"),
            operate = document.getElementById("operador"),
            result = document.getElementById("result");

        number1 = parseFloat(number1.value);
        number2 = parseFloat(number2.value);

        console.log(number1);
        console.log(number2);

        result.value = operar(number1, number2, operate.selectedOptions[0].value);
    };
};

function parseNumbers() {
    return [parseFloat($('input#number1').val()),
            parseFloat($('input#number2').val())];
}

$(document).ready(function () {
    $('#calculate').click(function () {
        var number1 = parseFloat($('#number1').val()),
            number2 = parseFloat($('#number2').val()),
            operate = $('#operador').find(':selected').text();
        
        $('#result').html(operar(number1, number2, operate));
    });
    
    $('#operador').change(function () {
        var number1
    });
    
    $('#link').click(function () {
    	event.preventDefault();
    	$('#texto').html('Tubiega');
    });
});