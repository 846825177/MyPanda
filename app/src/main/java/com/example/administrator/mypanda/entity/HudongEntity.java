package com.example.administrator.mypanda.entity;

import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/5
 */

public class HudongEntity  {

    private List<InteractiveBean> interactive;

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }

    @Override
    public String toString() {
        return "HudongEntity{" +
                "interactive=" + interactive +
                '}';
    }

    public static class InteractiveBean {
        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626374961_922.jpg
         * title : 二十四节气——芒种
         * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
         * order : 1
         */

        private String image;
        private String title;
        private String url;
        private String order;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "InteractiveBean{" +
                    "image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }
    }
}
