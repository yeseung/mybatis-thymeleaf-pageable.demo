package com.gongdaeoppa.mybatisthymeleafpageable.controller;

import com.gongdaeoppa.mybatisthymeleafpageable.domain.Board;
import com.gongdaeoppa.mybatisthymeleafpageable.service.BoardService;
import com.gongdaeoppa.mybatisthymeleafpageable.util.Pagination;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 2; i++) {
            Board board = new Board();
            board.setTitle("공대오빠-" + UUID.randomUUID());
            boardService.insert(board);
            System.out.println("board.getId() = " + board.getId());
        }
    }

    @GetMapping("/list")
    public String list(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
            Board board, Model model) {

        int listCnt = boardService.listTotal(keyword);
        Pagination pagination = new Pagination(currentPage, cntPerPage, pageSize);
        pagination.setTotalRecordCount(listCnt);

        List<Board> list = boardService.list(pagination, keyword);

        System.out.println("pagination = " + pagination);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);
        model.addAttribute("keyword", keyword);

        return "list";

    }


}
