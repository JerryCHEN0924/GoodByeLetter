package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendBoardService;

@Controller
@SessionAttributes({"authenticated"})
public class BackendBoardController {
	
	
	
	@Autowired
	private BackendBoardService backendBoardService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增留言跳頁
	@GetMapping("/topGun/board/add")
	public String addNewBoardForm(Model model) {
		
		Board board = new Board();
		
		model.addAttribute("board", board);
		
		return "/Ryu/backendAddNewBoardForm";
		
	}
	
	
	
	// 新增留言
	@PostMapping("/topGun/board/post")
	public String addNewRegisterPost(@ModelAttribute("board") Board board, Model model) {
		
		Register register = (Register) model.getAttribute("authenticated");
		
		board.setFK_memberId(register);
		
		backendBoardService.insertBoard(board);
		
		Board newboard = new Board();
		
		model.addAttribute("board", newboard);
		
		return "/Ryu/backendAddNewBoardForm";
		
	}
	
	
	
	// 分頁查詢留言
	@GetMapping("/topGun/board/page")
	public String showRegisterByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Board> page = backendBoardService.findBoardByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowBoard";
		
	}
	
	
	
	// 修改留言跳頁
	@GetMapping("/topGun/board/edit")
	public String editBoardPage(@RequestParam("boardId") Integer boardId, Model model) {
		
		Board board = backendBoardService.findBoardById(boardId);
		
		model.addAttribute("board", board);
		
		return "/Ryu/backendEditBoardForm";
		
	}
	
	
	
	// 修改留言
	@PutMapping("/topGun/board/editPost")
	public String editPostBoard(@ModelAttribute("board") Board board) {
		
		backendBoardService.updateBoard(board);
		
		return "redirect:/topGun/board/page";
		
	}
	
	
	
	// 刪除留言
	@DeleteMapping("/topGun/board/delete")
	public String deleteBoard(@RequestParam("boardId") Integer boardId) {
		
		backendBoardService.deleteBoardById(boardId);
		
		return "redirect:/topGun/board/page";
		
	}
	
	
	
	
	
	

}
