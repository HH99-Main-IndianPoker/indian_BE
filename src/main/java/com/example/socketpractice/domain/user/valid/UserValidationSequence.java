package com.example.socketpractice.domain.user.valid;

import com.example.socketpractice.domain.user.valid.UserValidationGroup.NotBlankGroup;
import jakarta.validation.GroupSequence;

import static com.example.socketpractice.domain.user.valid.UserValidationGroup.*;

@GroupSequence({
        NotBlankGroup.class,
        EmailBlankGroup.class,
        EmailGroup.class,
        PasswordBlankGroup.class,
        PasswordPatternGroup.class,
        NicknameBlankGroup.class,
        NicknamePatternGroup.class,
})
public interface UserValidationSequence {
}
