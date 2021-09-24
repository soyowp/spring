package org.ict.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	// 페이지 번호, 페이지당 몇 개의 글을 보여줄지에 대해
	// 먼저 저장하고, 이를 이용해 나머지 정보를 계산
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
