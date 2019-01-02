package kr.or.ddit.work.web;

import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.card.service.CardServiceInf;
import kr.or.ddit.comments.service.CommentsServiceInf;
import kr.or.ddit.meeting.model.MeetingVo;
import kr.or.ddit.meeting.service.MeetingServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.project.model.ProjectVo;
import kr.or.ddit.project.service.ProjectServiceInf;
import kr.or.ddit.todo.model.ToDoVo;
import kr.or.ddit.todo.service.ToDoServiceInf;
import kr.or.ddit.work.model.WorkVo;
import kr.or.ddit.work.service.WorkServiceInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
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

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WorkServiceInf workService;

	@Autowired
	private CommentsServiceInf commentsService;

	@Autowired
	private CardServiceInf cardService;

	@Autowired
	private ProjectServiceInf projectService;

	@Autowired
	private MemberServiceInf memberService;

	@Autowired
	private MeetingServiceInf meetingService;

	@Autowired
	private ToDoServiceInf todoService;

	@RequestMapping(value="/ajaxCreateWork",method=RequestMethod.POST)
	public String ajaxCreateWork(Model model, WorkVo workVo, @RequestParam("project_id")String project_id,
							 @SessionAttribute("memberVo")MemberVo memberVo,
								 @RequestParam("file") MultipartFile[] files) {

		try{
			Map<String, String> mapWM = new HashMap<>();
			mapWM.put("pmember_member",memberVo.getMember_mail());
			mapWM.put("pmember_project", project_id);
			workVo.setWork_project(project_id);
			if(workVo.getWork_public() == null )
				workVo.setWork_public("N");

			cardService.createCard( mapWM , workVo, files);
		} catch (Exception e){
			e.printStackTrace();
		}

		Map<String, String> mapWork = new HashMap<>();
		mapWork.put("member_mail", memberVo.getMember_mail());
		mapWork.put("project_id", project_id);

		model.addAttribute("workList",workService.selectWorks(project_id));
		model.addAttribute("cmtList", commentsService.cmtList(project_id));


		return "main/ajaxWorkList";
	}

	@RequestMapping(value="/createWork",method=RequestMethod.POST)
	public String createWork(Model model, WorkVo workVo, @RequestParam("project_id")String project_id,
								 @SessionAttribute("memberVo")MemberVo memberVo,
								 @RequestParam("file") MultipartFile[] files) {

		try{
			Map<String, String> mapWM = new HashMap<>();
			mapWM.put("pmember_member",memberVo.getMember_mail());
			mapWM.put("pmember_project", project_id);
			workVo.setWork_project(project_id);
			if(workVo.getWork_public() == null )
				workVo.setWork_public("N");

			cardService.createCard( mapWM , workVo, files);
		} catch (Exception e){
			e.printStackTrace();
		}

		Map<String, String> mapWork = new HashMap<>();
		mapWork.put("member_mail", memberVo.getMember_mail());
		mapWork.put("project_id", project_id);


		ProjectVo projectVo =  projectService.selectProject(project_id);
		/* 프로젝트 객체  */
		model.addAttribute("projectVo", projectVo);

		/* 프로젝트에 포함된 멤버 정보 */
		model.addAttribute("projectMemberList", memberService.projectMemberList(project_id));

		/* 업무 출력 */
		model.addAttribute("workList",workService.selectWorks(project_id));

		/* 업무에 달린 댓글 출력 */
		model.addAttribute("cmtList", commentsService.cmtList(project_id));

		/* 업무 카드 출력 */
		model.addAttribute("wcList", cardService.selectWorkCard(project_id));

		/* 첨부파일 목록 */


		Map<String, String> mtMap = new HashMap<>();
		mtMap.put("project_id", project_id);
		model.addAttribute("workCharts",workService.workChart(mtMap));


		/* 변찬우(추가 2018.12.26) 프로젝트 목록 출력 */
		List<MeetingVo> meetingList= meetingService.meetingList(project_id);
		model.addAttribute("meetingList",meetingList );

		model.addAttribute("member_name",memberService.selectUser(project_id) );

		return "main/subMain";
	}



	@RequestMapping(value = "/testGantt", method=RequestMethod.GET)
	public String testGantt() {
		return "work/testChart";
	}

	@RequestMapping(value = "/testGantt2", method=RequestMethod.GET)
	public String testGantt2() {
		return "work/2222";
	}

	@RequestMapping(value = "/ajaxWorkChart", method=RequestMethod.POST)
	public String ajaxWorkChart(Model model, @RequestParam("project_id")String project_id,
								@RequestParam("work_id")String work_id) {
		Map<String, String> mtMap = new HashMap<>();
		mtMap.put("project_id", project_id);
		mtMap.put("work_id", work_id);
		model.addAttribute("workCharts",workService.selectWorkChart(mtMap));
		return "work/ajaxWorkChart";
	}

	@RequestMapping(value = "/moveBar", method = RequestMethod.GET)
	@ResponseBody
	public Integer moveBar(@RequestParam("work_id")String work_id, @RequestParam("project_id")String project_id) {
		Map<String, String> todoMap = new HashMap<>();
		todoMap.put("work_id", work_id);
		todoMap.put("project_id", project_id);
		return todoService.todoComplete(todoMap);
	}
}