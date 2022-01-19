package com.technicalTest.technicaltest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebResponse<T> {

    private String message;

    private T data;
}
