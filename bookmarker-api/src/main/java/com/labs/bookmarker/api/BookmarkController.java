package com.labs.bookmarker.api;
import com.labs.bookmarker.domain.BookmarkDTO;
import com.labs.bookmarker.domain.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request){
        return bookmarkService.createBookmark(request);
    }


}
















