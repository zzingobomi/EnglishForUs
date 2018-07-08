<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

</script>
<script>
	$(document).ready(function() {		
		$('#newBtn').on("click", function(event) {
			self.location = "register";
		});
	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL ITEM</h3>
				</div>
				<div class="box-body">
				
					<button id='newBtn'>New Item</button>
				
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">IDX</th>
							<th>TITLE_KO</th>
							<th>TITLE_EN</th>
							<th>ADD_INFO</th>
							<th>REGDATE</th>							
						</tr>							
					
					<c:forEach items="${list}" var="itemVO">
						<tr>
						
						
							<td>${itemVO.idx}</td>
							<td><a href='/item/read?idx=${itemVO.idx}'>${itemVO.title_ko}</a></td>
							<td><a href='/item/read?idx=${itemVO.idx}'>${itemVO.title_en}</a></td>							
							<td><a href='/item/read?idx=${itemVO.idx}'>${itemVO.addinfo}</a></td>							
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${itemVO.regdate}"/></td>
							
						</tr>					
					</c:forEach>		
					
					</table>					
				
				</div><!-- box-body -->
			</div><!-- box -->
		</div><!-- col-md-12 -->
	</div><!-- row -->
</section>

<%@include file="../include/footer.jsp"%>