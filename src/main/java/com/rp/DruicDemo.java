package com.rp;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import org.springframework.jdbc.core.JdbcTemplate;
import stat.DruidDataSourceBuilder;

import java.util.List;

/**
 * @author rongpei
 * @Description: ${todo}
 * @date 2018/6/25
 */
public class DruicDemo {

    public static void main(String[] args){
        DruidDataSource ds = DruidDataSourceBuilder.create().build();
        ds.setUrl("jdbc:mysql://192.168.192.9:4000/cif_utcs?useUnicode=true&characterEncoding=UTF-8&tinyInt1isBit=false");
        ds.setUsername("root");
        ds.setPassword("hGDQYG0huSed");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setDbType("com.alibaba.druid.pool.DruidDataSource");

        JdbcTemplate jdbc = new JdbcTemplate(ds);


        DruidDataSource ds1 = DruidDataSourceBuilder.create().build();
        ds1.setUrl("jdbc:mysql://10.255.0.36:3309/finup_core?useUnicode=true&characterEncoding=UTF-8&tinyInt1isBit=false");
        ds1.setUsername("cif");
        ds1.setPassword("PNF)LS~5I9Ti");
        ds1.setDriverClassName("com.mysql.jdbc.Driver");
        ds1.setDbType("com.alibaba.druid.pool.DruidDataSource");

        JdbcTemplate jdbc1 = new JdbcTemplate(ds);

        String sql = "select count(*)  as USRCV065\n" +
                "from \n" +
                "  finup_core.core_asset_customer as cac right join \n" +
                "  finup_core.core_customer as cc  on cc.id_no = cac.id_no \n" +
                "  right join \n" +
                "  finup_core.core_lend_request as clr on clr.core_lend_customer_id=cc.id\n" +
                "where \n" +
                "cac.mobile = '13731674081' and \n" +
                "clr.request_source like 'RM%'\n";


        List result = jdbc.queryForList(sql);

        System.out.println(JSON.toJSON(result));

        List result1 = jdbc1.queryForList(sql);
        System.out.println(JSON.toJSON(result1));
    }
}
