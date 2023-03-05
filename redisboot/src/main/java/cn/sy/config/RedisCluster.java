package cn.sy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisCluster {
    //获取所有的集群节点
    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes; //192.168.207.128:7001,192.168.207.128:7002,192.168.207.128:7003

    //创建redis集群对象存放在spring容器中
    //spring会更具redis集群对象帮你创建redis操作模板
    @Bean
    public JedisCluster getJedisCluster(){
        //将字符串转换为set集合
        String [] redisNode=redisNodes.split(",");//['192.168.207.128:7001','192.168.207.128:7002']...
        //数组变set集合
        Set<HostAndPort> nodes=new HashSet<>();
        for(String no : redisNode){
            String hostAndPort=no;  //如：192.168.137.128:7001
            String [] hp=hostAndPort.split(":");
            HostAndPort hdp=new HostAndPort(hp[0],Integer.parseInt(hp[1]));
            //将封装好的节点对象放入集合
            nodes.add(hdp);
        }
        JedisCluster jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }
}
