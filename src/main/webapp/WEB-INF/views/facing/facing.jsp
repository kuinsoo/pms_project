<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
	<!-- CURRENT SECTION(MAIN) -->
	<section class="currentMain">
		<div class="currentMainContainer">
			<div class="facingTitle">
				<h2><i class="icon-paper-plane icons"></i>쪽지</h2>
			</div>
			<div class="facingContainer">
				<div id="tabs2">
					<ul>							
						<li><a href="#tabs2-1">쪽지 보내기</a></li>
						<li><a href="#tabs2-2">받은쪽지</a></li>
						<li><a href="#tabs2-3">보낸쪽지</a></li>
						<li><a href="#tabs2-4">휴지통</a></li>
					</ul>

					<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 쪽지 보내기  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
					<div id="tabs2-1">
						<div class="facingSend">
							<form action="#" method="post">
								<div class="facingSendTitle">
									<input type="text" class="recipient" placeholder="받는사람을 입력해주세요" />
									<select class="recipientSelect">
										<option>친구등록 리스트</option>
										<option>test1@gmail.com</option>
										<option>test2@gmail.com</option>
									</select>
								</div>
								<textarea class="facingContent">내용적는곳</textarea>
								<div class="facingFile">
									<span>첨부파일</span>
								</div>
								<div class="facingFileList">
									<ul>
										<li><input type="file" /></li>
										<li><input type="file" /></li>
										<li><input type="file" /></li>
										<li><input type="file" /></li>
										<li><input type="file" /></li>
									</ul>
								</div>
								<div class="facingBtn">
									<input type="button" class="facingSendBtn" value="보내기" />
									<input type="button" class="facingSendReset" value="취소" />
								</div>
							</form>
						</div>
					</div>
					
					<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 받은쪽지 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
					
					 
					<div id="tabs2-2">
						<div class="receivedNoteContainer">
							<form action="#" method="post">
								<table>
									<colgroup width="10%" />							
									<colgroup width="10%" />
									<colgroup width="40%" />
									<colgroup width="10%" />
									<colgroup width="30%" />
									<thead>
										<tr>
											<th><input type="checkbox" /></th>
											<th>번호</th>
											<th>받는 사람</th>
											<th>친구 여부</th>
											<th>날짜/시간</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="checkbox" /></td>
											<td>1</td>
											<td>
												<a href="#open2">나진실</a>
												<div class="white_content2" id="open2">
													<div>
					 									<a href="#close"><i class="icon-close icons"></i></a>
														<div class="sentNoteContainer">
																<div class="recipientFacing">
																	<span>받는사람</span>
																	<input type="text" value="sally1334@naver.com" readonly />
																</div>
																<div class="sendDate">
																	<span>보낸날짜</span>
																	<input type="text" value="2018-12-17 19:09:00" readonly />
																	<i class="icon-ban icons"></i>
																	<span>차단</span>
																	<i class="icon-energy icons"></i>
																	<span>신고</span>
																</div>							
																<textarea class="sentNoteTextArea">답장입니다~~</textarea>
																<div class="facingDeleteBtnDiv">
																	<input type="button" value="삭제" class="sentNoteDeleteBtn" />
																	<a href="#close" class="sentNoteCloseBtn">취소</a>
																</div>
														</div>
													</div>
											    </div>
											</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>3</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>4</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>5</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>6</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>7</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>8</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>9</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>10</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
									</tbody>
								</table>
								<input type="button" value="삭제" class="recoveryBtn" />
							</form>
							<div class="pagination">
								<ul>
									<li><</li>
									<li>1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li>></li>
								</ul>
							</div>
						</div>
					</div>
					
					<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 보낸쪽지 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
					
					
					<div id="tabs2-3">
						<div class="sentNoteContainer">
							<form action="#" method="post">
								<table>
									<colgroup width="10%" />							
									<colgroup width="10%" />
									<colgroup width="40%" />
									<colgroup width="10%" />
									<colgroup width="30%" />
									<thead>
										<tr>
											<th><input type="checkbox" /></th>
											<th>번호</th>
											<th>받는 사람</th>
											<th>친구 여부</th>
											<th>날짜/시간</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="checkbox" /></td>
											<td>1</td>
											<td>
												<a href="#open1">나진실</a>
												<div class="white_content1" id="open1">
													<div>
					 									<a href="#close"><i class="icon-close icons"></i></a>
														<div class="sentNoteContainer">
																<div class="recipientFacing">
																	<span>받는사람</span>
																	<input type="text" value="sally1334@naver.com" readonly />
																</div>
																<div class="sendDate">
																	<span>보낸날짜</span>
																	<input type="text" value="2018-12-17 19:09:00" readonly />
																</div>							
																<textarea class="sentNoteTextArea">답장입니다~~</textarea>
																<div class="facingDeleteBtnDiv">
																	<input type="button" value="삭제" class="sentNoteDeleteBtns" />
																</div>
														</div>
													</div>
											    </div>
											</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>3</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>4</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>5</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>6</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>7</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>8</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>9</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>10</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
									</tbody>
								</table>
								<input type="button" value="삭제" class="recoveryBtn" />
							</form>
							<div class="pagination">
								<ul>
									<li><</li>
									<li>1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li>></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 휴지통 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
					
					<div id="tabs2-4">
						<div class="trashCanContainer">
							<form action="#" method="post">
								<table>
									<colgroup width="10%" />							
									<colgroup width="10%" />
									<colgroup width="40%" />
									<colgroup width="10%" />
									<colgroup width="30%" />
									<thead>
										<tr>
											<th><input type="checkbox" /></th>
											<th>번호</th>
											<th>받는 사람</th>
											<th>친구 여부</th>
											<th>날짜/시간</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="checkbox" /></td>
											<td>1</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>3</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>4</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>5</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>6</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>7</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>8</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>9</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>10</td>
											<td>나진실</td>
											<td>Y</td>
											<td>2018-12-17</td>
										</tr>
									</tbody>
								</table>
								<input type="button" value="복구" class="recoveryBtn" />
							</form>
							<div class="pagination">
								<ul>
									<li><</li>
									<li>1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li>></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<footer class="currentFooter">
		<div class="footerContent">
			<p>
				대전광역시 중구 중앙로 76 영민빌딩 2층 203호<br>
				기관명: (재)대덕인재개발원, 최종프로젝트 PMS(Project Management System)<br>
				Copyright 2018 <span>DDIT 203 Class, CURRENT</span> All rights reserved. 
			</p>
		</div>
	</footer>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/classie.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script>
// DIM POPUP - 팀원초대
$('.projectCreatePopUps').click(function(){
    var $hrefs = $(this).attr('href');
    layer_popups($hrefs);
});
function layer_popups(els){
    var $els = $(els);        //레이어의 id를 $el 변수에 저장
    var isDims = $els.prev().hasClass('dimBgs');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDims ? $('.dim-layers').fadeIn() : $els.fadeIn();

    var $elWidths = ~~($els.outerWidth()),
        $elHeights = ~~($els.outerHeight()),
        docWidths = $(document).width(),
        docHeights = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeights < docHeights || $elWidths < docWidths) {
        $els.css({
            marginTop: -$elHeights /2,
            marginLeft: -$elWidths/2
        })
    } else {
        $els.css({top: 0, left: 0});
    }

    $els.find('a.btn-layerCloses').click(function(){
        isDims ? $('.dim-layers').fadeOut() : $els.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $('.layer .dimBgs').click(function(){
        $('.dim-layers').fadeOut();
        return false;
    });
}

var menuLeft = document.getElementById('cbp-spmenu-s1'),
	 showLeftPush = document.getElementById('showLeftPush'),
	 body = document.body;

$("#showLeftPush").click(function(){
	classie.toggle( this, 'active' );
	classie.toggle( body, 'cbp-spmenu-push-toright' );
	classie.toggle( menuLeft, 'cbp-spmenu-open' );
});

function dialog(){
	var dialogBox = $('.dialog'),
		 dialogTrigger = $('.dialog__trigger'),
		 dialogAction = $('.dialog__action');
		 
		 // Open the dialog
		 dialogTrigger.on('click', function(e){
			 dialogBox.toggleClass('dialog--active');
			 e.stopPropagation()
		 });

		 $(".dialog").click(function(){
			 dialogBox.toggleClass('dialog--active');
		 });

		 $(".dialog__triggers").click(function(){
			 dialogBox.removeClass('dialog--active');
		 });

		 // Close the dialog - press escape key // key#27
		 $(document).keyup(function(e){
			 if(e.keyCode === 27){
				 dialogBox.removeClass('dialog--active');
			 }
		 });
};

// Run function when the document has loaded
$(function(){
	dialog();
});

function dialogs(){
	var dialogBoxs = $('.dialogs'),
		 dialogTriggers = $('.dialog__triggers'),
		 dialogActions = $('.dialog__actions');
		 
		 // Open the dialog
		 dialogTriggers.on('click', function(e){
			 dialogBoxs.toggleClass('dialog--actives');
			 e.stopPropagation()
		 });

		 $(".dialogs").click(function(){
			 dialogBoxs.toggleClass('dialog--actives');
		 });

		 $(".dialog__trigger").click(function(){
			 dialogBoxs.removeClass('dialog--actives');
		 });

		 // Close the dialog - press escape key // key#27
		 $(document).keyup(function(e){
			 if(e.keyCode === 27){
				 dialogBoxs.removeClass('dialog--actives');
			 }
		 });
};

// Run function when the document has loaded
$(function(){
	dialogs();
});

// 알람 탭 메뉴
$("#tabs").tabs();

//마이페이지 하단 탭 메뉴
$("#tabs2").tabs();
</script>
</body>
</html>