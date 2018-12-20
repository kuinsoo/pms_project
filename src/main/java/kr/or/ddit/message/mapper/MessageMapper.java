package kr.or.ddit.message.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.message.model.MessageVo;
import kr.or.ddit.util.model.PageVo;

/**
 * kr.or.ddit.message.mapper
 * null.java
 * Desc : 쪽지 맵퍼
 *
 * @Author : Mr.KKu
 * @Date : 2018-11-27 / 오후 3:11
 * @Version :
 */
public interface MessageMapper {
	/**
	 * Method : messageReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo 
	 * @param pageVo
	 * @return
	 * Method 설명 :  받은 쪽지 리스트  
	 */
	List<MessageVo> messageReceived (PageVo pageVo);
	
	/**
	 * Method : messageSend
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 보낸 쪽지 리스트 
	 */
	List<MessageVo> messageSend(PageVo pageVo);
	
	/**
	 * Method : totalMsgReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_smember
	 * @return
	 * Method 설명 : 받은 쪽지 갯수 
	 */
	int totalMsgReceived(String msg_rmember);
	
	/**
	 * Method : insertMessageSend
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msgVo
	 * @return
	 * Method 설명 : 쪽지 보내기 
	 */
	int insertMessageSend(MessageVo msgVo);
	
	/**
	 * Method : updateMessageReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msgVo
	 * @return
	 * Method 설명 : 읽음/ 안읽음 구분하기 
	 */
	int updateMessageReceived(MessageVo msgVo);
	
	
	/**
	 * Method : deleteMsgReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_id
	 * @return
	 * Method 설명 : 받은 메시지 삭제부분
	 */
	int deleteMsgReceived(String msg_id);
	
	/**
	 * Method : totalMsgReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_smember
	 * @return
	 * Method 설명 : 보낸 쪽지 갯수 
	 */
	int totalMsgSend(String msg_smember);
	
	/**
	 * Method : selectOneMessageReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_id
	 * @return
	 * Method 설명 : 받은 쪽지 클릭시 detail 팝업 
	 */
	MessageVo selectOneMessageReceived(String msg_id);
	
	/**
	 * Method : selectOneMessageSend
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_id
	 * @return
	 * Method 설명 : 보낸 쪽지 클릭시 detail 팝업 
	 */
	MessageVo selectOneMessageSend(MessageVo msgVo);
	
	
	/**
	 * Method : selectMessageReceived
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param msg_id
	 * @return
	 * Method 설명 : Detail : 클릭했을때 팝업창에 뿌려주기 위함 
	 */
	MessageVo selectMessageReceived(String msg_id);
	
}
