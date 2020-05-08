package com.tensquare.article.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;

import java.util.List;
import java.util.Map;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-06 22:57
 * @ClassName : ArticleService
 * @Description :
 */
public interface ArticleService {

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/6 22:58
    * @param
    * @Description    查询所有文章
    * @Return  java.util.List<com.tensquare.article.pojo.Article>
    */
    List<Article> findAll();

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/6 23:33
    * @param articleId
    * @Description    根据id查询
    * @Return  com.tensquare.article.pojo.Article
    */
    Article findById(String articleId);

    /**
    * @Author  闵波路三舅
    * @Date  2020/5/6 23:35
    * @param article
    * @Description    发布文章
    * @Return  void
    */
    void add(Article article);


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/6 23:41
    * @param article
    * @Description    更新文章
    * @Return  void
    */
    void update(Article article);


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/6 23:43
    * @param id
    * @Description    删除文章
    * @Return  void
    */
    void delete(String id);


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 19:16
    * @param page       当前页
    * @param size       每页显示数量
    * @param map        条件
    * @Description
    * @Return  com.baomidou.mybatisplus.plugins.Page<com.tensquare.article.pojo.Article>
    */
    Page<Article> findPage(Integer page, Integer size, Map map);
}
