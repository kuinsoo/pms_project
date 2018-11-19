package kr.or.ddit.card.mapper;

import kr.or.ddit.card.model.CardVo;

import java.util.List;

/**
 * kr.or.ddit.card.mapper
 * null.java
 * Desc : Card Mapper
 *
 * @Author : Mr.KKu
 * @Date : 2018-11-19 / 오후 2:07
 * @Version :
 */
public interface CardMapper {

	List<CardVo> selectAllCard();

	List<CardVo> selectGroupCard(String groupNo);

	CardVo selectCard(int cardNo);

	int createCard(CardVo cardVo);

	int updateCard(CardVo cardVo);

	int deleteCard(int cardNo);

}
