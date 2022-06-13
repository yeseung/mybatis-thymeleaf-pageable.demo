package com.gongdaeoppa.mybatisthymeleafpageable.service;

import com.gongdaeoppa.mybatisthymeleafpageable.domain.Board;
import com.gongdaeoppa.mybatisthymeleafpageable.mapper.BoardMapper;
import com.gongdaeoppa.mybatisthymeleafpageable.util.Pagination;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService implements BoardMapper {

    private final BoardMapper boardMapper;

    @Override
    public Long insert(Board board) {
        return boardMapper.insert(board);
    }

    @Override
    public int listTotal(String keyword) {
        return boardMapper.listTotal(keyword);
    }

    @Override
    public List<Board> list(Pagination pagination, String keyword) {
        return boardMapper.list(pagination, keyword);
    }
}
