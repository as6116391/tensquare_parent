package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-06 22:08
 * @ClassName : ArticleController
 * @Description : 表现层
 */
@RestControllerAdvice
@RequestMapping("/article")
@Api(value = "文章相关接口", tags = "文章相关接口")
@CrossOrigin  //跨域访问
public class ArticleController {

    @Autowired(required = false)
    private ArticleService articleService;

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:54
    * @param
    * @Description    查询全部文章
    * @Return  com.tensquare.entity.Result
    */
    @ApiOperation("查询全部用户")
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Article> list = articleService.findAll();
        int a = 1/0;
        return new Result(true, StatusCode.OK, "文章查询成功", list);

    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:53
    * @param articleId 文章id
    * @Description    根据id查询
    * @Return  com.tensquare.entity.Result
    */
    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("articleId") String articleId) {
        Article article = articleService.findById(articleId);
        return new Result(true, StatusCode.OK, "文章查询成功", article);
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:53
    * @param article   文章内容
    * @Description    新增文章
    * @Return  com.tensquare.entity.Result
    */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:53
    * @param id        文章id
    * @param article   文章内容
    * @Description     更新文章
    * @Return  com.tensquare.entity.Result
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:46
    * @param id
    * @Description    删除文章
    * @Return  com.tensquare.entity.Result
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id) {
        articleService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }



    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 19:11
    * @param page    当前页
    * @param size    每页显示数量
    * @param map     查询条件
    * @Description
    * @Return  com.tensquare.entity.Result
    */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findPage(@PathVariable("page") Integer page,
                           @PathVariable("size") Integer size,
                           @RequestBody Map map){
        Page<Article> pageList = articleService.findPage(page,size,map);
        return new Result(true, StatusCode.OK,"查询成功",pageList);
    }


}
