package com.technicalTest.technicaltest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse<T> {

    List<T> content;

    private Long count;

    private Integer totalPage;

    private Integer page;

    private Integer size;
}
