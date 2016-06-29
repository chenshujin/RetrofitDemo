package com.hlj.user.retrofitdemo.bean;

import java.util.List;

/**
 * Created by ${csj} on 16/6/8.
 */
public class OrderInfo {
    private int id;
    private String name;
    private int type;
    private int status;
    private String closedesc;
    private double minprice;
    private String contactmobile;
    private String fastesttime;
    private String lastesttime;
    private DeliverytimeEntity deliverytime;
    private List<String> subscribedates;
    private List<ChannelsEntity> channels;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setClosedesc(String closedesc) {
        this.closedesc = closedesc;
    }

    public void setMinprice(double minprice) {
        this.minprice = minprice;
    }

    public void setContactmobile(String contactmobile) {
        this.contactmobile = contactmobile;
    }

    public void setFastesttime(String fastesttime) {
        this.fastesttime = fastesttime;
    }

    public void setLastesttime(String lastesttime) {
        this.lastesttime = lastesttime;
    }

    public void setDeliverytime(DeliverytimeEntity deliverytime) {
        this.deliverytime = deliverytime;
    }

    public void setSubscribedates(List<String> subscribedates) {
        this.subscribedates = subscribedates;
    }

    public void setChannels(List<ChannelsEntity> channels) {
        this.channels = channels;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public String getClosedesc() {
        return closedesc;
    }

    public double getMinprice() {
        return minprice;
    }

    public String getContactmobile() {
        return contactmobile;
    }

    public String getFastesttime() {
        return fastesttime;
    }

    public String getLastesttime() {
        return lastesttime;
    }

    public DeliverytimeEntity getDeliverytime() {
        return deliverytime;
    }

    public List<String> getSubscribedates() {
        return subscribedates;
    }

    public List<ChannelsEntity> getChannels() {
        return channels;
    }

    public static class DeliverytimeEntity {
        /**
         * dayfasttime : 06:30
         * daylasttime : 08:30
         * weekendfasttime : 06:30
         * weekendlasttime : 08:30
         * holidaystartdate :
         * holidayenddate :
         * holidayfasttime :
         * holidaylasttime :
         */

        private String dayfasttime;
        private String daylasttime;
        private String weekendfasttime;
        private String weekendlasttime;
        private String holidaystartdate;
        private String holidayenddate;
        private String holidayfasttime;
        private String holidaylasttime;

        public void setDayfasttime(String dayfasttime) {
            this.dayfasttime = dayfasttime;
        }

        public void setDaylasttime(String daylasttime) {
            this.daylasttime = daylasttime;
        }

        public void setWeekendfasttime(String weekendfasttime) {
            this.weekendfasttime = weekendfasttime;
        }

        public void setWeekendlasttime(String weekendlasttime) {
            this.weekendlasttime = weekendlasttime;
        }

        public void setHolidaystartdate(String holidaystartdate) {
            this.holidaystartdate = holidaystartdate;
        }

        public void setHolidayenddate(String holidayenddate) {
            this.holidayenddate = holidayenddate;
        }

        public void setHolidayfasttime(String holidayfasttime) {
            this.holidayfasttime = holidayfasttime;
        }

        public void setHolidaylasttime(String holidaylasttime) {
            this.holidaylasttime = holidaylasttime;
        }

        public String getDayfasttime() {
            return dayfasttime;
        }

        public String getDaylasttime() {
            return daylasttime;
        }

        public String getWeekendfasttime() {
            return weekendfasttime;
        }

        public String getWeekendlasttime() {
            return weekendlasttime;
        }

        public String getHolidaystartdate() {
            return holidaystartdate;
        }

        public String getHolidayenddate() {
            return holidayenddate;
        }

        public String getHolidayfasttime() {
            return holidayfasttime;
        }

        public String getHolidaylasttime() {
            return holidaylasttime;
        }
    }

    public static class ChannelsEntity {
        /**
         * id : 2
         * title : 兼职招募
         * path : http://hlj-static.oss-cn-beijing.aliyuncs.com/image/channel-icons/4.png
         * h5url : /static/joinus
         * appurl :
         */

        private int id;
        private String title;
        private String path;
        private String h5url;
        private String appurl;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public void setH5url(String h5url) {
            this.h5url = h5url;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPath() {
            return path;
        }

        public String getH5url() {
            return h5url;
        }

        public String getAppurl() {
            return appurl;
        }
    }
}
