package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendBoardService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;

@Controller
@SessionAttributes({"authenticated","existing"})
@RequestMapping("/topGun")
public class BackendBoardController {
	
	
	
	@Autowired
	private BackendBoardService backendBoardService;
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增留言跳頁
	@GetMapping("/board/add")
	public String addNewBoardForm(Model model) {
		
		Board board = new Board();
		
		model.addAttribute("board", board);
		
		Board latestBoard = backendBoardService.findLatestBoard();
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(latestBoard);
		System.out.println("=====================");
		System.out.println("=====================");
		
		model.addAttribute("latestBoard", latestBoard);
		
		
		return "/Ryu/backendAddNewBoardForm";
		
	}
	
	
	
	// 新增留言
	@PostMapping("/board/post")
	public String addNewRegisterPost(@ModelAttribute("board") Board board, Model model, 
			RedirectAttributes redirectAttributes) {
		
		Register register = (Register) model.getAttribute("existing");
//		Register register = (Register) model.getAttribute("existing");
		
		board.setRegister(register);
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(register);
		System.out.println("=====================");
		System.out.println("=====================");
		
		String title = board.getTitle();
		
		backendBoardService.insertBoard(board);
		
//		Board newboard = new Board();
//		
//		model.addAttribute("board", newboard);
//		
//		Board latestBoard = backendBoardService.findLatestBoard();
//		
//		System.out.println("=====================");
//		System.out.println("=====================");
//		System.out.println(latestBoard);
//		System.out.println("=====================");
//		System.out.println("=====================");
//		
//		model.addAttribute("latestBoard", latestBoard);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "留言 [ " + title + " ] 新增成功");
		
//		return "/Ryu/backendAddNewBoardForm";
		
		return "redirect:/topGun/board/add";
		
	}
	
	
	
	// 分頁查詢留言
	@GetMapping("/board/page")
	public String showBoardByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Board> page = backendBoardService.findBoardByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowBoard";
		
	}
	
	
	
	// 修改留言跳頁
	@GetMapping("/board/edit")
	public String editBoardPage(@RequestParam("boardId") Integer boardId, Model model) {
		
		Board board = backendBoardService.findBoardById(boardId);
		
		model.addAttribute("board", board);
		
		return "/Ryu/backendEditBoardForm";
		
	}
	
	
	
	
	
	
	// 修改留言
	@PutMapping("/board/editPost")
	public String editPostBoard(@ModelAttribute("board") Board board, 
			RedirectAttributes redirectAttributes) {
		
		String title = board.getTitle();
		
		backendBoardService.updateBoard(board);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "留言 [ " + title + " ] 新增成功");
		
		return "redirect:/topGun/board/page";
		
	}
	
	
	
	// 刪除留言
	@DeleteMapping("/board/delete")
	public String deleteBoard(@RequestParam("boardId") Integer boardId, 
			RedirectAttributes redirectAttributes) {
		
		Board presentBoard = backendBoardService.findBoardById(boardId);
		
		String title = presentBoard.getTitle();
		
		backendBoardService.deleteBoardById(boardId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "留言 [ " + title + " ] 刪除成功");
		
		return "redirect:/topGun/board/page";
		
	}
	
	
	
	// 依帳號查詢Board跳頁
	@GetMapping("/board/queryLikeAccount")
	public String getBoardByAccountForm(Model model) {
		
		return "/Ryu/backendShowBoardByAccount";
		
	}
	
	
	
	// 依帳號查詢Board
	@GetMapping("/board/queryLikeAccountPost")
	public String getBoardByAccount(@RequestParam("account") String account, Model model) {
		
		List<Register> register = backendRegisterService.findRegisterByAccountNativeLikeQuery(account);
		
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendShowBoardByAccount";
		
	}
	
	
	
	// 依帳號查詢Board的Detail
	@GetMapping("/board/queryLikeAccountDetail")
	public String getBoardByAccountDetail(@RequestParam("r") Register register, Model model) {
		
		List<Board> boardDetail = backendBoardService.findBoardByAccountGroupByR(register);
		
		model.addAttribute("boardDetail", boardDetail);
		
		return "/Ryu/backendShowBoardDetailByAccount";
		
	}
	
	
	
	
	// 條件搜尋之修改留言跳頁
	@GetMapping("/board/editByAccount")
	public String editBoardPageByAccount(@RequestParam("boardId") Integer boardId, Model model) {
		
		Board board = backendBoardService.findBoardById(boardId);
		
		model.addAttribute("board", board);
		
		return "/Ryu/backendHomeEditBoardForm";
		
	}
	
	
	// 條件搜尋之修改留言
	@PutMapping("/board/editPostByAccount")
	public String editPostBoardByAccount(@ModelAttribute("board") Board board, 
			RedirectAttributes redirectAttributes) {
		
		String title = board.getTitle();
		
		Register register = board.getRegister();
		
		String account = register.getAccount();
		
		backendBoardService.updateBoard(board);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", " 會員 [ "+ account + " ] 留言 [ " + title + " ] 修改成功");
		
		return "redirect:/topGun/board/queryLikeAccount";
		
	}
	
	
	
	
	// 條件搜尋之刪除留言
	@DeleteMapping("/board/deleteByAccount")
	public String deleteBoardByAccount(@RequestParam("boardId") Integer boardId, 
			RedirectAttributes redirectAttributes) {
		
		Board presentBoard = backendBoardService.findBoardById(boardId);
		
		Register register = presentBoard.getRegister();
		
		String account = register.getAccount();
		
		String title = presentBoard.getTitle();
		
		backendBoardService.deleteBoardById(boardId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", " 會員 [ "+ account + " ]，留言 [ " + title + " ] 刪除成功");
		
		return "redirect:/topGun/board/queryLikeAccount";
		
	}
	
	
	

}
