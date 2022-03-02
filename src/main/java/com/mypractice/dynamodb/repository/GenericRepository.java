package com.mypractice.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository<T> {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public T save(T object) {
        dynamoDBMapper.save(object);
        return object;
    }

    public  <D> T getById(String id, Class<T> destination) {
         return dynamoDBMapper.load(destination, id);
    }

    public  void deleteById(String id,  Class<T> destination) {
        dynamoDBMapper.delete(dynamoDBMapper.load(destination, id));
    }

    public  T updateById(String id, String attributeId, T destination) {
       dynamoDBMapper.save(destination,
                new DynamoDBSaveExpression()
                        .withExpectedEntry(attributeId,
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return destination;
    }
}
