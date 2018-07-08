<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp"%>

<script>
	$(document).ready(function(){		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/item/modify");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/item/remove");
			formObj.submit();
		});
		
		$(".btn-primary").on("click", function(){
			self.location = "/item/listAll";
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
				
				<form role="form" method="post">
					<input type='hidden' name='idx' value="${itemVO.idx}">
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
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="submit" class="btn btn-primary">LIST ALL</button>
				</div>				
				
			</div><!-- box-primary -->
		</div><!-- col-md-12 -->
	</div><!-- row -->
</section>

<%@include file="../include/footer.jsp"%>