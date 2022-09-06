package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void create(String title, String content) {
        memoRepository.insert(title, content);
    }
}
