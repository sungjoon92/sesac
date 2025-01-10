package com.example.relation.domain.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ProfanityValidator implements ConstraintValidator<NoProfanity, String> {

    // 욕설 단어 리스트 (예: 금지어)
    private static final List<String> PROFANITY_WORDS = Arrays.asList("시발", "개새끼", "존나", "욕설");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // null이나 빈 문자열은 유효한 것으로 간주
        }

        // 입력값이 금지된 단어를 포함하는지 검사
        for (String word : PROFANITY_WORDS) {
            if (value.toLowerCase().contains(word.toLowerCase())) {
                return false; // 금지된 단어가 포함되어 있으면 유효하지 않음
            }
        }
        return true; // 금지된 단어가 없으면 유효
    }
}
