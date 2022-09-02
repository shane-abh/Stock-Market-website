
var inter1,inter2,inter3,inter4,inter5;

//These are start/stop functions which is used to acquire data and a timer is 
//set for 5 seconds and it check the price after every 5 s

function start1(){
    
    inter1 = setInterval(function(){
    var id= document.getElementById('alert_p1').value;
    var stoploss1= document.getElementById('stoploss1').value;
    var id2= document.getElementById('st1').value;
    var setbtn = document.getElementById('start_btn1');
    setbtn.disabled = true;
    setbtn.style.backgroundColor = '#B6D1D3';

    console.log(id);
    console.log(stoploss1);
    console.log(id2);

    checkPrice(id,id2,'currentPrice1',stoploss1);
    },5000);
}

function start2(){
    
    inter2 = setInterval(function(){
    var id= document.getElementById('alert_p2').value;
    var stoploss2= document.getElementById('stoploss2').value;
    var id2= document.getElementById('st2').value;
    var setbtn = document.getElementById('start_btn2');
    setbtn.disabled = true;
    setbtn.style.backgroundColor = '#B6D1D3';

    console.log(id);
    console.log(stoploss2);
    console.log(id2);

    checkPrice(id,id2,'currentPrice2',stoploss2);
    },5000);
}

function start3(){
    
    inter3 = setInterval(function(){
    var id= document.getElementById('alert_p3').value;
    var stoploss3= document.getElementById('stoploss3').value;
    var id2= document.getElementById('st3').value;
    var setbtn = document.getElementById('start_btn3');
    setbtn.disabled = true;
    setbtn.style.backgroundColor = '#B6D1D3';

    console.log(id);
    console.log(stoploss3);
    console.log(id2);

    checkPrice(id,id2,'currentPrice3',stoploss3);
    },5000);
}

function start4(){
    
    inter4 = setInterval(function(){
    var id= document.getElementById('alert_p4').value;
    var stoploss4= document.getElementById('stoploss4').value;
    var id2= document.getElementById('st4').value;
    var setbtn = document.getElementById('start_btn4');
    setbtn.disabled = true;
    setbtn.style.backgroundColor = '#B6D1D3';

    console.log(id);
    console.log(stoploss4);
    console.log(id2);

    checkPrice(id,id2,'currentPrice4',stoploss4);
    },5000);
}

function start5(){
    
    inter5 = setInterval(function(){
    var id= document.getElementById('alert_p5').value;
    var stoploss5 = document.getElementById('stoploss5').value;
    var id2= document.getElementById('st5').value;
    var setbtn = document.getElementById('start_btn5');
    setbtn.disabled = true;
    setbtn.style.backgroundColor = '#B6D1D3';

    console.log(id);
    console.log(stoploss5);
    console.log(id2);

    checkPrice(id,id2,'currentPrice5',stoploss5);
    },5000);
}

function stop1(){
    clearInterval(inter1);
    var setbtn = document.getElementById('start_btn1');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}

function stop1(){
    clearInterval(inter1);
    var setbtn = document.getElementById('start_btn1');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}

function stop2(){
    clearInterval(inter2);
    var setbtn = document.getElementById('start_btn2');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}

function stop3(){
    clearInterval(inter3);
    var setbtn = document.getElementById('start_btn3');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}

function stop4(){
    clearInterval(inter4);
    var setbtn = document.getElementById('start_btn4');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}

function stop5(){
    clearInterval(inter5);
    var setbtn = document.getElementById('start_btn5');
    setbtn.style.backgroundColor = '#4CAF50';
    setbtn.disabled = false;
    
}


//This funtion is used to play the notification sound and alert the user
function playSound(url) {
  const audio = new Audio(url);
  audio.play();
}

//This funtion checks the value on the input box and checks if the price has reached the limit or not
function checkPrice(id,id2,curPrice,stoploss){
    
    console.log(id2);
    const yfinance = new XMLHttpRequest();
        const url = 'https://yfapi.net/v6/finance/quote?region=US&lang=en&symbols='+id2;

        yfinance.open('GET', url, true);
        yfinance.setRequestHeader('accept', 'application/json');
        yfinance.setRequestHeader('x-api-key', '1EgZS2cGiVudYiR2AHSK443TdsYUeCX3XPu84Yd7');
      

        yfinance.onload = function () {
            var  d = JSON.parse(this.response);

            
            var price = d.quoteResponse.result[0].regularMarketPrice;
            var x = document.getElementById(curPrice);
            x.style.color = "black";
            x.innerHTML = price;
            x.style.fontSize = "large";
           
            if (parseFloat(price)>=id){
                playSound('sounds/iPhone Notification Sound.mp3');
                console.log(price + ' Upper Limit ');
                x.style.color = "green";
                x.style.fontWeight = "bold";
                x.style.fontSize = "x-large";
                
            }else{
            console.log("Not reached");
            }
            
            if (parseFloat(price)<stoploss){
                playSound('sounds/Lower_limit.mp3');
                console.log(price+' Lower Limit ');
                x.style.color = "red";
                x.style.fontWeight = "bold";
                x.style.fontSize = "x-large";

            }else{
               console.log("Not reached"); 
            }
            
        };
        yfinance.send();
}