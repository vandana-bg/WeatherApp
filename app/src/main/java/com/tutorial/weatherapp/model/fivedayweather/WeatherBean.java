package com.tutorial.weatherapp.model.fivedayweather;

import java.util.List;

public class WeatherBean {


    /**
     * location : {"name":"Sohana","region":"Punjab","country":"India","lat":30.68,"lon":76.72,"tz_id":"Asia/Kolkata","localtime_epoch":1561355388,"localtime":"2019-06-24 11:19"}
     * current : {"last_updated_epoch":1561354488,"last_updated":"2019-06-24 11:04","temp_c":32.2,"temp_f":90,"is_day":1,"condition":{"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003},"wind_mph":10.1,"wind_kph":16.2,"wind_degree":147,"wind_dir":"SSE","pressure_mb":1007,"pressure_in":30.2,"precip_mm":0,"precip_in":0,"humidity":45,"cloud":6,"feelslike_c":34.2,"feelslike_f":93.6,"vis_km":10,"vis_miles":6,"uv":8,"gust_mph":11.6,"gust_kph":18.7}
     * forecast : {"forecastday":[{"date":"2019-06-24","date_epoch":1561334400,"day":{"maxtemp_c":41.8,"maxtemp_f":107.2,"mintemp_c":27.5,"mintemp_f":81.5,"avgtemp_c":33.3,"avgtemp_f":91.9,"maxwind_mph":12.1,"maxwind_kph":19.4,"totalprecip_mm":4.1,"totalprecip_in":0.16,"avgvis_km":9.6,"avgvis_miles":5,"avghumidity":43,"condition":{"text":"Moderate or heavy rain shower","icon":"//cdn.apixu.com/weather/64x64/day/356.png","code":1243},"uv":11.3},"astro":{"sunrise":"05:22 AM","sunset":"07:30 PM","moonrise":"No moonrise","moonset":"11:24 AM"}},{"date":"2019-06-25","date_epoch":1561420800,"day":{"maxtemp_c":42.4,"maxtemp_f":108.3,"mintemp_c":27.7,"mintemp_f":81.9,"avgtemp_c":35.6,"avgtemp_f":96.1,"maxwind_mph":8.5,"maxwind_kph":13.7,"totalprecip_mm":0.3,"totalprecip_in":0.01,"avgvis_km":10,"avgvis_miles":6,"avghumidity":34,"condition":{"text":"Patchy rain possible","icon":"//cdn.apixu.com/weather/64x64/day/176.png","code":1063},"uv":11.9},"astro":{"sunrise":"05:22 AM","sunset":"07:30 PM","moonrise":"12:21 AM","moonset":"12:16 PM"}},{"date":"2019-06-26","date_epoch":1561507200,"day":{"maxtemp_c":45.3,"maxtemp_f":113.5,"mintemp_c":30.6,"mintemp_f":87.1,"avgtemp_c":38.5,"avgtemp_f":101.2,"maxwind_mph":14.3,"maxwind_kph":23,"totalprecip_mm":0,"totalprecip_in":0,"avgvis_km":10,"avgvis_miles":6,"avghumidity":22,"condition":{"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003},"uv":11.7},"astro":{"sunrise":"05:22 AM","sunset":"07:30 PM","moonrise":"12:52 AM","moonset":"01:10 PM"}},{"date":"2019-06-27","date_epoch":1561593600,"day":{"maxtemp_c":44,"maxtemp_f":111.2,"mintemp_c":30.2,"mintemp_f":86.4,"avgtemp_c":38.5,"avgtemp_f":101.2,"maxwind_mph":19.5,"maxwind_kph":31.3,"totalprecip_mm":0,"totalprecip_in":0,"avgvis_km":10,"avgvis_miles":6,"avghumidity":19,"condition":{"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003},"uv":11.6},"astro":{"sunrise":"05:23 AM","sunset":"07:30 PM","moonrise":"01:23 AM","moonset":"02:05 PM"}},{"date":"2019-06-28","date_epoch":1561680000,"day":{"maxtemp_c":44.2,"maxtemp_f":111.6,"mintemp_c":30.5,"mintemp_f":86.9,"avgtemp_c":37.7,"avgtemp_f":99.9,"maxwind_mph":13.4,"maxwind_kph":21.6,"totalprecip_mm":0,"totalprecip_in":0,"avgvis_km":10,"avgvis_miles":6,"avghumidity":22,"condition":{"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003},"uv":9},"astro":{"sunrise":"05:23 AM","sunset":"07:30 PM","moonrise":"01:55 AM","moonset":"03:01 PM"}},{"date":"2019-06-29","date_epoch":1561766400,"day":{"maxtemp_c":45.6,"maxtemp_f":114.1,"mintemp_c":32.1,"mintemp_f":89.8,"avgtemp_c":39,"avgtemp_f":102.2,"maxwind_mph":18.6,"maxwind_kph":29.9,"totalprecip_mm":0,"totalprecip_in":0,"avgvis_km":10,"avgvis_miles":6,"avghumidity":21,"condition":{"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003},"uv":9},"astro":{"sunrise":"05:23 AM","sunset":"07:30 PM","moonrise":"02:29 AM","moonset":"04:01 PM"}}]}
     */

    public LocationBean location;
    public CurrentBean current;
    public ForecastBean forecast;

    public static class LocationBean {
        /**
         * name : Sohana
         * region : Punjab
         * country : India
         * lat : 30.68
         * lon : 76.72
         * tz_id : Asia/Kolkata
         * localtime_epoch : 1561355388
         * localtime : 2019-06-24 11:19
         */

        public String name;
        public String region;
        public String country;
        public double lat;
        public double lon;
        public String tz_id;
        public int localtime_epoch;
        public String localtime;
    }

    public static class CurrentBean {
        /**
         * last_updated_epoch : 1561354488
         * last_updated : 2019-06-24 11:04
         * temp_c : 32.2
         * temp_f : 90.0
         * is_day : 1
         * condition : {"text":"Partly cloudy","icon":"//cdn.apixu.com/weather/64x64/day/116.png","code":1003}
         * wind_mph : 10.1
         * wind_kph : 16.2
         * wind_degree : 147
         * wind_dir : SSE
         * pressure_mb : 1007.0
         * pressure_in : 30.2
         * precip_mm : 0.0
         * precip_in : 0.0
         * humidity : 45
         * cloud : 6
         * feelslike_c : 34.2
         * feelslike_f : 93.6
         * vis_km : 10.0
         * vis_miles : 6.0
         * uv : 8.0
         * gust_mph : 11.6
         * gust_kph : 18.7
         */

        public int last_updated_epoch;
        public String last_updated;
        public double temp_c;
        public double temp_f;
        public int is_day;
        public ConditionBean condition;
        public double wind_mph;
        public double wind_kph;
        public int wind_degree;
        public String wind_dir;
        public double pressure_mb;
        public double pressure_in;
        public double precip_mm;
        public double precip_in;
        public int humidity;
        public int cloud;
        public double feelslike_c;
        public double feelslike_f;
        public double vis_km;
        public double vis_miles;
        public double uv;
        public double gust_mph;
        public double gust_kph;

        public static class ConditionBean {
            /**
             * text : Partly cloudy
             * icon : //cdn.apixu.com/weather/64x64/day/116.png
             * code : 1003
             */

            public String text;
            public String icon;
            public int code;
        }
    }

    public static class ForecastBean {
        public List<ForecastdayBean> forecastday;

        public static class ForecastdayBean {
            /**
             * date : 2019-06-24
             * date_epoch : 1561334400
             * day : {"maxtemp_c":41.8,"maxtemp_f":107.2,"mintemp_c":27.5,"mintemp_f":81.5,"avgtemp_c":33.3,"avgtemp_f":91.9,"maxwind_mph":12.1,"maxwind_kph":19.4,"totalprecip_mm":4.1,"totalprecip_in":0.16,"avgvis_km":9.6,"avgvis_miles":5,"avghumidity":43,"condition":{"text":"Moderate or heavy rain shower","icon":"//cdn.apixu.com/weather/64x64/day/356.png","code":1243},"uv":11.3}
             * astro : {"sunrise":"05:22 AM","sunset":"07:30 PM","moonrise":"No moonrise","moonset":"11:24 AM"}
             */

            public String date;
            public int date_epoch;
            public DayBean day;
            public AstroBean astro;

            public static class DayBean {
                /**
                 * maxtemp_c : 41.8
                 * maxtemp_f : 107.2
                 * mintemp_c : 27.5
                 * mintemp_f : 81.5
                 * avgtemp_c : 33.3
                 * avgtemp_f : 91.9
                 * maxwind_mph : 12.1
                 * maxwind_kph : 19.4
                 * totalprecip_mm : 4.1
                 * totalprecip_in : 0.16
                 * avgvis_km : 9.6
                 * avgvis_miles : 5.0
                 * avghumidity : 43.0
                 * condition : {"text":"Moderate or heavy rain shower","icon":"//cdn.apixu.com/weather/64x64/day/356.png","code":1243}
                 * uv : 11.3
                 */

                public double maxtemp_c;
                public double maxtemp_f;
                public double mintemp_c;
                public double mintemp_f;
                public double avgtemp_c;
                public double avgtemp_f;
                public double maxwind_mph;
                public double maxwind_kph;
                public double totalprecip_mm;
                public double totalprecip_in;
                public double avgvis_km;
                public double avgvis_miles;
                public double avghumidity;
                public ConditionBeanX condition;
                public double uv;

                public static class ConditionBeanX {
                    /**
                     * text : Moderate or heavy rain shower
                     * icon : //cdn.apixu.com/weather/64x64/day/356.png
                     * code : 1243
                     */

                    public String text;
                    public String icon;
                    public int code;
                }
            }

            public static class AstroBean {
                /**
                 * sunrise : 05:22 AM
                 * sunset : 07:30 PM
                 * moonrise : No moonrise
                 * moonset : 11:24 AM
                 */

                public String sunrise;
                public String sunset;
                public String moonrise;
                public String moonset;
            }
        }
    }
}