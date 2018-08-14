<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

</script>
<script>
	$(document).ready(function() {		
		$('#searchBtn').on("click", function(event) {
			self.location = "listAll"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("select option:selected").val()
				+ "&keyword=" + $('#keywordInput').val();
		});
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
				
					<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="k"
							<c:out value="${cri.searchType eq 'k'?'selected':''}"/>>
							Title_KO</option>
						<option value="e"
							<c:out value="${cri.searchType eq 'e'?'selected':''}"/>>
							Title_EN</option>
						<option value="i"
							<c:out value="${cri.searchType eq 'i'?'selected':''}"/>>
							RegIdEmail</option>
						<option value="ke"
							<c:out value="${cri.searchType eq 'ke'?'selected':''}"/>>
							Title_KO OR Title_EN</option>
						<option value="ei"
							<c:out value="${cri.searchType eq 'ei'?'selected':''}"/>>
							Title_EN OR RegIdEmail</option>
						<option value="kei"
							<c:out value="${cri.searchType eq 'kei'?'selected':''}"/>>
							Title_KO OR Title_EN OR RegIdEmail</option>							
					</select>
					
					<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
					<button id='searchBtn'>Search</button>
					<button id='newBtn'>New Item</button>
				
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">IDX</th>
							<th>TITLE_KO</th>
							<th>TITLE_EN</th>
							<th>ADD_INFO</th>
							<th>REGID(Email)</th>
							<th>DISPLAY_NAME</th>
							<th>REGDATE</th>	
							<th style="width: 20px">REPLYCNT</th>
							<th style="width: 20px">LIKECNT</th>
							<th style="width: 20px">BADCNT</th>
							<th style="width: 20px">IMPCNT</th>						
						</tr>							
					
					<c:forEach items="${list}" var="itemVO">
						<tr>	
							<td>${itemVO.idx}</td>
							<td><a href='/item/read${pageMaker.makeSearch(pageMaker.cri.page)}&idx=${itemVO.idx}'>${itemVO.title_ko}</a></td>
							<td><a href='/item/read${pageMaker.makeSearch(pageMaker.cri.page)}&idx=${itemVO.idx}'>${itemVO.title_en}</a></td>							
							<td><a href='/item/read${pageMaker.makeSearch(pageMaker.cri.page)}&idx=${itemVO.idx}'>${itemVO.addinfo}</a></td>
							<td>${itemVO.regidemail}</td>		
							<td>${itemVO.regdisplayname}</td>					
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${itemVO.regdate}"/></td>
							<td>${itemVO.replycnt}</td>
							<td>${itemVO.likecnt}</td>
							<td>${itemVO.badcnt}</td>
							<td>${itemVO.impressioncnt}</td>
						</tr>					
					</c:forEach>		
					
					</table>					
				
				</div><!-- box-body -->
				
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							
							<c:if test="${pageMaker.prev}">
								<li><a href="listAll${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>
							
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="listAll${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>
							
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a href="listAll${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
							</c:if>
							
						</ul>
					</div><!-- text-center -->
				</div><!-- box-footer -->				
				
			</div><!-- box -->
		</div><!-- col-md-12 -->
	</div><!-- row -->
</section>

<%@include file="../include/footer.jsp"%>