package com.hlj.user.retrofitdemo.bean;

import java.util.List;

/**
 * Created by ${csj} on 16/6/7.
 */
public class MovieEntity {
    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsEntity> subjects;

    public void setCount(int count) {
        this.count = count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubjects(List<SubjectsEntity> subjects) {
        this.subjects = subjects;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public String getTitle() {
        return title;
    }

    public List<SubjectsEntity> getSubjects() {
        return subjects;
    }

    public static class SubjectsEntity {
        private RatingEntity rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesEntity images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsEntity> casts;
        private List<DirectorsEntity> directors;

        public void setRating(RatingEntity rating) {
            this.rating = rating;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public void setImages(ImagesEntity images) {
            this.images = images;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public void setCasts(List<CastsEntity> casts) {
            this.casts = casts;
        }

        public void setDirectors(List<DirectorsEntity> directors) {
            this.directors = directors;
        }

        public RatingEntity getRating() {
            return rating;
        }

        public String getTitle() {
            return title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public String getYear() {
            return year;
        }

        public ImagesEntity getImages() {
            return images;
        }

        public String getAlt() {
            return alt;
        }

        public String getId() {
            return id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public List<CastsEntity> getCasts() {
            return casts;
        }

        public List<DirectorsEntity> getDirectors() {
            return directors;
        }

        public static class RatingEntity {
            /**
             * max : 10
             * average : 9.6
             * stars : 50
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public void setMax(int max) {
                this.max = max;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public int getMax() {
                return max;
            }

            public double getAverage() {
                return average;
            }

            public String getStars() {
                return stars;
            }

            public int getMin() {
                return min;
            }

            @Override
            public String toString() {
                return "RatingEntity{" +
                        "max=" + max +
                        ", average=" + average +
                        ", stars='" + stars + '\'' +
                        ", min=" + min +
                        '}';
            }
        }

        public static class ImagesEntity {
            private String small;
            private String large;
            private String medium;

            public void setSmall(String small) {
                this.small = small;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }
        }

        public static class CastsEntity {
            private String alt;
            private AvatarsEntity avatars;
            private String name;
            private String id;

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlt() {
                return alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public static class AvatarsEntity {
                /**
                 * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
                 * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
                 * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public void setSmall(String small) {
                    this.small = small;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public String getLarge() {
                    return large;
                }

                public String getMedium() {
                    return medium;
                }
            }

            @Override
            public String toString() {
                return "CastsEntity{" +
                        "alt='" + alt + '\'' +
                        ", avatars=" + avatars +
                        ", name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }
        }

        public static class DirectorsEntity {

            private String alt;
            private AvatarsEntity avatars;
            private String name;
            private String id;

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlt() {
                return alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public static class AvatarsEntity {
                private String small;
                private String large;
                private String medium;

                public void setSmall(String small) {
                    this.small = small;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public String getLarge() {
                    return large;
                }

                public String getMedium() {
                    return medium;
                }
            }

            @Override
            public String toString() {
                return "DirectorsEntity{" +
                        "alt='" + alt + '\'' +
                        ", avatars=" + avatars +
                        ", name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "SubjectsEntity{" +
                    "rating=" + rating +
                    ", title='" + title + '\'' +
                    ", collect_count=" + collect_count +
                    ", original_title='" + original_title + '\'' +
                    ", subtype='" + subtype + '\'' +
                    ", year='" + year + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", genres=" + genres +
                    ", casts=" + casts +
                    ", directors=" + directors +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
