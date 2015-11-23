/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

/**
 * Created by lbc on 2015/11/20.
 */

var iPsoCommon = {};

iPsoCommon.updateTable  = function (dataList, tableIdToCreate, tableCaption, listColumnNames, listPropertyNames, columnsNbr, elementIdToAttach, width){
    var list = dataList;
    var table = document.createElement("table");
    table.id = tableIdToCreate;
    var caption = document.createElement("caption");
    caption.innerHTML="<h3>" + tableCaption + "</h3>";
    table.appendChild(caption);


    html = "<tr align='center'>";
    for(var i=0;i<columnsNbr;i++){
        html += "<th>" + listColumnNames[i] + "</th>"
    }
    table.innerHTML+= html + "</tr>";

    for(var i=0;i<list.length;i++){
        var record = list[i];
        var html="<tr align='center'>";
        for(var j=0;j<columnsNbr;j++){
            html+="<td>"+record[listPropertyNames[j]]+"</td>";
        }
        html+='</tr>';
        table.innerHTML+=html;
    }
    table.width=width;
    table.border="1";
    //table.cellspacing="0";
    //table.cellpadding="0";
    document.getElementById(elementIdToAttach).appendChild(table);
}
