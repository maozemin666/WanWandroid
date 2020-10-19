package com.zemin.wanandroid.module.main.model;

import com.zemin.rxhttp.request.base.BaseBean;

import java.util.List;

/**
 * @Date 2020/7/19 12:18
 * @Created by zemin
 */
public class ArticleListBean extends BaseBean {

    /**
     * curPage : 2
     * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14306,"link":"https://juejin.im/post/5f0d303e6fb9a07e76550d4c","niceDate":"2020-07-15 00:49","niceShareDate":"2020-07-15 00:42","origin":"","prefix":"","projectLink":"","publishTime":1594745364000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1594744938000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"神奇宝贝 眼前一亮的 Jetpack + MVVM 极简实战","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14346,"link":"https://mp.weixin.qq.com/s/prctAxg1qh0XOM6ct8-zOQ","niceDate":"2020-07-15 00:00","niceShareDate":"2020-07-15 23:18","origin":"","prefix":"","projectLink":"","publishTime":1594742400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594826288000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"新技术： Fragment 间通信的新方式","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14347,"link":"https://mp.weixin.qq.com/s/-y0cJg-ULy1lwEOeN_0WqQ","niceDate":"2020-07-15 00:00","niceShareDate":"2020-07-15 23:18","origin":"","prefix":"","projectLink":"","publishTime":1594742400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594826303000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"史上耦合度更低的添加标题栏方式","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14348,"link":"https://mp.weixin.qq.com/s/m3gVGYAPggMUNHNTeS3aDA","niceDate":"2020-07-15 00:00","niceShareDate":"2020-07-15 23:18","origin":"","prefix":"","projectLink":"","publishTime":1594742400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594826317000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"Android 11 Beta 2 和平台稳定性里程碑","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14285,"link":"https://juejin.im/post/5f0cef8b5188252e864b2beb","niceDate":"2020-07-14 07:40","niceShareDate":"2020-07-14 07:40","origin":"","prefix":"","projectLink":"","publishTime":1594683629000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1594683629000,"shareUser":"JsonChao","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"如何深刻影响他人","type":0,"userId":611,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":296,"chapterName":"阅读","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14283,"link":"https://juejin.im/post/5f0b4cab5188252e62285bcb","niceDate":"2020-07-14 00:17","niceShareDate":"2020-07-14 00:14","origin":"","prefix":"","projectLink":"","publishTime":1594657059000,"realSuperChapterId":180,"selfVisible":0,"shareDate":1594656877000,"shareUser":"鸿洋","superChapterId":203,"superChapterName":"延伸技术","tags":[],"title":"如何写出一份&ldquo;有理有据使人信服&rdquo;的Android项目设计文档","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":474,"chapterName":"RxJava","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14284,"link":"https://juejin.im/post/5f0be6a05188252e5961c066","niceDate":"2020-07-14 00:17","niceShareDate":"2020-07-14 00:16","origin":"","prefix":"","projectLink":"","publishTime":1594657046000,"realSuperChapterId":460,"selfVisible":0,"shareDate":1594656979000,"shareUser":"鸿洋","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"减少RxJava中多余的线程调度","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14300,"link":"https://mp.weixin.qq.com/s/bKs5fL5jG915WITc0ZPwbA","niceDate":"2020-07-14 00:00","niceShareDate":"2020-07-14 21:59","origin":"","prefix":"","projectLink":"","publishTime":1594656000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594735181000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"聚焦 Android 11: Android 11 应用兼容性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14301,"link":"https://mp.weixin.qq.com/s/BUEyPk9VInVfnRDrvQPC7w","niceDate":"2020-07-14 00:00","niceShareDate":"2020-07-14 21:59","origin":"","prefix":"","projectLink":"","publishTime":1594656000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594735197000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"10 个小技巧，让你爱上代码","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14302,"link":"https://mp.weixin.qq.com/s/xqrGukIqA2zpGsGzah2EzA","niceDate":"2020-07-14 00:00","niceShareDate":"2020-07-14 22:00","origin":"","prefix":"","projectLink":"","publishTime":1594656000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594735213000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"吹爆系列：深入实战Android卡顿优化","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","canEdit":false,"chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14278,"link":"https://mp.weixin.qq.com/s/c7mOBqNJuaqGnPG4LA-04Q","niceDate":"2020-07-13 00:00","niceShareDate":"2020-07-13 22:31","origin":"","prefix":"","projectLink":"","publishTime":1594569600000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594650715000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android 机型适配终极篇","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14280,"link":"https://mp.weixin.qq.com/s/wjp0rBHr_Da1b0huQ3Aqmw","niceDate":"2020-07-13 00:00","niceShareDate":"2020-07-13 22:32","origin":"","prefix":"","projectLink":"","publishTime":1594569600000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594650752000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"让那个被Layout Inspector 替代的 Android Device Monitor回归！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14281,"link":"https://mp.weixin.qq.com/s/f9BiAW5y_UhRF-XMh98SgA","niceDate":"2020-07-13 00:00","niceShareDate":"2020-07-13 22:32","origin":"","prefix":"","projectLink":"","publishTime":1594569600000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1594650767000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"看完这篇JVM内存管理机制，面试再也不慌了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14267,"link":"https://juejin.im/post/5f05c6dfe51d4534c36d8f59","niceDate":"2020-07-12 23:53","niceShareDate":"2020-07-12 23:53","origin":"","prefix":"","projectLink":"","publishTime":1594569193000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1594569193000,"shareUser":"飞洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"超详细！Activity的启动过程详解 &amp; 应用进程的启动（基于Android10）","type":0,"userId":31360,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":232,"chapterName":"入门及知识点","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14257,"link":"https://juejin.im/post/5f0747486fb9a07ea86dc881","niceDate":"2020-07-12 23:52","niceShareDate":"2020-07-11 14:42","origin":"","prefix":"","projectLink":"","publishTime":1594569127000,"realSuperChapterId":231,"selfVisible":0,"shareDate":1594449778000,"shareUser":"AprilEyon","superChapterId":232,"superChapterName":"Kotlin","tags":[],"title":"为数不多的人知道的 Kotlin 技巧以及 原理解析(二)","type":0,"userId":3559,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":461,"chapterName":"fresco","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14258,"link":"https://juejin.im/post/5f0830b95188252e9a1ffd77","niceDate":"2020-07-12 23:51","niceShareDate":"2020-07-11 15:41","origin":"","prefix":"","projectLink":"","publishTime":1594569117000,"realSuperChapterId":460,"selfVisible":0,"shareDate":1594453264000,"shareUser":"鸿洋","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"给 Arouter 优化的一些小建议","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":478,"chapterName":"DataBinding","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14259,"link":"https://juejin.im/post/5e8090ae6fb9a03c3d7372a2","niceDate":"2020-07-12 23:51","niceShareDate":"2020-07-11 15:41","origin":"","prefix":"","projectLink":"","publishTime":1594569091000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1594453303000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"ViewBinding 的本质","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":173,"chapterName":"Choreographer","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14260,"link":"https://mp.weixin.qq.com/s/sZ-v3hV7IkBjwFSYzAM3iw","niceDate":"2020-07-12 23:51","niceShareDate":"2020-07-11 16:56","origin":"","prefix":"","projectLink":"","publishTime":1594569080000,"realSuperChapterId":152,"selfVisible":0,"shareDate":1594457767000,"shareUser":"simowce","superChapterId":173,"superChapterName":"framework","tags":[],"title":"或许是迄今为止第一篇讲解 fps 计算原理的文章吧","type":0,"userId":69736,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":432,"chapterName":"UI渲染","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14261,"link":"https://www.jianshu.com/p/c61307e79ac2","niceDate":"2020-07-12 23:51","niceShareDate":"2020-07-11 18:19","origin":"","prefix":"","projectLink":"","publishTime":1594569072000,"realSuperChapterId":152,"selfVisible":0,"shareDate":1594462783000,"shareUser":"鸿洋","superChapterId":173,"superChapterName":"framework","tags":[],"title":"Android 之如何优化 UI 渲染（上）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>上一个问答<a href=\"https://wanandroid.com/wenda/show/13775\">每日一问 | Activity与Fragment的那些事，\u201c用起来没问题，我都要走了，你崩溃了？\u201d<\/a> 其实离不开 onSaveInstanceState方法被调用的关系。<\/p>\r\n<p>记得很久以前总记得：\u201conSaveInstanceState 会在系统意外杀死 Activity 时调用，或者横纵屏切换的时候调用\u201d。<\/p>\r\n<p>问题是：<\/p>\r\n<ol>\r\n<li>随着Android SDK版本的变化，这一方法的调用时机有哪些变化？<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":false,"id":13906,"link":"https://wanandroid.com/wenda/show/13906","niceDate":"2020-07-12 23:49","niceShareDate":"2020-06-14 19:33","origin":"","prefix":"","projectLink":"","publishTime":1594568962000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1592134434000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 | 曾经的记忆中&ldquo;onSaveInstanceState 会在系统意外杀死 Activity 时调用&rdquo;，正确吗？","type":0,"userId":2,"visible":1,"zan":11}]
     * offset : 20
     * over : false
     * pageCount : 444
     * size : 20
     * total : 8874
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<ArticleBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ArticleBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ArticleBean> datas) {
        this.datas = datas;
    }
}
