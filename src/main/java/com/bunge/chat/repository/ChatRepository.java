package com.bunge.chat.repository;

import com.bunge.chat.domain.ChatListDto;
import com.bunge.chat.domain.ChatRequestDto;

import java.util.List;

public interface ChatRepository {

    ChatRequestDto save(ChatRequestDto requestDto);

    ChatRequestDto saveRelation(ChatRequestDto requestDto);

    List<ChatListDto> findAllByMemberId(String memberId);
}
