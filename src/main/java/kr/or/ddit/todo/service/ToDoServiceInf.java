package kr.or.ddit.todo.service;

import java.util.List;

import kr.or.ddit.schedule.model.ScheduleVo;
import kr.or.ddit.todo.model.ToDoVo;

/**
 * kr.or.ddit.todo.service
 * null.java
 * Desc : 할일 서비스 인터페이스
 *
 * @Author : Mr.KKu
 * @Date : 2018-11-27 / 오후 3:31
 * @Version :
 */
public interface ToDoServiceInf {
	
	/**
	* Method : todoAllSchedule
	* 작성자 : jerry
	* 변경이력 : 2018-11-30 09:59
	* @param scheduleVo
	* @return
	* Method 설명 : 할일 전체 일정
	*/
	List<ToDoVo> todoAllSchedule(ScheduleVo scheduleVo);
	
	/**
	* Method : todoInsert
	* 작성자 : jerry
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : to-do 등록
	*/
	int todoInsert(ToDoVo todoVo);
	
	/**
	* Method : workToDoSelect
	* 작성자 : jerry
	* 변경이력 :
	* @param todo_work
	* @return
	* Method 설명 : 각 업무의 to-do list를 조회
	*/
	List<ToDoVo> workToDoSelect(String todo_work);
	
}
