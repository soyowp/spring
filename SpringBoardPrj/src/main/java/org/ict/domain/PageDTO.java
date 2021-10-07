package org.ict.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int btnNum;

	private int startPage;

	private int endPage;

	private boolean prev, next;

	private int total;

	private Criteria cri;

	public PageDTO(Criteria cri, int total, int btnNum) {
		this.cri = cri;
		this.total = total;
		this.btnNum = btnNum;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) this.btnNum) * this.btnNum);
		this.startPage = this.endPage - this.btnNum + 1;
		
		int realEnd = (int)(Math.ceil((total * 1.0/cri.getAmount())));
		
		if(realEnd < this.endPage ) {
			this.endPage = realEnd;
		}
		
		// prev랑 next는 조건에 따라 구하고 말고가 아니라 항상 구해야해서
		// 조건식 밖에 둬야 합니다.
		this.prev = this.startPage == 1? false : true;
		
		this.next = this.endPage < realEnd;
	}

}