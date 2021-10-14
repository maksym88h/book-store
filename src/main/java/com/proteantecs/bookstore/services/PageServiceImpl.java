package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Page;
import com.proteantecs.bookstore.repositories.PageRepository;
import io.crnk.core.queryspec.QuerySpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private PageRepository pageRepository;

    @Override
    public Page save(Page page) {
        pageRepository.save(page);
        return null;
    }

    @Override
    public Page update(Long id, Page page) {
        final Page pageById = pageRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));

        return pageById
                .builder()
                .color(page.getColor())
                .count(page.getCount())
                .build();
    }

    @Override
    public List<Page> findAll(QuerySpec querySpec) {
        return (List<Page>) pageRepository.findAll();
    }

    @Override
    public Page getById(Long id) {
        return pageRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public Page delete(Long id) {
        final Page pageForDelete = pageRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
        pageRepository.delete(pageForDelete);
        return pageForDelete;
    }
}
