package com.xzit.dao;

import com.xzit.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    @Insert("insert into tbl_book(type,name,description) values (#{type},#{name},#{description})")
    public void save(Book book);

    @Update("update tbl_book set type = #{type},name = #{name},description = #{description} where id = #{id}")
    public void update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public void delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> findAll();
}
