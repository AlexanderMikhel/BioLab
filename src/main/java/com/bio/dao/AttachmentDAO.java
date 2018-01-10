package com.bio.dao;

import com.bio.domain.Attachment;
import com.bio.domain.Spectra;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AttachmentDAO {

    @Select("SELECT id,file_file_name,file_content_type,file_file_size from attachments where id = #{id} and deleted_at is null")
    Attachment get(@Param("id") Long id);

    List<Attachment> getList(@Param("ids") List<Long> ids,
                             @Param("name") String name,
                             @Param("directoryId") Long directoryId);

    @Delete("Update attachments set deleted_at = now() where id = #{id}")
    void delete(@Param("id") Long id);

    @Insert("Insert into attachments(file_file_name,file_content_type,file_file_size,directory_id)" +
            "values(fileFileName,fileContentType,fileFileSize,directoryId) returning id")
    List<Long> add(Attachment attachment);

    @Update("update attachments set updated_at = now(), file_file_name = #{fileFileName}, file_content_type = #{fileContentType}," +
            "file_file_size = #{fileFileSize},directory_id=#{directoryId}")
    void update(Attachment attachment);

    @Select("SELECT nextVal('attachments_id_seq')")
    Long getAttachmentId();

}
