package com.example.relation.domain.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProfanityValidator.class) // 유효성 검사 클래스 지정
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 어노테이션 적용 위치
@Retention(RetentionPolicy.RUNTIME) // 런타임에 유지
public @interface NoProfanity {
    String message() default "내용에 욕설이 포함되어 있습니다."; // 기본 오류 메시지

    Class<?>[] groups() default {}; // 그룹 지정 (기본)

    Class<? extends Payload>[] payload() default {}; // 부가 데이터 지정
}
