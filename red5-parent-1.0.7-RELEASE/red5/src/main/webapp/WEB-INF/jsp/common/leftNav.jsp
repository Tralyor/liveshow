<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/12/4
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<div class="live-side">
    <div class="live-side-scroll">
        <div class="live-viewport">
            <!-- 按钮区域 -->
            <div class="live-side-btns">
                <button class="btn btn-large btn-primary btn-block" type="button">全部直播</button>
                <button class="btn btn-large btn-primary btn-block" type="button">全部分类</button>
            </div>

            <!-- 游戏推荐区域 -->
            <div class="live-side-recommend">
                <div class="live-side-title">
                    <ul>
                        <li>栏目</li>
                    </ul>
                </div>
                
                
                <c:forEach var="part" items="${parts}">
                    <div class="list-wrap">
                        <div>
                            <i></i>
                            <span>${part.name}</span>
                        </div>
                    <ul class="live-btns">
                        <c:forEach items="${allModules}" var="module">
                           <c:if test="${module.partId eq part.id}">
                               <li>
                                   <a href="#">${module.name}</a>
                               </li>
                           </c:if>
                        </c:forEach>
                    </ul>
                 </div>
                </c:forEach>
                
            </div>
        </div>
    </div>
</div>
