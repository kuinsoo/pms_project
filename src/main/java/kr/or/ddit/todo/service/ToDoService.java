package kr.or.ddit.todo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.schedule.model.ScheduleVo;
import kr.or.ddit.todo.mapper.ToDoMapper;
import kr.or.ddit.todo.model.ToDoVo;

/**
 * kr.or.ddit.todo.service
 * null.java
 * Desc : 할일 서비스
 *
 * @Author : Mr.KKu, jerry
 * @Date : 2018-11-27 / 오후 3:30
 * @Version :
 */
@Service
@Transactional
public class ToDoService implements ToDoServiceInf{

	@Autowired
	private ToDoMapper todoMapper;
	
	/**
	* Method : todoAllSchedule
	* 작성자 : jerry
	* 변경이력 : 2018-11-30 10:01
	* @param scheduleVo
	* @return
	* Method 설명 : 할일 전체 일정
	*/
	@Override
	public List<ToDoVo> todoAllSchedule(ScheduleVo scheduleVo) {
		return todoMapper.todoAllSchedule(scheduleVo);
	}

	/**
	* Method : todoInsert
	* 작성자 : jerr
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : to-do 등록
	*/
	@Override
	public int todoInsert(ToDoVo todoVo) {
//		long chk[] = dateCompareTodo(todoVo);
		long chk = dateCompareTodo(todoVo);
		
//		if (chk[0] >= 0 || chk[1] >= 0) {
		if (chk >= 0) {
			return todoMapper.todoInsert(todoVo);
		} else {
			return -400;
		}
	}
	
	/**
	* Method : workToDoSelect
	* 작성자 : jerry
	* 변경이력 :
	* @param todo_work
	* @return
	* Method 설명 : 각 업무의 to-do list를 조회
	*/
	@Override
	public Map<String, Object> workToDoSelect(Map todoMap) {
		List<ToDoVo> getToDoList = todoMapper.workToDoSelect(todoMap);
		
		Map<String, Object> getToDoMap = new HashMap<String, Object>();
		getToDoMap.put("todoList", getToDoList);
		
		return getToDoMap;
	}

	/**
	* Method : todoCnt
	* 작성자 : jerry
	* 변경이력 :
	* @param todo_work
	* @return
	* Method 설명 : to-do list의 총 to-do 갯수
	*/
	@Override
	public int todoCnt(String work_id) {
		return todoMapper.todoCnt(work_id);
	}

	/**
	* Method : getProjectMember
	* 작성자 : jerry
	* 변경이력 :
	* @param project_id
	* @return
	* Method 설명 : 참여자의 이름과 메일 조회
	*/
	@Override
	public List<ToDoVo> getProjectMember(Map searchMap) {
		return todoMapper.getProjectMember(searchMap);
	}

	/**
	* Method : todoCompletYN
	* 작성자 : jerry
	* 변경이력 :
	* @param todoUpdateMap
	* @return
	* Method 설명 : to-do의 완료여부 변경
	*/
	@Override
	public int todoCompletYN(Map todoUpdateMap) {

		return todoMapper.todoCompletYN(todoUpdateMap);
	}

	/**
	* Method : todoDelete
	* 작성자 : jerry
	* 변경이력 :
	* @param todo_id
	* @return
	* Method 설명 : to-do를 삭제
	*/
	@Override
	public int todoDelete(String todo_id) {
		return todoMapper.todoDelete(todo_id);
	}

	/**
	* Method : selectOptionProjectMember
	* 작성자 : jerry
	* 변경이력 :
	* @param project_id
	* @return
	* Method 설명 : to-do 수정시 담당자 select option 값 조회
	*/
	@Override
	public List<ToDoVo> selectOptionProjectMember(String project_id) {
		return todoMapper.selectOptionProjectMember(project_id);
	}

	/**
	* Method : todoUpdate
	* 작성자 : jerry
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : to-do 수정
	*/
	@Override
	public int todoUpdate(ToDoVo todoVo) {
//		long chk[] = dateCompareTodo(todoVo);
		long chk = dateCompareTodo(todoVo);
		
//		if(chk[0] >= 0 || chk[1] >= 0) {
		if(chk >= 0) {
			return todoMapper.todoUpdate(todoVo);
		}
		return -400;
	}

	/**
	* Method : getProjectEndDateTodo
	* 작성자 : jerry
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : TODO 등록시 프로젝트 종료일 조회
	*/
	@Override
	public ToDoVo getProjectEndDateTodo(ToDoVo todoVo) {
		return todoMapper.getProjectEndDateTodo(todoVo);
	}
	
	/**
	 * Method : todoUpdate
	 * 작성자 : Mr.KKu
	 * 변경이력 :
	 * @param todoMap
	 * @return
	 * Method 설명 : to-do 진행상황 표시
	 */
	@Override
	public Integer todoComplete(Map<String, String> todoMap) {
		return todoMapper.todoComplete(todoMap);
	}

	/**
	 * Method : todoUpdate
	 * 작성자 : Mr.KKu
	 * 변경이력 :
	 * @param todo_id
	 * @return
	 * Method 설명 : to-do 객체 검색
	 */
	@Override
	public ToDoVo selectTodo(String todo_id) {
		return todoMapper.selectTodo(todo_id);
	}

	/**
	 * Method : todoUpdate
	 * 작성자 : Mr.KKu
	 * 변경이력 :
	 * @param work_id
	 * @return
	 * Method 설명 : to-do 객체 검색
	 */
	@Override
	public List<ToDoVo> selectCntTodoList(String work_id) {
		return todoMapper.selectCntTodoList(work_id);
	}

	/**
	 * Method : todoUpdate
	 * 작성자 : Mr.KKu
	 * 변경이력 :
	 * @param work_id
	 * @return
	 * Method 설명 : to-do 완료 객체 검색
	 */
	@Override
	public List<ToDoVo> selectCntTodoComplete(String work_id) {
		return todoMapper.selectCntTodoComplete(work_id);
	}

	/**
	* Method : dateCompareTodo
	* 작성자 : jerry
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : TODO 등록일 및 수정일이 프로젝트 종료일보다 후일이면 등록되지 않는다.
	*/
	public long dateCompareTodo(ToDoVo todoVo) {
		ToDoVo projectDateValue = getProjectEndDateTodo(todoVo);
		Date project_edate = null;
		Date todo_edate = null;
//		long chk[] = new long[2];
		
		if(projectDateValue.getProject_edate() != null) {
			project_edate = projectDateValue.getProject_edate();
		} else {
			project_edate = projectDateValue.getProject_eedate();
		}
		
		if(todoVo.getTodo_edate() != null) {
			todo_edate = todoVo.getTodo_edate();
		} else {
			todo_edate = todoVo.getTodo_eedate();
		}
		
		long chk_sdate = project_edate.getTime() - todoVo.getTodo_sdate().getTime();
		//long chk_edate = project_edate.getTime() - todo_edate.getTime();
		
//		chk[0] = chk_sdate;
//		chk[1] = chk_edate;
		
		return chk_sdate;
	}
	
}
