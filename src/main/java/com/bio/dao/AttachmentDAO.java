package com.bio.dao;

import com.bio.domain.Attachment;
import com.bio.domain.Spectra;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AttachmentDAO {
    Attachment getAttachmentById(@Param("id") Integer id);

    List<Attachment> getAttachments(@Param("userId") Integer userId,
                                    @Param("forMessages") Boolean forMessages);

    @Delete("Update attachments SET deleted_at = now() WHERE id=#{id}")
    void deleteAttachment(@Param("id") Integer id);

    List<Attachment> getAttachmentsById(@Param("ids") List<Integer> ids);

    void createAttachment(@Param("attachment") Attachment attachment);

    @Select("SELECT nextVal('lesson_comments_id_seq')")
    Integer getAttachmentId();

    Boolean existenceOfLink(@Param("id") Integer id);

    @Update("Update file_storage_entries set deleted_at = now()" +
            "where attachment_id=#{id} AND file_storage_id IN " +
            "(SELECT id FROM file_storages WHERE user_id = #{userId})")
    void deleteFileStorageEntries(@Param("id") Integer id,
                                  @Param("userId") Integer userId);

    @Insert("INSERT INTO file_storage_entries (file_storage_id, attachment_id) VALUES (#{idFileStorage}, #{attachmentId})")
    void createFileStorageEntries(@Param("attachmentId") Integer attachmentId,
                                  @Param("idFileStorage") Integer idFileStorage);

    @Select("SELECT id FROM file_storages WHERE user_id=#{userId} LIMIT 1")
    Integer getFileStorage(@Param("userId") Integer userId);

    @Select("SELECT nextVal('file_storages_id_seq')")
    Integer getFileStorageId();

    @Insert("INSERT INTO file_storages (id, user_id, created_at, updated_at) VALUES (#{idFileStorage}, #{userId}, now(), now())")
    void createFileStorage(@Param("idFileStorage") Integer idFileStorage,
                           @Param("userId") Integer userId);




    @Insert("INSERT INTO spectra_data(profile_id,spectra,name) VALUES (#{profileId},#{stringPoints},#{name})")
    void saveSpectraDataFromFiles(Spectra spectra);

    @Select("Select spectra from spectra_data where id = #{id}")
    Spectra getSpectraDataById(Integer id);
}
