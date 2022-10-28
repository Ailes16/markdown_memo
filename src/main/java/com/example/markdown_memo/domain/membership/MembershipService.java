package com.example.markdown_memo.domain.membership;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public List<Integer> findByUserId(int userId) {
        return membershipRepository.findByUserId(userId);
    }

    public void create(int userId, int groupId) {
        membershipRepository.insert(userId, groupId);
    }
}
