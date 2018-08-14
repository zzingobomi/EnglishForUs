<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../include/header.jsp" %>	

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
			
				<div class="box-header">
					<h3 class="box-title">REGISTER ITEM</h3>
				</div>
			
				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Title_KO</label>
							<input type="text" name='title_ko' class="form-control" placeholder="한국어 문장">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Title_EN</label>
							<input type="text" name='title_en' class="form-control" placeholder="영어 문장">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Add_Info</label>
							<input type="text" name="addinfo" class="form-control" placeholder="부가 설명">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">RegIdEmail</label>
							<input type="text" name="regidemail" class="form-control" placeholder="등록 Id" value="${login.uemail}" readonly="readonly">							
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">RegDisplayName</label>
							<input type="text" name="regdisplayname" class="form-control" placeholder="등록 이름" value="${login.uname}" readonly="readonly">							
						</div>
					</div>
					<!-- /.box-body -->
					
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			
			</div><!-- /.box box-primary -->
		</div><!--/.col (left) -->
	</div><!-- /.row -->	
</section>

<%@ include file="../include/footer.jsp" %>