package com.example.socketpractice.global.security;

import com.example.socketpractice.domain.user.entity.User;
import com.example.socketpractice.domain.user.repository.UserRepository;
import com.example.socketpractice.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User member = memberRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(ErrorCode.NOT_FOUND_EMAIL.getMsg())
        );
        return new UserDetailsImpl(member);
    }
}
