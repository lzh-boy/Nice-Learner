package com.example.learner.mapper;
import  com.example.learner.bean.Notes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface NotesMapper {
    /**
     * 查找所有
     */
    @Select("select * from tb_notes")
    List<Notes> findAll();

    /**
     *通过Id查找笔记
     */
    @Select("select * from tb_notes where id=#{id}")
    Notes findNotesById(Integer id);

    /**
     * 通过UserId查找笔记
     * @param id
     * @return
     */
    @Select("select * from tb_notes where userId=#{id}")
    List<Notes> findNotesByUserId(Integer id);

    /**
     * 通过createDate查找笔记
     */
    @Select("SELECT * FROM tb_notes WHERE createDate=#{createTime}")
    List<Notes> findNotesByCreateDate(String createTime);

    /**
     * 添加笔记
     * @param
     */
    @Insert("insert into tb_notes(userId,content,createDate) values (#{userId},#{content},#{createDate})")
    void add(Notes notes);

    /**
     * 根据id更新笔记
     * @param
     */
    @Update("update  tb_notes set content = #{content} where id = #{id}")
    void update(Notes notes);

    /**
     * 通过Id删除笔记
     * @param id
     */

    @Delete("delete from tb_notes where id = #{id}")
    void delete(Integer id);
}
