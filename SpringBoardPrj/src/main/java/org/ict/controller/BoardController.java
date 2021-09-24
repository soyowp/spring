package org.ict.controller;

import java.util.List;

import org.ict.domain.BoardVO;
import org.ict.domain.Criteria;
import org.ict.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 컴포넌트스캔 컨트롤러
@Log4j
@RequestMapping("/board/*") // 클래스 위에 작성시
//이 크래스를 사용하는 모든 메서드의 연결주소 앞에 /board/추가
@AllArgsConstructor // 의존성 주입을 위해 생성자만 생성
public class BoardController {
	@Autowired
	private BoardService service;

	/*
	 * @GetMapping("/list") // GET방식으로만 주소 연결 public void list(Model model, String
	 * keyword) { if(keyword == null) { keyword = ""; }
	 * 
	 * log.info(keyword); // 전체 글 정보 얻어오기 List<BoardVO> boardList =
	 * service.getList(keyword); log.info(boardList); // view파일에 list라는 이름으로 넘겨주기
	 * model.addAttribute("list", boardList); model.addAttribute("keyword",keyword);
	 * 
	 * // 1. views 하위에 경로에 맞게 폴더 및 .jsp 생성 // 2. 부트스트랩을 적용해 게시글 목록을 화면에 표시
	 * 
	 * }
	 */

	// 페이징 처리가 되는 리스트 메서드를 새로 연결
	// 페이징 처리용 메서드는 접속주소는 같으나
	// 기존에 받던 자료에 더해서 Criteria를 추가로 입력받는다.
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		List<BoardVO> vo = service.getListPaging(cri);
		log.info(vo);
		model.addAttribute("list", vo);
	}

	// 아래 주소로 데이터를 보내줄수 있는 form을 작성
	// register.jsp파일명으로 작성하고
	// @GetMapping으로 register.jsp에 접근할 수 있는
	// 컨트롤러 메서드도 아래에 작성해주세요
	@PostMapping("/register") // post방식으로만 주소 연결
	public String register(BoardVO vo, RedirectAttributes rttr) {
		// 글을 썼으면 상세페이지나 혹은 글 목록으로
		// 1.글 쓰는 로직 실행 후
		service.regeister(vo);
		log.info(vo);
		// 2. list주소로 강제 이동
		// 이동시킬때 몇 번 글을 썼는지 안내해주는 로직을 추가
		// addFlashAttribut는 redirect시에 컨트롤러에서
		// .jsp파일로 데이터를 보내줄때 사용
		// mode.addAttribut()를 쓴다면
		// 일반 이동이 아닌 redirect 이동시는 데이터가 소실됩니다.
		// 이를 막기 위해 rttr.addFlashAttribute로 대체합니다.
		rttr.addFlashAttribute("success", "register");
		rttr.addFlashAttribute("bno", vo.getBno());

		// views폴더 하위 board폴더의 list.jsp출력
		// redirect로 이동시킬때는 "redirect: 파일명"
		return "redirect:/board/list";
	}

	@GetMapping("/register")
	public String register() {
		return "/board/register";
	}

	// 상세페이지 조회는 LongBno에 적힌 글번호를 이용해 합니다.
	// /get을 주소로 getmapping을 사용하는 메서드 get을 만들어주세요
	// service에서 get()을 호출해 가져욘 글 하나의 정보를
	// get.jsp로 보내줍니다.

	@GetMapping("/get")
	public String get(Long bno, Model model) {
		if (bno == null) {
			return "redirect:/board/list";
		}

		BoardVO vo = service.get(bno);
		log.info("받아온 객체 : " + vo);
		model.addAttribute("detail", vo);
		return "/board/get";
	}

	// get방식으로 삭제를 허용하면 매크로등을 이용해
	// 마음대로 글 삭제가 가능하기때문에
	// 무조건 삭제버튼을 클릭해서 삭제하도록
	// POST방식만 허용
	// bno를 받아서 삭제하고, 삭제 후에는 "success"라는 문자열을
	// .jsp로 보내줍니다
	// 삭제가 완료되면 redirect기능을 이용해 list페이지로 넘어가게
	// 코드 및 파라미터를 내부에 작성해주세요
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("삭제 글번호 : " + bno);
		service.remove(bno);
		rttr.addFlashAttribute("success", "success");
		rttr.addFlashAttribute("bno", bno);
		return "redirect:/board/list";
	}

	// 수정로직도 post방식으로 진행해야 합니다.
	// /modify를 주소로 하고 사용자가 수정할수 있는 요소들을
	// BoardVO로 받아서 수정한 다음 수정한 글의 디테일페이지로 넘어갑니다.

	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("수정할 글 번호 : " + vo.getBno());
		service.modify(vo);
		return "redirect:/board/get?bno=" + vo.getBno();
	}
	// 글 수정시에는 modify.jsp를 이용해 수정합니다.
	// post방식이며 /boardmodify로 접속시 수정폼으로 접근시켜주세요
	// 수정폼은 register.jsp와 비슷한 양식으로 작성합니다.
	// 해당 글이 몇 번인지에 대한 정보 화면에 나타내주고
	// 글쓴이는 readonly로 작성해주세요
	// 아래 메서드는 수정폼으로 접근하도록 만들어주시고
	// 수정폼에는 내가 수정하고자 하는 글의 정보를 먼저 받아온다음
	// model.addAttribute로 정보를 .jsp로 보내서 폼을 채워주세요

	@PostMapping("/boardmodify")
	public String modifyForm(Long bno, Model model) {
		BoardVO vo = service.get(bno);
		log.info(vo);
		model.addAttribute("vo", vo);
		return "board/boardmodify";
	}
}