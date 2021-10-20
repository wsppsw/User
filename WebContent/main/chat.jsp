<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String aa = request.getParameter("aa");
	String bb = request.getParameter("bb");
	String cc = request.getParameter("cc");
	String dd = request.getParameter("dd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

body {
	background-image: url(../images/bg4.jpg);
}

</style>
</head>
<body>

	<button onclick="drawChart()">显示</button>


	<button onclick="downloadSVG();">下载网页版</button>


	<button onclick="downloadPNG();">下载图片版</button>


	<button onclick="removeChart();">删除</button>

	<input type="text" style="display: none;" id="aa" value="<%=aa%>">
	<input type="text" style="display: none;" id="bb" value="<%=bb%>">
	<input type="text" style="display: none;" id="cc" value="<%=cc%>">
	<input type="text" style="display: none;" id="dd" value="<%=dd%>">


	<div id="chartDiv"></div>

	<script src='../js/js/jquery.min.js'></script>
	<script src='../js/js/d3.min.js'></script>
	<script>
//sample data


	var aa = document.getElementById("aa").value;
	var bb = document.getElementById("bb").value;
	var cc = document.getElementById("cc").value;
	var dd = document.getElementById("dd").value;
	

var pieData = [{
  "label": "分数在1~59 ",
  "series1": dd
}, {
  "label": "分数在60~79 ",
  "series1": cc
}, {
  "label": "分数在80~89 ",
  "series1": bb
}, {
  "label": "分数在90~100 ",
  "series1": aa
}];

//======================================================

function drawChart() { // wrapper, make sure one chart only
  if ($("#chartDiv").html() == "") {
    makePieChart(pieData);
  } else {
    removeChart();
    makePieChart(pieData);
  }

}

function makePieChart(data, color, chartDivId) {
  var color20b = d3.scale.ordinal()
    .range(["#58595B", "#1B4C74", "#7B2C56", "#E87222"]);
  var chartDivId = (typeof chartDivId == 'undefined') ? "#chartDiv" : chartDivId;
  var color = (typeof color == 'undefined') ? color20b : color;
  var width = 360;
  var height = 360;
  var radius = Math.min(width, height) / 2.2;
  var legendRectSize = 14;
  var legendSpacing = 12;
  var rounding = 0; // rounding decimal

  var svg = d3.select(chartDivId)
    .append('svg')
    .attr('width', width)
    .attr('height', 500)
    .append('g')
    .attr('transform', 'translate(' + (width / 2) +
      ',' + (height / 2) + ')');

  var arc = d3.svg.arc()
    .innerRadius(0)
    .outerRadius(radius);

  var pie = d3.layout.pie()
    .value(function(d) {
      return d.series1;
    })
    .sort(null);

  var arcs = svg.selectAll('.arc')
    .data(pie(data))
    .enter()
    .append('g')
    .attr('class', 'arc');

  var total = d3.sum(data, function(d) {
    return d.series1;
  });
  var shiftRadius = radius * 1.05;
  var shiftShreshold = 5; // shift below (shiftShreshold)%
  arcs.append('path')
    .attr('d', arc)
    .attr('fill', function(d, i) {
      return color(d.data.label);
    })
    .attr('stroke', 'white')
    .attr('stroke-width', 2);

  arcs.append('text')
    .attr('class', 'pieLabel')
    .attr("transform", function(d) {
      var c = arc.centroid(d);
      if ((100 * d.value / total) >= shiftShreshold) {
        return "translate(" + c + ")";
      } else { // works for donut charts too
        var x = c[0],
          y = c[1],
          h = Math.sqrt(x * x + y * y);
        return "translate(" + (x / h * shiftRadius) + ',' + (y / h * shiftRadius) + ")";
      }
    })
    .attr("dy", ".35em")
    .style("text-anchor", "middle")
    /*.text(function(d) { return d.value + "( " + d3.round(100* d.value / total, 0) + "% " + ")"; });*/
    .text(function(d) {
      return d3.round((100 * d.value / total), rounding) + "%";
    })
    .style('fill', function(d) {
      if ((100 * d.value / total) >= shiftShreshold) {
        return "white";
      } else { // works for donut charts too
        return "black";
      }
    });

  var legend = svg.selectAll('.pieLegend')
    .data(color.domain())
    .enter()
    .append('g')
    .attr('class', 'PieLegend')
    .attr('transform', function(d, i) {
      var height = legendRectSize + legendSpacing;
      var offset = height * color.domain().length / 2;
      var horz = -2 * legendRectSize;
      var vert = i * height - offset;
      return 'translate(' + (horz - radius / 2) + ',' + (vert + radius * 1.5) + ')';
    });

  legend.append('rect')
    .attr('width', legendRectSize)
    .attr('height', legendRectSize)
    .style('fill', color)
    .style('stroke', color);

  legend.append('text')
    .attr('x', legendRectSize + legendSpacing)
    .attr('y', (legendRectSize + legendSpacing) / 2)
    .text(function(d) {
      return d;
    });

};
//======================================================
makePieChart(pieData);

function removeChart(chartDivId) { //Removes chart（s）
  var chartDivId = (typeof chartDivId == 'undefined') ? "chartDiv" : chartDivId;
  document.getElementById(chartDivId).innerHTML = "";
}

/*download button*/
function downloadSVG(ID) {
  var ID = (typeof ID == 'undefined') ? 'chartDiv' : ID;
  if (!called) {
    d3.select("#hidden").append("p")
      .attr("id", "SVGFile")
      .style("display", "none")
      .html("place holder");
    called = false;
  }

  // download a file named "filename", with content as "text"
  function downloadFile(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:txt/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
    element.style.display = 'none';
    document.body.appendChild(element);
    element.click();
    document.body.removeChild(element);
  }

  var called = true;

  // change the innerHTML of element with "ID" into SVG file
  function changeToSVG(ID) {
    var svg = document.getElementsByTagName("svg")[0];
    document.getElementById(ID).innerHTML = svg.outerHTML.replace("<svg", "<!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' xml:space='preserve' ");
  }

  changeToSVG(ID);
  downloadFile("chart.svg", document.getElementById(ID).innerHTML);
}

function downloadPNG() {
  function pxAdd(number, stringpx) {
    var calculated = (parseFloat(stringpx) + number);
    return calculated + 'px';
  }

  function pxMultiply(number, stringpx) {
    var calculated = (parseFloat(stringpx) * number);
    return calculated + 'px';
  }

  var svg = $('svg');
  var canv = document.createElement('canvas');
  document.body.appendChild(canv);
  var data = new XMLSerializer().serializeToString(document.querySelector('svg'));
  var imgsrc = 'data:image/svg+xml; charset=utf8, ' + encodeURIComponent(data);
  var canvas = document.querySelector("canvas"),
    context = canvas.getContext("2d");
  var svgH = svg.height();
  var svgW = svg.width();
  canvas.setAttribute('width', pxAdd(100, svgW));
  canvas.setAttribute('height', pxAdd(100, svgH));

  var image = new Image;
  image.src = imgsrc;
  image.onload = function() {
    context.drawImage(image, 0, 0);
    var canvasdata = canvas.toDataURL("image/png");
    var vLink = document.createElement("a");
    vLink.textContent = "save";
    vLink.download = "chart.png";
    vLink.href = canvasdata;
    vLink.setAttribute('style', 'display:none;');
    document.body.appendChild(vLink);
    canvas.parentNode.removeChild(canvas);
    vLink.click();
    vLink.remove();
  }
}

</script>

</body>
</html>