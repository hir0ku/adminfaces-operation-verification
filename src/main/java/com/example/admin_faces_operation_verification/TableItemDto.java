package com.example.admin_faces_operation_verification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

@Builder
@Setter
@Getter
public class TableItemDto implements Serializable {

    private String word0;

    private int number1;

    private String word1;

    private double number2;

    public static TableItemDto createRandomItem() {
        int a = (int) (Math.random() * 10);
        double b = Math.random();
        return TableItemDto.builder()
                .word0(RandomStringUtils.randomAlphabetic(10))
                .word1(RandomStringUtils.randomAlphabetic(5))
                .number1(1)
                .number2(b)
                .build();
    }
}
