<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- left & header--%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<style media="screen">
.container{
	width: 800px;
	height: auto;
	margin: 0 auto;
}

#myProgress {
	
	width: 100%;
	background-color: grey;
}

.myBar {
	width: 10px;
	height: 30px;
	background-color: green;
}
</style>
<section class="currentMain">
	<div class="currentMainContainer">
	
	
	
		<!-- 여기서부터가 지태꺼♡ -->
		<div class="container" id="ajaxx">
			<!-- issueHistoryAjax.jsp -->
		</div>
		<!-- 여기까지가 지태꺼♡ -->
		
		
		
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
<script type="text/javascript" src="../js/classie.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	var page = 1;
	
	$(document).ready(function(){	//페이지가 로드되면 데이터를 가져오고 page를 증가시킨다. == $(document).ready(function(){});
		
		<c:forEach items="${percentList}" var="percent" varStatus="status">
			console.log('${percent}');
			if(${percent} > 0 && ${percent} <= 100){
				$("#myBar${status.index}").width("${percent}%");
			}else{
				$("#myBar${status.index}").width('100%');
			}
		</c:forEach>
		
		getList(1);
		page++;
	});
	
	$(window).scroll(function(){	//스크롤이 최하단으로 내려가면 리스트를 조회하고 page를 증가시킨다.
		console.log("window-scroll");
		if($(window).scrollTop() == $(document).height() - $(window).height()){
			console.log("scrollTop");
			getList(page);
			page++;
		}
	});
	
	function getList(page){
		var sid = '${memberVo.member_mail}';
		var pageSize = 10;
		console.log("getList");
		$.ajax({
			url: '/issueHistoryAjax',
			type: 'POST',
			//dataType: 'json',
			data: {page : page, pageSize : pageSize, member_mail : sid},
			success: function(data){
				console.log(data);
				$("#ajaxx").html("");
				$("#ajaxx").html(data);
			}
		});
	}
	
</script>
<script>
//DIM POPUP
$('.projectCreatePopUp').click(function(){
	var $href = $(this).attr('href');
	layer_popup($href);
});
function layer_popup(el){
	var $el = $(el);        //레이어의 id를 $el 변수에 저장
	var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

	isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

	var $elWidth = ~~($el.outerWidth()),
		$elHeight = ~~($el.outerHeight()),
		docWidth = $(document).width(),
		docHeight = $(document).height();

	// 화면의 중앙에 레이어를 띄운다.
	if ($elHeight < docHeight || $elWidth < docWidth) {
		$el.css({
			marginTop: -$elHeight /2,
			marginLeft: -$elWidth/2
		})
	} else {
		$el.css({top: 0, left: 0});
	}

	$el.find('a.btn-layerClose').click(function(){
		isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
		return false;
	});

	$('.layer .dimBg').click(function(){
		$('.dim-layer').fadeOut();
		return false;
	});
}

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
</script>
</body>
</html>
