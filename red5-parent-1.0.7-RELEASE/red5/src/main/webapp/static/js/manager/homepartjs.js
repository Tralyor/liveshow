$(function() {
    $('#side-menu').metisMenu();
})
var partList = new Array();
var partValue = new Array();
var moduleList = new Array();
var moduleValues = new Array();
var recommend = new Array();
partList[0] = "板块名";
partValue[0] = "empty";
moduleList[0] = new Array();
moduleList[0][0] = "模块名"
moduleValues[0] = new Array();
moduleValues[0][0] = "empty";

function select_change(index,temp)
{
    var module = document.getElementById("form" + temp).module;
    module.length = 0;
    module.length = moduleList[index].length;
    for(var i=0;i<moduleList[index].length;i++)
    {
        module.options[i].text = moduleList[index][i];
        module.options[i].value = moduleValues[index][i];
    }
}
function init()
{
    $.ajax({
        type : "post",
        url : "/recommend/getPartAndModule",
        dataType:"json",
        success : function(data){
            for(var i = 0;i < data.data.part.length;i++){
                partList[i+1] = data.data.part[i].name;
                partValue[i+1] = data.data.part[i].id;
                moduleValues[i+1] = new Array();
                moduleList[i+1] = new Array();
                var j = 0;
                for(var n = 0;n < data.data.module.length;n++){
                    var a = data.data.module[n].partId;
                    var b = data.data.module[i].id;
                    if(a == b){
                        moduleList[i+1][j] = data.data.module[n].name;
                        moduleValues[i+1][j] = data.data.module[n].id;
                        j++;
                    }
                }
            }
            setInit();
            sendinfo();
        }
    });
}
function sendinfo() {
    $.ajax({
        type : "post",
        url : "/recommend/presentModule",
        dataType:"json",
        success : function(data){
            for(var i = 0;i < data.data.length;i++){
                setPresent(data.data[i].id, data.data[i].partId, data.data[i].moduleId);
            }
        }
    });
}
function setInit() {
    for(var n = 1;n < 9;n++){
        var part = document.getElementById("form" + n).part;
        var module = document.getElementById("form" + n).module;
        part.length = partList.length;
        for(var i=0;i<partList.length;i++)
        {

            part.options[i].text = partList[i];
            part.options[i].value = partValue[i];
        }
        var index = 0;
        part.selectedIndex = index;
        module.length = moduleList[index].length;
        for(var j=0;j<moduleList[index].length;j++)
        {
            module.options[j].text = moduleList[index][j];
            module.options[j].value = moduleValues[index][j];
        }
    }
}
function setPresent(formid,partid,moduleid){
    document.getElementById("form" + formid).getElementsByTagName("select")[0].value= partid;
    var part = document.getElementById("form" + formid).part;
    var module = document.getElementById("form" + formid).module;
    var index = partid;
    part.selectedIndex = index;
    module.length = moduleList[index].length;
    for(var j=0;j<moduleList[index].length;j++)
    {
        module.options[j].text = moduleList[index][j];
        module.options[j].value = moduleValues[index][j];
    }
    document.getElementById("form" + formid).getElementsByTagName("select")[1].value=moduleid;
}

function handleInfo(formid) {
    var moduleId = document.getElementById("form" + formid).getElementsByTagName("select")[1].value;
    $.ajax({
        type : "post",
        url : "/recommend/handleInfo",
        dataType:"json",
        data : {
            "id" : formid,
            "moduleId" : moduleId
        },
        success : function(data){
            if(data.state == 0){
                layer.open({
                    title: '提示',
                    content: data.message
                });
            }else{
                layer.msg(data.message);
            }
        }
    });
}