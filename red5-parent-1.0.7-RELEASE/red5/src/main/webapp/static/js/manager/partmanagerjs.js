

    $(function() {
        $('#side-menu').metisMenu();
    })

    var partList = new Array();
    var moduleList = new Array();

    function init() {
        $.ajax({
            type : "post",
            url : "/recommend/getPartAndModule",
            dataType:"json",
            success : function(data){
                for(var i = 0;i < data.data.part.length;i++){
                    partList[i] = data.data.part[i];
                }
                for(var i = 0;i < data.data.module.length;i++){
                    moduleList[i] = data.data.module[i];
                }
            }
        });
    }

    function addpart(){
        layui.use(['layer'], function() {
            var layer = layui.layer;
            layer.open({
                title: '添加板块',
                scrollbar: false,
                shadeClose: true,
                shade: 0.8,
                anim: 5,
                offset: '30px',
                area: ['500px', '330px'],
                btn: [],
                content: $("#addpart").html()
            });
            document.getElementById("addPartButtom").onclick = function () {
                var name = document.getElementById("addPartName").value;
                $.ajax({
                    type: "post",
                    url: "/part/addpart",
                    dataType: "json",
                    data: {
                        "name": name
                    },
                    success: function (data) {
                        if (data.state == 1) {
                            layer.msg(data.message);
                            for (var i = 0; i < data.data.length; i++) {
                                partList[i] = data.data[i];
                                if (name == data.data[i].name) {
                                    document.getElementById("manangediv").innerHTML += '<div class="row rowall"><div class="col-md-3 col-md-offset-1"><button class="btn btn-default btn-danger btnpart" id="partButton ' + data.data[i].id + '" onclick="managepart(' +
                                        data.data[i].id + ')">' + data.data[i].name + '</button></div><div class="col-md-8 module"><div id="part' + data.data[i].name +
                                        '"></div><div class="col-md-3"><button class="btn btn-default btn-success newone" onclick="addmodule(' + data.data[i].id + ')">新添</button></div></div></div>';
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    function managepart(partId){
        layui.use(['layer'], function() {
            var layer = layui.layer;
            layer.open({
                type: 1,
                title: '管理板块',
                scrollbar: false,
                shadeClose: true,
                anim: 5,
                offset: '30px',
                shade: 0.8,
                area: ['517px', '330px'],
                btn: [],
                content: $("#managepart").html()
            });
            for (var i = 0; i < partList.length; i++) {
                if (partList[i].id == partId) {
                    document.getElementById("managepartname").value = partList[i].name;
                    document.getElementById("updatePartBtn").onclick = function () {
                        var name = document.getElementById("managepartname").value;
                        $.ajax({
                            type: "post",
                            url: "/part/updatepart",
                            dataType: "json",
                            data: {
                                "id": partId,
                                "name": name
                            },
                            success: function (data) {
                                if (data.state == 1) {
                                    for (var i = 0; i < partList.length; i++) {
                                        if (partId == partList[i].id) {
                                            partList[i].name = name;
                                            document.getElementById("partButton" + partId).innerHTML = name;
                                        }
                                    }
                                    layer.closeAll();
                                    layer.msg(data.message);
                                }
                            }
                        });
                    }
                    document.getElementById("movePartBtn").onclick = function () {
                        layer.confirm('确定删除该板块？', {
                            title: '提示',
                            btn: ['确认删除'],
                            anim: 5,
                            offset: '110px',
                            btnAlign: 'c',
                            yes: function () {
                                $.ajax({
                                    type: "post",
                                    url: "/part/movepart",
                                    dataType: "json",
                                    data: {
                                        "id": partId
                                    },
                                    success: function (data) {
                                        if (data.state == 1) {
                                            var divList = document.getElementsByClassName("row rowall");
                                            for (var i = 0; i < partList.length; i++) {
                                                if (partId == partList[i].id) {
                                                    var div = divList[i];
                                                    div.parentNode.removeChild(div);
                                                }
                                            }
                                            layer.closeAll();
                                            layer.msg(data.message);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }
            }
        });
    }
    function managemodule(partId, moduleId){
        layui.use(['layer'], function() {
            var layer = layui.layer;
            layer.open({
                type: 1,
                title: '添加板块',
                scrollbar: false,
                shadeClose: true,
                anim: 5,
                offset: '30px',
                shade: 0.8,
                area: ['517px', '550px'],
                btn: [],
                content: $("#managemodule").html()
            });
            for (var i = 0; i < partList.length; i++) {
                if (partId == partList[i].id) {
                    document.getElementById("managemodulePartName").innerHTML = partList[i].name;
                }
            }
            for (var i = 0; i < moduleList.length; i++) {
                if (moduleId == moduleList[i].id) {
                    var photo = moduleList[i].photo;
                    document.getElementById("picbutton").onclick = function () {
                        lookpic(photo);
                    }
                    document.getElementById("changename").value = moduleList[i].name;
                    document.getElementById("hiddenModuleId").value = moduleList[i].id;
                    document.getElementById("namebutton").onclick = function () {
                        var changename = document.getElementById("changename").value;
                        var hiddenModuleId = document.getElementById("hiddenModuleId").value
                        $.ajax({
                            type: "post",
                            url: "/module/changename",
                            dataType: "json",
                            data: {
                                "id": moduleId,
                                "name": changename
                            },
                            success: function (data) {
                                if (data.state == 1) {
                                    layer.msg(data.message);
                                    for (var n = 0; n < moduleList.length; n++) {
                                        if (hiddenModuleId == moduleList[n].id) {
                                            moduleList[n].name = changename;
                                        }
                                    }
                                    document.getElementById("module" + hiddenModuleId).innerHTML = changename;
                                }
                            }
                        });
                    }
                    document.getElementById("changedescription").value = moduleList[i].description;
                    document.getElementById("descriptionbutton").onclick = function () {
                        var changedescription = document.getElementById("changedescription").value;
                        var hiddenModuleId = document.getElementById("hiddenModuleId").value
                        $.ajax({
                            type: "post",
                            url: "/module/changedescription",
                            dataType: "json",
                            data: {
                                "id": moduleId,
                                "description": changedescription
                            },
                            success: function (data) {
                                if (data.state == 1) {
                                    layer.msg(data.message);
                                    for (var n = 0; n < moduleList.length; n++) {
                                        if (hiddenModuleId == moduleList[n].id) {
                                            moduleList[n].description = changedescription;
                                        }
                                    }
                                }
                            }
                        });
                    }
                    document.getElementById("movemodulebutton").onclick = function () {
                        layer.confirm('确定删除该模块？', {
                            title: '提示',
                            btn: ['确认删除'],
                            anim: 5,
                            offset: '200px',
                            btnAlign: 'c',
                            yes: function () {
                                $.ajax({
                                    type: "post",
                                    url: "/module/movemodule",
                                    dataType: "json",
                                    data: {
                                        "id": moduleId
                                    },
                                    success: function (data) {
                                        if (data.state == 1) {
                                            var div = document.getElementById("module" + moduleId);
                                            var parent = div.parentNode;
                                            parent.parentNode.removeChild(parent);
                                            layer.closeAll();
                                            layer.msg(data.message);
                                        }
                                    }
                                });
                            }
                        });
                    }
                    document.getElementById("changephotoButton").onclick = function () {
                        var formData = new FormData($("#changephotoForm")[0]);
                        var id = document.getElementById("hiddenModuleId").value;
                        $.ajax({
                            type: "post",
                            data: formData,
                            url: "/module/changephoto",
                            dataType: 'json',
                            contentType: false,
                            processData: false,
                            success: function (data) {
                                if (data.state == 1) {
                                    for (var i = 0; i < data.data.length; i++) {
                                        moduleList[i] = data.data[i];
                                        if (data.data[i].id == id) {
                                            var pic = data.data[i].photo;
                                            document.getElementById("picbutton").onclick = function () {
                                                lookpic(pic);
                                            }
                                        }
                                    }
                                    layer.msg(data.message);
                                }
                            },
                            error: function (arg1, arg2, arg3) {
                                console.log(arg1 + "--" + arg2 + "--" + arg3);
                            }
                        });
                    }
                }
            }
        });
    }

    function addmodule(partId){
        layui.use(['layer'], function() {
            var layer = layui.layer;
            layer.open({
                title: '添加板块',
                scrollbar: false,
                shadeClose: true,
                shade: 0.8,
                anim: 5,
                offset: '30px',
                area: ['500px', '550px'],
                btn: [],
                content: $("#addmodule").html()
            });
            for (var i = 0; i < partList.length; i++) {
                if (partId == partList[i].id) {
                    document.getElementById("partName").innerHTML = partList[i].name;
                    document.getElementById("partId").value = partId;
                }
            }
            document.getElementById("addmoduleButton").onclick = function () {
                var formData = new FormData($("#addmoduleForm")[0]);
                var name = document.getElementById("addmoduleName").value;
                $.ajax({
                    type: "post",
                    data: formData,
                    url: "/module/addmodule",
                    dataType: 'json',
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        if (data.state == 1) {
                            for (var i = 0; i < data.data.length; i++) {
                                moduleList[i] = data.data[i];
                                if (data.data[i].partId == partId && data.data[i].name == name) {
                                    document.getElementById("part" + partId).innerHTML += '<div class="col-md-3"><button class="btn btn-default" id="module' +
                                        data.data[i].id + '" onclick="managemodule(' + partId + ',' + data.data[i].id + ')' + '">' + data.data[i].name + '</button></div>';
                                }
                            }
                            layer.msg(data.message);
                        }
                    },
                    error: function (arg1, arg2, arg3) {
                        console.log(arg1 + "--" + arg2 + "--" + arg3);
                    }
                });
            }
        });
    }
    function lookpic(photopath){
        layui.use(['layer'], function() {
            var layer = layui.layer;
            layer.photos({
                photos: {
                    "data": [
                        {
                            "src": photopath
                        }
                    ]
                }
            });
        });
    }
