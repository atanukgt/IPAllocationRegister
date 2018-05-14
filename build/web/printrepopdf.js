function demoFromHTML() {
var doc = new jsPDF('l', 'pt');
var elem = document.getElementById("myTable");
var res = doc.autoTableHtmlToJson(elem);
doc.autoTable(res.columns, res.data,
    {
    styles: {
      overflow: 'linebreak',
      columnWidth: 'auto'
    }
    });
doc.save("table.pdf");
}
    
 