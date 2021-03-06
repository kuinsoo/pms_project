package kr.or.ddit.qna.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.issue.service.IssueServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.message.service.MessageServiceInf;
import kr.or.ddit.post.model.PostPageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.work.service.WorkServiceInf;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * kr.or.ddit.qna.web
 * null.java
 * Desc : Q&A 컨트롤러
 *
 * @Author : iks
 * @Date : 2018-12-12 / 오후 6:59
 * @Version :
 */
@Controller
public class QnAController {
	
	@Autowired
	private PostServiceInf postService;
	
	@Autowired
	private WorkServiceInf workService;
	
	@Autowired
	private MessageServiceInf messageService;
	
	@Autowired
	private IssueServiceInf issueService;
	
	Logger logger = LoggerFactory.getLogger(QnAController.class);
	

	/**
	* Method : qnaView
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @return
	* Method 설명 : 질의응답 게시판 목록 
	*/
	@RequestMapping(value= "/qnaList") 
	public String qnaView(Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/qnaList";
	}

	
	/**
	* Method : qnaListAjax
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @param postPageVo
	* @param model
	* @return
	* Method 설명 : qnaList에서 ajax를 통해 qnaListAjax(글 목록) jsp 호출 
	*/
	@RequestMapping(value= "/qnaListAjax", method= {RequestMethod.GET,RequestMethod.POST})
	public String qnaListAjax(PostPageVo postPageVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		
		List<PostVo> postVoList;
		if(postPageVo.getSearchText().equals("")) {
			postVoList = postService.qnaPostList(postPageVo);			
		}else {
			postVoList = postService.qnaSerachList(postPageVo);	
		}
		
		model.addAttribute("postVoList", postVoList);
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));

		return "qna/qnaListAjax";
	}
	
	
	/**
	* Method : qnaPagingAjax
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @param postPageVo
	* @param model
	* @return
	* Method 설명 : qnaList에서 ajax를 통해 qnaPagingAjax(페이지 네비게이션) jsp 호출 
	*/
	@RequestMapping(value= "/qnaPagingAjax", method= {RequestMethod.GET,RequestMethod.POST})
	public String qnaPagingAjax(PostPageVo postPageVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		
		int postListCnt = postService.postListCnt(postPageVo);
		
		List<PostVo> postVoList = postService.qnaPostList(postPageVo);
		
		model.addAttribute("postListCnt", (int)Math.ceil((double)postListCnt/ postPageVo.getPostCnt()));
		model.addAttribute("postVoList", postVoList);
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));

		return "qna/qnaPagingAjax";
	}
	
	

	/**
	* Method : qnaDtailView
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @return
	* Method 설명 : 글 상세 
	*/
	@RequestMapping(value= "/qnaDetail", method= RequestMethod.GET)
	public String qnaDtailView(PostVo postVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {

		postVo = postService.selectQnaPost(postVo.getPost_id());
		// *** null이 나오는 까닭은 list를 출력하는 sql에 select문에 id가 없었기 때문 
		
		model.addAttribute("postVo", postVo);
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/qnaDetail";
	}
	
	
	/**
	 * Method : /qnaModyView
	 * 작성자 : 변찬우 
	 * 변경이력 :
	 *
	 * @return Method 설명 : Q&A 글 수정 
	 */
	@RequestMapping(value= "/qnaMody", method= RequestMethod.GET)
	public String qnaModyView(PostVo postVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {

		postVo = postService.selectQnaPost(postVo.getPost_id());
		
		model.addAttribute("postVoDetail", postVo);
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/qnaMody";
	}	
	
	
	/**
	* Method : qnaPostSave
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @return
	* Method 설명 : 작성(수정)한 글 저장 
	*/
	@RequestMapping(value= "/qnaPostSave", method= {RequestMethod.GET, RequestMethod.POST})
	public String qnaPostSave(PostVo postVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		
		postService.updateQnaPost(postVo);
		//set하지 않아도 form에서 전달하는 순간, public String qnaPostSave(Vo vo)에 선언한 vo 중 name이 같으면 vo에 저장한다
		
		//return "qna/qnaList";
		//return "redirect:/qnaDetail?post_id="+postVo.getPost_id();
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/alert";
	}
	
	
	/**
	 * Method : /qnaDel 처리 
	 * 작성자 : 변찬우 
	 * 변경이력 :
	 *
	 * @return Method 설명 : Q&A  글 삭제 
	 */
	@RequestMapping(value= "/qnaDel", method= RequestMethod.GET)
	public String qnaDelView(PostVo postVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		
		postService.deleteQnaPost(postVo.getPost_id());
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/qnaList";
	}
	

	/**
	 * Method : qnaFormView
	 * 작성자 : 변찬우 
	 * 변경이력 :
	 *
	 * @return Method 설명 : Q&A 글 작성 
	 */
	@RequestMapping(value= "/qnaForm", method= RequestMethod.GET)
	public String qnaFormView(PostVo postVo, HttpServletRequest req, Model model, @SessionAttribute("memberVo")MemberVo memberVo) {
		// ??? @RequestParam("userId") String userId
				
		//postVo.setBoard_id((String)req.getAttribute("board_id"));
		// ??? (String)
		
		model.addAttribute("postVo", postVo);
		//파라미터로 받은, 아직 등록되지않은 변수를 저장하기위해
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		
		return "qna/qnaForm";
	}

	
	/**
	* Method : qnaIndert
	* 작성자 : bhuanchanwoo
	* 변경이력 :
	* @return
	* Method 설명 : 새 질문 글 저장
	*/
	@RequestMapping(value= "/newPost", method={RequestMethod.GET, RequestMethod.POST})
	public String qnaIndert(PostVo postVo, @SessionAttribute("memberVo")MemberVo memberVo, Model model,@RequestParam("ori_post_writer")String ori_post_writer) {
		
		postService.insertQnaPost(postVo);
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		model.addAttribute("ori_post_writer", ori_post_writer);
		
		return "qna/alert";	
	}
	//위에 '수정 저장'과 코드 중복---- 나중에 지울 예정 
	
	
	/**
	 * Method : /qnaReplyView 
	 * 작성자 : 변찬우 
	 * 변경이력 :
	 *
	 * @return Method 설명 : Q&A  답글    
	 */
	@RequestMapping(value= "/qnaReply")
	public String qnaReplyView(PostVo postVo, Model model, @SessionAttribute("memberVo")MemberVo memberVo,@RequestParam("ori_post_writer")String ori_post_writer) {

		model.addAttribute("postVo", postVo);
		//파라미터로 받은, 아직 등록되지않은 변수를 저장하기위해 (글 내용 -> 답글)
		
		/* 알림기능 - IKS */
		model.addAttribute("pageCnt", postService.totalPostCnt());
		model.addAttribute("workMemberTotalCnt", workService.workMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalMsgReceived", messageService.totalMsgReceived(memberVo.getMember_mail()));
		model.addAttribute("issueMemberTotalCnt", issueService.issueMemberTotalCnt(memberVo.getMember_mail()));
		model.addAttribute("totalyouGiveFriendList", messageService.totalyouGiveFriendList(memberVo.getMember_mail()));
		model.addAttribute("ori_post_writer", ori_post_writer);
		
		return "qna/qnaForm";
	}
}