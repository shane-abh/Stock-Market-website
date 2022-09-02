
var str = document.getElementById('searchContent').value; //String to store the searched symbol for the API
console.log(document.getElementById('searchContent').value);

var str1; //String used to store the company name in the heading of the chart

window.onload = function () {
    
    var dps1 = [], dps2= [];
    var stockChart = new CanvasJS.StockChart("chartContainer",{
      theme: "light2",
      exportEnabled: true,
      title:{
        text: str1
      },
      subtitles: [{
        text: str +" Price (in USD)"
      }],
      charts: [{
        axisX: {
          crosshair: {
            enabled: true,
            snapToDataPoint: true
          }
        },
        axisY: {
          prefix: "$"
        },
        data: [{
          type: "line",
          yValueFormatString: "$#,###.##",
          dataPoints : dps2
        }]
      }]
     
    });

    

      //API Call to get the chart data
      const yfinance = new XMLHttpRequest();
      const url = 'https://yfapi.net/v8/finance/chart/'+str+'?range=1d&region=US&interval=1m&lang=en';

      yfinance.open('GET', url, true);
      yfinance.setRequestHeader('accept', 'application/json');
      yfinance.setRequestHeader('x-api-key', 'JqFd3HDR5z6iR67p6O9PDLjrvAZtexr255MsgBKa');
      

      yfinance.onload = function () {
        const d = JSON.parse(this.response);
        
        arr = d.chart.result[0].indicators.quote[0].close;
        time = d.chart.result[0].timestamp;
               
        
        for (let i = 0; i < time.length; i++) {
          dps2.push({x:new Date(time[i]*1000), y: arr[i]});

                
        }
      stockChart.render();

        
      };
      yfinance.send();




//API function to get the price chart details of the day/month/year
function graph(cal,url){
  document.getElementById(cal).onclick = function(){
    var dps1 = [], dps2= [];
    var stockChart = new CanvasJS.StockChart("chartContainer",{
      theme: "light2",
      exportEnabled: true,
      title:{
        text: str1
      },
      subtitles: [{
        text: str +" Price (in USD)"
      }],
      charts: [{
        axisX: {
          crosshair: {
            enabled: true,
            snapToDataPoint: true
          }
        },
        axisY: {
          prefix: "$"
        },
        data: [{
          type: "line",
          yValueFormatString: "$#,###.##",
          dataPoints : dps2
        }]
      }]
      
    });

      const yfinance = new XMLHttpRequest();
      
      yfinance.open('GET', url, true);
      yfinance.setRequestHeader('accept', 'application/json');
      yfinance.setRequestHeader('x-api-key', 'JqFd3HDR5z6iR67p6O9PDLjrvAZtexr255MsgBKa');
      

      yfinance.onload = function () {
        const d = JSON.parse(this.response);
        
        arr = d.chart.result[0].indicators.quote[0].close;
        time = d.chart.result[0].timestamp;
        console.log('graph');
        
        
        for (let i = 0; i < time.length; i++) {
          dps2.push({x:new Date(time[i]*1000), y: arr[i]});

                
        }
      stockChart.render();

        
      };
      yfinance.send();
    };
}


graph('day','https://yfapi.net/v8/finance/chart/'+str+'?range=1d&region=US&interval=1m&lang=en');
graph('month','https://yfapi.net/v8/finance/chart/'+str+'?range=1y&region=US&interval=1d&lang=en');
graph('year','https://yfapi.net/v8/finance/chart/'+str+'?range=max&region=US&interval=1d&lang=en');



};





//Function to fill the company name, price, and such details which get refreshed every two seconds 

function yfinanc() {
    var yfinance = new XMLHttpRequest();
   
    url = 'https://yfapi.net/v6/finance/quote?region=US&lang=en&symbols='+str;
    console.log(url);
    yfinance.open('GET', url, true);
    yfinance.setRequestHeader('accept', 'application/json');
    yfinance.setRequestHeader('x-api-key', 'JqFd3HDR5z6iR67p6O9PDLjrvAZtexr255MsgBKa');
    
    yfinance.onload = function () {
        // Begin accessing JSON data here
        var d = JSON.parse(this.response);
                
        var compName = d.quoteResponse.result[0].longName;
        str1=compName;
        var sym = d.quoteResponse.result[0].symbol;
        var price = d.quoteResponse.result[0].regularMarketPrice;
        
        var mchange=d.quoteResponse.result[0].regularMarketChange;
        mchange = mchange.toFixed(2);

        var pchange = d.quoteResponse.result[0].regularMarketChangePercent;
        pchange = pchange.toFixed(3);
        
        
        document.getElementById("compName").innerHTML = compName;
        document.getElementById("title").innerHTML = compName;
        document.getElementById("symbol").innerHTML = sym;
        document.getElementById("price").innerHTML = price ;
        document.getElementById("pchange").innerHTML = mchange + " ("+pchange+"%)" ;

    };
    
     yfinance.send(); 
}

setInterval(yfinanc,2000);

//Function to control the tabs in HTML
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}




//Function to get the stock summary data using the API and fill in the html fields
function stock_summary(){
  url = 'https://yfapi.net/v6/finance/quote?region=US&lang=en&symbols='+str;

  var summary = new XMLHttpRequest();
  summary.open('GET', url, true);
  summary.setRequestHeader('accept', 'application/json');
  summary.setRequestHeader('x-api-key', 'JqFd3HDR5z6iR67p6O9PDLjrvAZtexr255MsgBKa');
  summary.onload = function(){
    var d = JSON.parse(this.response);
    

    var regularMarketPreviousClose = d.quoteResponse.result[0].regularMarketPreviousClose;
    var regularMarketOpen  = d.quoteResponse.result[0].regularMarketOpen;
    var regularMarketDayRange = d.quoteResponse.result[0].regularMarketDayRange;
    var regularMarketChange = d.quoteResponse.result[0].regularMarketChange;
    var ask = d.quoteResponse.result[0].ask;
    var bid = d.quoteResponse.result[0].bid;
    var fiftyTwoWeekRange = d.quoteResponse.result[0].fiftyTwoWeekRange;
    var fiftyDayAverageChange = d.quoteResponse.result[0].fiftyDayAverageChange;
    var twoHundredDayAverage = d.quoteResponse.result[0].twoHundredDayAverage;
    var twoHundredDayAverageChange = d.quoteResponse.result[0].twoHundredDayAverageChange;
    var epsCurrentYear = d.quoteResponse.result[0].epsCurrentYear;
    var epsTrailingTwelveMonths = d.quoteResponse.result[0].epsTrailingTwelveMonths;

    document.getElementById('regularMarketPreviousClose').innerHTML = regularMarketPreviousClose;
    document.getElementById('regularMarketOpen').innerHTML = regularMarketOpen;
    document.getElementById('regularMarketDayRange').innerHTML = regularMarketDayRange ;
    document.getElementById('regularMarketChange').innerHTML = regularMarketChange;
    document.getElementById('ask').innerHTML = ask;
    document.getElementById('bid').innerHTML = bid;
    document.getElementById('fiftyTwoWeekRange').innerHTML = fiftyTwoWeekRange;
    document.getElementById('fiftyDayAverageChange').innerHTML = fiftyDayAverageChange;
    document.getElementById('twoHundredDayAverage').innerHTML = twoHundredDayAverage;
    document.getElementById('twoHundredDayAverageChange').innerHTML = twoHundredDayAverageChange;
    document.getElementById('epsCurrentYear').innerHTML = epsCurrentYear;
    document.getElementById('epsTrailingTwelveMonths').innerHTML = epsTrailingTwelveMonths;
    
    

  };
  summary.send();
}
stock_summary();

//Function to get the company overview data using the API and fill in the html fields
function company_overview(){
  url = 'https://www.alphavantage.co/query?function=OVERVIEW&symbol='+str+'&apikey=OOEPKQDKWRUGS4HV';

  var comp = new XMLHttpRequest();
  comp.open('GET', url, true);  
  comp.onload = function(){
    var d = JSON.parse(this.response);
    console.log(d.Description);
    document.getElementById('comp_overview').innerHTML = d.Description;
  };
  comp.send();
}
company_overview();


//Function to get the financial analysis data using the API and fill in the html fields
function financial_analysis(){
  url = 'https://yfapi.net/v11/finance/quoteSummary/'+str+'?lang=en&region=US&modules=financialData%20';

  var fin = new XMLHttpRequest();
  fin.open('GET', url, true);
  fin.setRequestHeader('accept', 'application/json');
  fin.setRequestHeader('x-api-key', 'JqFd3HDR5z6iR67p6O9PDLjrvAZtexr255MsgBKa');
  fin.onload = function(){
    var d = JSON.parse(this.response);

    // console.log(d.quoteSummary.result[0].financialData.recommendationKey);

    var recommendationKey = d.quoteSummary.result[0].financialData.recommendationKey;
    var totalCash = d.quoteSummary.result[0].financialData.totalCash.fmt;
    var totalCashPerShare = d.quoteSummary.result[0].financialData.totalCashPerShare.fmt;
    var ebitda = d.quoteSummary.result[0].financialData.ebitda.fmt;
    var totalDebt = d.quoteSummary.result[0].financialData.totalDebt.fmt;
    var quickRatio = d.quoteSummary.result[0].financialData.quickRatio.fmt;
    var currentRatio = d.quoteSummary.result[0].financialData.currentRatio.fmt;
    var totalRevenue = d.quoteSummary.result[0].financialData.totalRevenue.fmt;
    var debtToEquity = d.quoteSummary.result[0].financialData.debtToEquity.fmt;
    var revenuePerShare = d.quoteSummary.result[0].financialData.revenuePerShare.fmt;
    var returnOnAssets = d.quoteSummary.result[0].financialData.returnOnAssets.fmt;
    var returnOnEquity = d.quoteSummary.result[0].financialData.returnOnEquity.fmt;
    var grossProfits = d.quoteSummary.result[0].financialData.grossProfits.fmt;
    var freeCashflow = d.quoteSummary.result[0].financialData.freeCashflow.fmt;
    var operatingCashflow = d.quoteSummary.result[0].financialData.operatingCashflow.fmt;
    var earningsGrowth = d.quoteSummary.result[0].financialData.earningsGrowth.fmt;
    var revenueGrowth = d.quoteSummary.result[0].financialData.revenueGrowth.fmt;
    var grossMargins = d.quoteSummary.result[0].financialData.grossMargins.fmt;
    var ebitdaMargins = d.quoteSummary.result[0].financialData.ebitdaMargins.fmt;
    var operatingMargins = d.quoteSummary.result[0].financialData.operatingMargins.fmt;
    var profitMargins = d.quoteSummary.result[0].financialData.profitMargins.fmt;

    document.getElementById('recommendationKey').innerHTML = recommendationKey;
    document.getElementById('totalCash').innerHTML = totalCash;
    document.getElementById('totalCashPerShare').innerHTML = totalCashPerShare;
    document.getElementById('ebitda').innerHTML = ebitda;
    document.getElementById('totalDebt').innerHTML = totalDebt;
    document.getElementById('quickRatio').innerHTML = quickRatio;
    document.getElementById('currentRatio').innerHTML = currentRatio;
    document.getElementById('totalRevenue').innerHTML = totalRevenue;
    document.getElementById('debtToEquity').innerHTML = debtToEquity;
    document.getElementById('revenuePerShare').innerHTML = revenuePerShare;
    document.getElementById('returnOnAssets').innerHTML = returnOnAssets;
    document.getElementById('returnOnEquity').innerHTML = returnOnEquity;
    document.getElementById('grossProfits').innerHTML = grossProfits;
    document.getElementById('freeCashflow').innerHTML = freeCashflow;
    document.getElementById('operatingCashflow').innerHTML = operatingCashflow;
    document.getElementById('earningsGrowth').innerHTML = earningsGrowth;
    document.getElementById('revenueGrowth').innerHTML = revenueGrowth;
    document.getElementById('grossMargins').innerHTML = grossMargins;
    document.getElementById('ebitdaMargins').innerHTML = ebitdaMargins;
    document.getElementById('operatingMargins').innerHTML = operatingMargins;
    document.getElementById('profitMargins').innerHTML = profitMargins;
    
  };
  fin.send();

}
financial_analysis();
