package com.workury.workuryweb.controller;

import com.workury.workuryweb.entity.DoubleIdObjectEntity;
import com.workury.workuryweb.entity.IdObjectEntity;
import com.workury.workuryweb.entity.PostEntity;
import com.workury.workuryweb.service.PostService;
import com.workury.workuryweb.service.ResponseObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/insertpost")
    public ResponseEntity<ResponseObjectService> insertPost(
        @RequestBody PostEntity inputPost
    ) {
        return new ResponseEntity<ResponseObjectService>(
            postService.insertPost(inputPost),
            HttpStatus.OK
        );
    }

    @PostMapping("/myposts")
    public ResponseEntity<ResponseObjectService> findPostByUserId(
        @RequestBody IdObjectEntity inputUserId
    ) {
        return new ResponseEntity<ResponseObjectService>(
            postService.findPostByUserId(inputUserId),
            HttpStatus.OK
        );
    }

    @PostMapping("/followingposts")
    public ResponseEntity<ResponseObjectService> findPostByFollowing(
        @RequestBody IdObjectEntity inputUserId
    ) {
        return new ResponseEntity<ResponseObjectService>(
            postService.findPostByFollowing(inputUserId),
            HttpStatus.OK
        );
    }

    // currently not in use, post is update via comment controller
    // @PutMapping("/updatebycomment")
    // public ResponseEntity<ResponseObjectService> updateByComment(@RequestBody PostEntity inputPost) {
    //     return new ResponseEntity<ResponseObjectService>(postService.updatePostByComment(inputPost), HttpStatus.OK);
    // }

    @PostMapping("/lovepost")
    public ResponseEntity<ResponseObjectService> lovePost(
        @RequestBody DoubleIdObjectEntity doubleId
    ) {
        return new ResponseEntity<ResponseObjectService>(
            postService.updatePostByLove(doubleId),
            HttpStatus.OK
        );
    }

    @PostMapping("/sharepost")
    public ResponseEntity<ResponseObjectService> sharePost(
        @RequestBody DoubleIdObjectEntity doubleId
    ) {
        return new ResponseEntity<ResponseObjectService>(
            postService.updatePostByShare(doubleId),
            HttpStatus.OK
        );
    }
}
