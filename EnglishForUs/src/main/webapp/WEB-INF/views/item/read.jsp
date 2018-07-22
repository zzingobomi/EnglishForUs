<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp"%>

<script>
	$(document).ready(function(){		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#modifyBtn").on("click", function(){
			formObj.attr("action", "/item/modify");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		$("#removeBtn").on("click", function(){
			formObj.attr("action", "/item/remove");
			formObj.submit();
		});
		
		$("#goListBtn").on("click", function(){
			formObj.attr("method", "get");
			formObj.attr("action", "/item/listAll");
			formObj.submit();
		});
	});	
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ ITEM</h3>
				</div>
				
				<form role="form" action="modify" method="post">
					<input type='hidden' name='idx' value="${itemVO.idx}">
					<input type='hidden' name='page' value ="${cri.page}">
    				<input type='hidden' name='perPageNum' value ="${cri.perPageNum}">
    				<input type='hidden' name='searchType' value ="${cri.searchType}">
    				<input type='hidden' name='keyword' value ="${cri.keyword}">
				</form>
				
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title_KO</label>
						<input type="text" name='title_ko' class="form-control" value="${itemVO.title_ko}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Title_EN</label>
						<input type="text" name='title_en' class="form-control" value="${itemVO.title_en}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Add_Info</label>
						<input type="text" name="addinfo" class="form-control" value="${itemVO.addinfo}" readonly="readonly">
					</div>
				</div>
				
				<div class="box-footer">
					<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
					<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
					<button type="submit" class="btn btn-primary" id="goListBtn">LIST ALL</button>
				</div>				
				
			</div><!-- box-primary -->
		</div><!-- col-md-12 -->
	</div><!-- row -->
</section>

<%@include file="../include/footer.jsp"%>