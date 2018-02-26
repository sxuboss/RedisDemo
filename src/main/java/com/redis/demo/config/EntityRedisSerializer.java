package com.redis.demo.config;

import com.redis.demo.utils.SerializeUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/26  
 *  @Time:9:50    
 *  
 */
public class EntityRedisSerializer implements RedisSerializer<Object> {


    @Override
    public byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return SerializeUtil.serialize(t);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return SerializeUtil.unserialize(bytes);
    }

}
