package com.example.administrator.mypanda.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/17
 */

public class ChiledEntity {


    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"5450"}
     * video : [{"vsid":"VSET100167216881","order":"5463","vid":"5343b8fbb466466186753351a0282c61","t":"《精彩一刻》 20171117 这段看了都想笑","url":"http://tv.cntv.cn/video/VSET100167216881/5343b8fbb466466186753351a0282c61","ptime":"2017-11-17 10:21:14","img":"http://p5.img.cctvpic.com/fmspic/2017/11/17/5343b8fbb466466186753351a0282c61-20.jpg?p=2&h=120","len":"00:00:31","em":"CM01"},{"vsid":"VSET100167216881","order":"5462","vid":"369444f8ee1d4aa4acfc69145c68a713","t":"《精彩一刻》 20171117 谁在用皮毛弹奏一曲东风破","url":"http://tv.cntv.cn/video/VSET100167216881/369444f8ee1d4aa4acfc69145c68a713","ptime":"2017-11-17 10:20:29","img":"http://p1.img.cctvpic.com/fmspic/2017/11/17/369444f8ee1d4aa4acfc69145c68a713-21.jpg?p=2&h=120","len":"00:00:35","em":"CM01"},{"vsid":"VSET100167216881","order":"5464","vid":"29868c383f324fc8b7741b834e28b7af","t":"《精彩一刻》 20171117 \u201c迎迎\u201d打牌输了","url":"http://tv.cntv.cn/video/VSET100167216881/29868c383f324fc8b7741b834e28b7af","ptime":"2017-11-17 10:19:41","img":"http://p1.img.cctvpic.com/fmspic/2017/11/17/29868c383f324fc8b7741b834e28b7af-20.jpg?p=2&h=120","len":"00:00:30","em":"CM01"},{"vsid":"VSET100167216881","order":"5460","vid":"fd8a917c11594069926ce37735714a9c","t":"《精彩一刻》 20171117 毯子的味道我知道","url":"http://tv.cntv.cn/video/VSET100167216881/fd8a917c11594069926ce37735714a9c","ptime":"2017-11-17 10:18:53","img":"http://p3.img.cctvpic.com/fmspic/2017/11/17/fd8a917c11594069926ce37735714a9c-23.jpg?p=2&h=120","len":"00:00:39","em":"CM01"},{"vsid":"VSET100167216881","order":"5461","vid":"cb2557e1d6164c34b0cababd5d196cd3","t":"《精彩一刻》 20171117 游客大呼像抱孩儿一样","url":"http://tv.cntv.cn/video/VSET100167216881/cb2557e1d6164c34b0cababd5d196cd3","ptime":"2017-11-17 10:17:46","img":"http://p2.img.cctvpic.com/fmspic/2017/11/17/cb2557e1d6164c34b0cababd5d196cd3-40.jpg?p=2&h=120","len":"00:01:00","em":"CM01"},{"vsid":"VSET100167216881","order":"5458","vid":"7ceb194073a645cc93d15265af9061d0","t":"《精彩一刻》 20171116 果果，给我吃嘛~","url":"http://tv.cntv.cn/video/VSET100167216881/7ceb194073a645cc93d15265af9061d0","ptime":"2017-11-16 14:51:24","img":"http://p4.img.cctvpic.com/fmspic/2017/11/16/7ceb194073a645cc93d15265af9061d0-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"5457","vid":"6435fc43be454474aff3107c5acf78c4","t":"《精彩一刻》 20171116 今天是活力少女宝~","url":"http://tv.cntv.cn/video/VSET100167216881/6435fc43be454474aff3107c5acf78c4","ptime":"2017-11-16 14:50:27","img":"http://p4.img.cctvpic.com/fmspic/2017/11/16/6435fc43be454474aff3107c5acf78c4-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 5450
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 5463
         * vid : 5343b8fbb466466186753351a0282c61
         * t : 《精彩一刻》 20171117 这段看了都想笑
         * url : http://tv.cntv.cn/video/VSET100167216881/5343b8fbb466466186753351a0282c61
         * ptime : 2017-11-17 10:21:14
         * img : http://p5.img.cctvpic.com/fmspic/2017/11/17/5343b8fbb466466186753351a0282c61-20.jpg?p=2&h=120
         * len : 00:00:31
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
