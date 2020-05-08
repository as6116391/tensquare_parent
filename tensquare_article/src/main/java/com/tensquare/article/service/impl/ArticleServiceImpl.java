package com.tensquare.article.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-06 22:58
 * @ClassName : ArticleServiceImpl
 * @Description : 文章业务层实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:54
    * @param
    * @Description    查询全部
    * @Return  java.util.List<com.tensquare.article.pojo.Article>
    */
    @Override
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:54
    * @param articleId
    * @Description    根据id查询文章
    * @Return  com.tensquare.article.pojo.Article
    */
    @Override
    public Article findById(String articleId) {
        return articleDao.selectById(articleId);
    }



    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:54
    * @param article
    * @Description    新增文章
    * @Return  void
    */
    @Override
    public void add(Article article) {
        //1.新增文章
        article.setId(idWorker.nextId() + "");
        article.setUserid("123456");//实际项目中是从token中解析获取的  （参考电商项目）
        article.setCreatetime(new Date()); //文章发布时间
        article.setIspublic("0");//0:默认不公开
        article.setIstop("0");  //0:不置顶
        article.setVisits(0);   //浏览量
        article.setThumbup(0);  //点赞数
        article.setComment(0);  //评论数


        articleDao.insert(article);
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:55
    * @param article
    * @Description    修改文章
    * @Return  void
    */
    @Override
    public void update(Article article) {
        //根据id进行修改
        articleDao.updateById(article);

        //方式二
        //EntityWrapper<Article> wrapper = new EntityWrapper<>();
        //wrapper.eq("id",article.getId());
        //articleDao.update(article, wrapper);
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 18:55
    * @param id        文章id
    * @Description    删除文章
    * @Return  void
    */
    @Override
    public void delete(String id) {
        articleDao.deleteById(id);
    }


    /**
    * @Author  闵波路三舅
    * @Date  2020/5/7 20:23
    * @param page
    * @param size
    * @param map
    * @Description     分页查询
    * @Return  com.baomidou.mybatisplus.plugins.Page<com.tensquare.article.pojo.Article>
    */
    @Override
    public Page<Article> findPage(Integer page, Integer size, Map map) {

        //封装枫叶对象
        Page<Article> pageList = new Page<>(page,size);

        //封装条件对象
        EntityWrapper<Article> entityWrapper = new EntityWrapper<>();

        //专栏id
        if (!StringUtils.isEmpty(map.get("columnid"))){
            entityWrapper.eq("columnid",map.get("columnid"));
        }

        //用户id
        if (!StringUtils.isEmpty(map.get("userid"))){
            entityWrapper.eq("userid",map.get("userid"));
        }

        //标题
        if (!StringUtils.isEmpty(map.get("title"))){
            //模糊查询
            entityWrapper.like("title","%"+map.get("title")+"%");
        }

        //文章正文
        if (!StringUtils.isEmpty(map.get("content"))){
            entityWrapper.like("content","%"+map.get("content")+"%");
        }

        //根据条件查询数据
        List<Article> articles = articleDao.selectPage(pageList, entityWrapper);

        //把查询出来的数据封装到分页对象里
        pageList.setRecords(articles);

        return pageList;
    }
}
