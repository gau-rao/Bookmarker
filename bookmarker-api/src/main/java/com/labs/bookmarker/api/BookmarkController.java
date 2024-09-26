package com.labs.bookmarker.api;

import com.labs.bookmarker.domain.Bookmark;
import com.labs.bookmarker.domain.BookmarkService;
import com.labs.bookmarker.domain.BookmarksDTO;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "") String query) {
        if (query == null || query.trim().length() == 0) {

            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);

    }
}
















