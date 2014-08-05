package kr.co.kt.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kt.vo.BoardVO;

public class BoardDAO {

	public List<BoardVO> selectAll() {
		
		List<BoardVO> list = new ArrayList<>();
		list.add(new BoardVO("a", "aaa"));
		list.add(new BoardVO("a2", "aaa2"));
		list.add(new BoardVO("a3", "aaa3"));
		
		return list;
	}
}
