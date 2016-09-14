package com.hlj.user.retrofitdemo;

/**
 * Created by ${csj} on 16/8/2.
 */
public class ProductInfo {

    /**
     * code : 0
     * body : {"id":17789,"name":"姨妈枣17789","desc":"姨妈枣17789","topcategoryid":1,"dashinfo":"包子","headimg":"http://hljimage.img-cn-qingdao.aliyuncs.com/20151109/16b4ec2b45132512.jpg","saled":11,"price":"0.20","saleprice":"39.00","canbuymax":-1,"seckill":{}}
     */

    private int code;
    /**
     * id : 17789
     * name : 姨妈枣17789
     * desc : 姨妈枣17789
     * topcategoryid : 1
     * dashinfo : 包子
     * headimg : http://hljimage.img-cn-qingdao.aliyuncs.com/20151109/16b4ec2b45132512.jpg
     * saled : 11
     * price : 0.20
     * saleprice : 39.00
     * canbuymax : -1
     * seckill : {}
     */

    private BodyEntity body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class BodyEntity {
        private int id;
        private String name;
        private String desc;
        private int topcategoryid;
        private String dashinfo;
        private String headimg;
        private int saled;
        private String price;
        private String saleprice;
        private int canbuymax;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getTopcategoryid() {
            return topcategoryid;
        }

        public void setTopcategoryid(int topcategoryid) {
            this.topcategoryid = topcategoryid;
        }

        public String getDashinfo() {
            return dashinfo;
        }

        public void setDashinfo(String dashinfo) {
            this.dashinfo = dashinfo;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public int getSaled() {
            return saled;
        }

        public void setSaled(int saled) {
            this.saled = saled;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSaleprice() {
            return saleprice;
        }

        public void setSaleprice(String saleprice) {
            this.saleprice = saleprice;
        }

        public int getCanbuymax() {
            return canbuymax;
        }

        public void setCanbuymax(int canbuymax) {
            this.canbuymax = canbuymax;
        }

        @Override
        public String toString() {
            return "BodyEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    ", topcategoryid=" + topcategoryid +
                    ", dashinfo='" + dashinfo + '\'' +
                    ", headimg='" + headimg + '\'' +
                    ", saled=" + saled +
                    ", price='" + price + '\'' +
                    ", saleprice='" + saleprice + '\'' +
                    ", canbuymax=" + canbuymax +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "code=" + code +
                ", body=" + body +
                '}';
    }
}
