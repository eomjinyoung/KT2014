package ex03;

import java.util.ArrayList;

public class Episode01 {
	static class Board {
		public String title;
		public String content;
		
		public Board(String title, String content) {
			this.title = title;
			this.content = content;
		}
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new String("홍길동"));
		list.add(new Integer(30));
		
		ArrayList boardList = new ArrayList();
		boardList.add(new Board("111", "111111"));
		boardList.add(new String("okok"));
		
		ArrayList nameList = new ArrayList();
		nameList.add("홍길동");
		nameList.add("임꺽정");
		
		String name = null;
		for (int i = 0; i < nameList.size(); i++) {
			name = (String)nameList.get(i);
			System.out.println(name);
		}
		
		ArrayList<Board> boardList2 = new ArrayList<Board>();
		boardList2.add(new Board("111", "dkdkdk"));
		boardList2.add(new Board("222", "dddd"));
		
		Board board = null;
		for (int i = 0; i < nameList.size(); i++) {
			board = boardList2.get(i);
			System.out.println(name);
		}
		

	}

}
