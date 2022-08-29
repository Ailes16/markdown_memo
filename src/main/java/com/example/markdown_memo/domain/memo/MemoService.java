package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public Memo findById(int memoId) {
        return memoRepository.findById(memoId);
    }
}
