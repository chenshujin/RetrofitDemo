package com.hlj.user.retrofitdemo.bean;

import java.util.List;

/**
 * Created by ${csj} on 16/6/27.
 */
public class Order {

    /**
     * code : 0
     * body : [{"id":"3026","date":"2016-05-24","ordertime":"2016-05-24 18:21:08","statusid":1,"status":"已支付","imgurl":"http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png","business":1},{"id":"3025","date":"2016-05-24","ordertime":"2016-05-24 17:39:55","statusid":1,"status":"已支付","imgurl":"http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png","business":1},{"id":"2921","date":"2016-05-16","ordertime":"2016-05-16 15:36:30","statusid":1,"status":"已支付","imgurl":"http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png","business":1},{"id":"2920","date":"2016-05-16","ordertime":"2016-05-16 15:35:52","statusid":128,"status":"已取消","imgurl":"http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png","business":1},{"id":"2903","date":"2016-05-12","ordertime":"2016-05-12 18:22:45","statusid":128,"status":"已取消","imgurl":"http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png","business":1}]
     */

    private int code;
    private List<BodyEntity> body;

    public void setCode(int code) {
        this.code = code;
    }

    public void setBody(List<BodyEntity> body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public List<BodyEntity> getBody() {
        return body;
    }

    public static class BodyEntity {
        /**
         * id : 3026
         * date : 2016-05-24
         * ordertime : 2016-05-24 18:21:08
         * statusid : 1
         * status : 已支付
         * imgurl : http://hlj-static.img-cn-beijing.aliyuncs.com/image/USER/weekbuy/week-product.png
         * business : 1
         */

        private String id;
        private String date;
        private String ordertime;
        private int statusid;
        private String status;
        private String imgurl;
        private int business;

        public void setId(String id) {
            this.id = id;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setOrdertime(String ordertime) {
            this.ordertime = ordertime;
        }

        public void setStatusid(int statusid) {
            this.statusid = statusid;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public void setBusiness(int business) {
            this.business = business;
        }

        public String getId() {
            return id;
        }

        public String getDate() {
            return date;
        }

        public String getOrdertime() {
            return ordertime;
        }

        public int getStatusid() {
            return statusid;
        }

        public String getStatus() {
            return status;
        }

        public String getImgurl() {
            return imgurl;
        }

        public int getBusiness() {
            return business;
        }
    }
}
