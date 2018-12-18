package kr.or.ddit.work.web;

import kr.or.ddit.card.model.CardVo;
import kr.or.ddit.card.service.CardServiceInf;
import kr.or.ddit.comments.service.CommentsServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.work.model.WorkVo;
import kr.or.ddit.work.service.WorkServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * kr.or.ddit.work.web
 * null.java
 * Desc : 업무 컨트롤러
 *
 * @Author : Mr.KKu
 * @Date : 2018-11-27 / 오후 3:34
 * @Version :
 */
@Controller
public class WorkController {

	@Autowired
	private WorkServiceInf workService;

	@Autowired
	private CommentsServiceInf commentsService;

	@Autowired
	private CardServiceInf cardService;

	@RequestMapping(value="/ajaxCreateWork",method=RequestMethod.POST)
	public String ajaxCreateWork(Model model, WorkVo workVo, @RequestParam("project_id")String project_id,
							 @SessionAttribute("memberVo")MemberVo memberVo) {

		try{
			Map<String, String> mapWM = new HashMap<>();
			mapWM.put("pmember_member",memberVo.getMember_mail());
			mapWM.put("pmember_project", project_id);
			workVo.setWork_project(project_id);
			cardService.createCard( mapWM , workVo);
		} catch (Exception e){
			e.printStackTrace();
		}

		Map<String, String> mapWork = new HashMap<>();
		mapWork.put("member_mail", memberVo.getMember_mail());
		mapWork.put("project_id", project_id);

		model.addAttribute("workList",workService.selectWorks(project_id));
		model.addAttribute("cmtList", commentsService.cmtList(project_id));
		return "work/ajaxCreateWork";
	}

	@RequestMapping(value = "/testGantt", method=RequestMethod.GET)
	public String testGantt() {
		return "work/testChart";
	}



	@RequestMapping(value = "/testGantt2", method=RequestMethod.GET)
	public String testGantt2() {
		return "work/2222";
	}
}

