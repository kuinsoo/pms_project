package kr.or.ddit.member.service;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.project.model.ProjectVo;

import java.util.List;
import java.util.Map;

/**
 * The interface Member service inf.
 */
public interface MemberServiceInf {

	/**
	 * Method : seletUser
	 * 작성자 : 나진실
	 * 변경이력 :
	 *
	 * @param member_mail the member mail
	 * @return Method  설명 : 로그인
	 */
	MemberVo selectUser(String member_mail);

	/**
	 * Method : insertUser
	 * 작성자 : pc07
	 * 변경이력 :
	 *
	 * @param memberVo the member vo
	 * @return Method  설명 : 회원가입
	 */
	public int insertUser(MemberVo memberVo);

	/**
	 * Method : selectfindId
	 * 작성자 : pc07
	 * 변경이력 :
	 *
	 * @param memberVo the member vo
	 * @return Method  설명 : 아이디(이메일) 찾기
	 */
	MemberVo selectfindId(MemberVo memberVo);

	/**
	 * Method : selectfindPass
	 * 작성자 : pc07
	 * 변경이력 :
	 *
	 * @param member_mail the member mail
	 * @return Method  설명 : 비밀번호 찾기
	 */
	MemberVo selectfindPass(String member_mail);

	/**
	 * Method : updatePass
	 * 작성자 : 나진실
	 * 변경이력 :
	 *
	 * @param memberVo the member vo
	 * @return Method  설명 : 비밀번호 찾기 - 임시번호 업데이트
	 */
	int updatePass(MemberVo memberVo);


	/**
	 * Select main view list.
	 * 작성자 : Mr.KKu
	 * 메인 페이지 프로젝트 리스트
	 * @param member_mail the member mail
	 * @return the list
	 */
	List<MemberVo> selectMainView(String member_mail);

	/**
	 * Sets team leader.
	 * 작성자 : Mr.KKu
	 * 프로젝트 참여자 권한 설정
	 * @param mapPMember the map p member
	 * @return the team leader
	 */
	int setTeamLeader(Map<String,String> mapPMember, ProjectVo projectVo);
}
