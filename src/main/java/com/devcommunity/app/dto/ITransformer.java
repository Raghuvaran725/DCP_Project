package com.devcommunity.app.dto;

public interface ITransformer <T,V>{
    public T toDTO(V v);
    public V toObject();
}
