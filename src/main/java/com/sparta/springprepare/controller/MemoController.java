package com.sparta.springprepare.controller;

import com.sparta.springprepare.dto.MemoRequestDto;
import com.sparta.springprepare.dto.MemoResponseDto;
import com.sparta.springprepare.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {
    // 임시 데이터 저장소
    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        // Memo Max ID check
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);
        // DB 저장
        memoList.put(memo.getId(), memo);
        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getAllMemos() {
        // Map To List
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 데이터베이스에 존재하는지 확인
        if (!memoList.containsKey(id)) {
            throw new IllegalArgumentException("Memo not found");
        }
        Memo memo = memoList.get(id);
        // memo 수정
        memo.update(requestDto);
        return memo.getId();
    }

    @DeleteMapping("memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        if (!memoList.containsKey(id)) {
            throw new IllegalArgumentException("Memo not found");
        }
        // memo 삭제
        memoList.remove(id);
        return id;
    }
}
