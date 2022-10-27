package com.example.markdown_memo.domain.group;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.markdown_memo.domain.membership.MembershipService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final MembershipService membershipService;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(int groupId) {
        return groupRepository.findById(groupId);
    }

    public void createMain(int userId) {
        final Group group = new Group(0, null);
        groupRepository.insertMain(group);
        membershipService.create(userId, group.getGroupId());
    }
}
