package com.example.markdown_memo.domain.memo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public List<Memo> findAll(int groupId) {
        return memoRepository.findAll(groupId);
    }

    public Memo findById(int memoId) {
        return memoRepository.findById(memoId);
    }

    @Transactional
    public void create(String memoName, String content, int groupId) {
        memoRepository.insert(memoName, content, groupId);
    }

    @Transactional
    public void update(int memoId, String memoName, String content) {
        memoRepository.update(memoId, memoName, content);
    }

    @Transactional
    public void delete(int memoId) {
        memoRepository.delete(memoId);
    }
}
