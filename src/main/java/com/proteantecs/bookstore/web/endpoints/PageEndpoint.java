package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Page;
import com.proteantecs.bookstore.services.PageService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

public class PageEndpoint extends ResourceRepositoryBase<Page, Long> {


    private final PageService pageService;

    public PageEndpoint(PageService pageService) {
        super(Page.class);
        this.pageService = pageService;
    }

    @Override
    public ResourceList<Page> findAll(QuerySpec querySpec) {
        return null;
    }
}
