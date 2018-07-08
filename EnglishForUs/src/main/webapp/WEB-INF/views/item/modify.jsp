<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp"%>

<script>
	$(document).ready(function() {		
		var formObj = $("form[role='form']");
		console.log(formObj);

		$(".btn-warning").on("click", function() {
			self.location = "/item/listAll";
		});

		$(".btn-primary").on("click", function() {
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
					<h3 class="box-title">MODIFY ITEM</h3>
				</div>
				
				<form role="form" method="post">				
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">IDX</label> 
							<input type="text" name='idx' class="form-control" value="${itemVO.idx}" readonly="readonly">
						</div>			
						<div class="form-group">
							<label for="exampleInputEmail1">Title_KO</label> 
							<input type="text" name='title_ko' class="form-control" value="${itemVO.title_ko}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Title_EN</label>
							<input type="text" name='title_en' class="form-control" value="${itemVO.title_en}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Add_Info</label> 
							<input type="text" name='addinfo' class="form-control" value="${itemVO.addinfo}">
						</div>
					</div>								
				</form>	
				
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>		
				
			</div><!-- box-primary -->
		</div><!-- col-md-12 -->
	</div><!-- row -->
</section>				

<%@include file="../include/footer.jsp"%>