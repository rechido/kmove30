<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-pen"></i> 게시글 업로드
		</div>
		<div class="card-body">
			<form name="form_name" method="post" action="/WebProject/boards/write.jsp" enctype="multipart/form-data">
				<div class="form-group">
	              <div class="form-label-group">	              	
	                <input type="text" name="title" id="inputTitle" class="form-control" placeholder="제목" required="required" maxlength="100" autofocus="autofocus">
	                <label for="inputTitle">제목</label>	                
	              </div>
           		</div>
	            <div class="form-group">
					<div class="form-row">
						<c:if test="${sessionScope.nickname == null}">
							<div class="col-md-3">
								<div class="form-label-group">
									<input type="text" name="nickname" id="inputNickname" class="form-control" placeholder="닉네임을 입력하세요" required="required" maxlength="10">
									<label for="inputNickname">작성자</label>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-label-group">
									<input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="패스워드를 입력하세요" required="required" maxlength="15">
									<label for="inputPassword">패스워드</label>
								</div>
							</div>
						</c:if>
						<c:if test="${sessionScope.nickname != null}">
							<div class="col-md-3">
								<div class="form-label-group">
									<input type="text" name="nickname" id="inputNickname" class="form-control" placeholder="${sessionScope.nickname}" required="required" maxlength="10" readonly="readonly">
									<label for="inputNickname">작성자: ${sessionScope.nickname}</label>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-label-group">
									<input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="패스워드를 입력하세요" required="required" maxlength="15" readonly="">
									<label for="inputPassword">패스워드</label>
								</div>
							</div>
						</c:if>
						<div class="col-md-3">
							</div>
						<div class="col-md-3 custom-file" id="customFile" lang="ko">
						        <input type="file" name="image" class="custom-file-input" id="inputImage" aria-describedby="fileHelp" multiple="multiple" accept="image/*">
						        <label class="custom-file-label" for="inputImage">
						           그림/사진 업로드
						        </label>
						</div>
										
					</div>
				</div>		
				<div class="form-group">
					<textarea name="contents" class="form-control" id="inputTextarea" rows="20"></textarea>
				</div>
				<button type="button" class="btn btn-secondary btn-block cancelbtn" onclick="history.go(-1);">취소</button>
				<button type="submit" class="btn btn-primary btn-block uploadbtn">업로드</button>
				<br />
			</form>
		</div>
	</div>
