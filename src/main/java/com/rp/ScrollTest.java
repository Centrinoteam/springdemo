package com.rp;


import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import static org.elasticsearch.common.xcontent.XContentFactory.*;
/**
 * @author rongpei
 * @Description: ${todo}
 * @date 2018/6/5
 */
public class ScrollTest {

    public static void main(String[] args) throws Exception{


        //设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        //创建client
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.10.76.212"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//        //搜索数据
//        GetResponse response = client.prepareGet("blog", "article", "1").execute().actionGet();
//        //输出结果
//        System.out.println(response.getSourceAsString());

        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(int i = 0;i < 1;i++){
            String uuid = UUID.randomUUID().toString();
            bulkRequest.add(client.prepareIndex("my_index", "doc1", uuid)
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("id", i)
                            .field("name", "nn"+i)
                            .endObject()
                    )
            );
            //if(i % 50000 == 0){
                bulkRequest.execute().actionGet();
                System.out.println(i);
            //}
        }




        //关闭client
        client.close();

    }



}
