package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Page;
import io.crnk.core.queryspec.QuerySpec;

import java.util.List;

public interface PageService {

    Page save(Page page);

    Page update(Long id, Page page);

    List<Page> findAll(QuerySpec querySpec);

    Page getById(Long id);

    Page delete(Long id);
}
