package com.magic.hibernate.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <br>Filename:    FsFileTmp  <br>
 * Description:
 * <br>Copyright:   Copyright (c) 2016-2017 All Rights Reserved.<br>
 * Company:     lvcyong.com Inc.<br>
 * author:     lvcyong <br>
 * version:    1.0  <br>
 * Create at:   2017-09-28 11:58 <br>
 * <p>
 * Modification History:
 * <br>Date    &nbsp;     Author      Version     Description  <br>
 * ------------------------------------------------------------------  <br>
 * 2017-09-28    lvcyong      1.0         1.0 Version  <br>
 */
@Entity
@Table(name = "fs_file_tmp", schema = "ymfsdb", catalog = "")
@IdClass(FsFileTmpPK.class)
public class FsFileTmp {
    private String filePath;
    private String groupName;
    private String fileName;
    private String fileExtName;
    private long fileLength;
    private String fileMd5;
    private String crc32;
    private String dirId;
    private String hydm;
    private String userCreate;
    private Timestamp gmtCreate;
    private String depId;
    private Integer chunks;
    private Integer chunk;
    private Long chunkSize;
    private Long maxChunkSize;
    private String completedChunks;

    @Id
    @Column(name = "file_path", nullable = false, length = 128)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Id
    @Column(name = "group_name", nullable = false, length = 16)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "file_name", nullable = false, length = 256)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_ext_name", nullable = true, length = 16)
    public String getFileExtName() {
        return fileExtName;
    }

    public void setFileExtName(String fileExtName) {
        this.fileExtName = fileExtName;
    }

    @Basic
    @Column(name = "file_length", nullable = false)
    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    @Basic
    @Column(name = "file_md5", nullable = false, length = 32)
    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    @Basic
    @Column(name = "crc32", nullable = false, length = 8)
    public String getCrc32() {
        return crc32;
    }

    public void setCrc32(String crc32) {
        this.crc32 = crc32;
    }

    @Basic
    @Column(name = "dir_id", nullable = false, length = 36)
    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    @Basic
    @Column(name = "hydm", nullable = false, length = 30)
    public String getHydm() {
        return hydm;
    }

    public void setHydm(String hydm) {
        this.hydm = hydm;
    }

    @Basic
    @Column(name = "user_create", nullable = false, length = 30)
    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "dep_id", nullable = false, length = 30)
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "chunks", nullable = true)
    public Integer getChunks() {
        return chunks;
    }

    public void setChunks(Integer chunks) {
        this.chunks = chunks;
    }

    @Basic
    @Column(name = "chunk", nullable = true)
    public Integer getChunk() {
        return chunk;
    }

    public void setChunk(Integer chunk) {
        this.chunk = chunk;
    }

    @Basic
    @Column(name = "chunk_size", nullable = true)
    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }

    @Basic
    @Column(name = "max_chunk_size", nullable = true)
    public Long getMaxChunkSize() {
        return maxChunkSize;
    }

    public void setMaxChunkSize(Long maxChunkSize) {
        this.maxChunkSize = maxChunkSize;
    }

    @Basic
    @Column(name = "completed_chunks", nullable = true, length = -1)
    public String getCompletedChunks() {
        return completedChunks;
    }

    public void setCompletedChunks(String completedChunks) {
        this.completedChunks = completedChunks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FsFileTmp fsFileTmp = (FsFileTmp) o;

        if (fileLength != fsFileTmp.fileLength) return false;
        if (filePath != null ? !filePath.equals(fsFileTmp.filePath) : fsFileTmp.filePath != null) return false;
        if (groupName != null ? !groupName.equals(fsFileTmp.groupName) : fsFileTmp.groupName != null) return false;
        if (fileName != null ? !fileName.equals(fsFileTmp.fileName) : fsFileTmp.fileName != null) return false;
        if (fileExtName != null ? !fileExtName.equals(fsFileTmp.fileExtName) : fsFileTmp.fileExtName != null)
            return false;
        if (fileMd5 != null ? !fileMd5.equals(fsFileTmp.fileMd5) : fsFileTmp.fileMd5 != null) return false;
        if (crc32 != null ? !crc32.equals(fsFileTmp.crc32) : fsFileTmp.crc32 != null) return false;
        if (dirId != null ? !dirId.equals(fsFileTmp.dirId) : fsFileTmp.dirId != null) return false;
        if (hydm != null ? !hydm.equals(fsFileTmp.hydm) : fsFileTmp.hydm != null) return false;
        if (userCreate != null ? !userCreate.equals(fsFileTmp.userCreate) : fsFileTmp.userCreate != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(fsFileTmp.gmtCreate) : fsFileTmp.gmtCreate != null) return false;
        if (depId != null ? !depId.equals(fsFileTmp.depId) : fsFileTmp.depId != null) return false;
        if (chunks != null ? !chunks.equals(fsFileTmp.chunks) : fsFileTmp.chunks != null) return false;
        if (chunk != null ? !chunk.equals(fsFileTmp.chunk) : fsFileTmp.chunk != null) return false;
        if (chunkSize != null ? !chunkSize.equals(fsFileTmp.chunkSize) : fsFileTmp.chunkSize != null) return false;
        if (maxChunkSize != null ? !maxChunkSize.equals(fsFileTmp.maxChunkSize) : fsFileTmp.maxChunkSize != null)
            return false;
        if (completedChunks != null ? !completedChunks.equals(fsFileTmp.completedChunks) : fsFileTmp.completedChunks != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filePath != null ? filePath.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileExtName != null ? fileExtName.hashCode() : 0);
        result = 31 * result + (int) (fileLength ^ (fileLength >>> 32));
        result = 31 * result + (fileMd5 != null ? fileMd5.hashCode() : 0);
        result = 31 * result + (crc32 != null ? crc32.hashCode() : 0);
        result = 31 * result + (dirId != null ? dirId.hashCode() : 0);
        result = 31 * result + (hydm != null ? hydm.hashCode() : 0);
        result = 31 * result + (userCreate != null ? userCreate.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (depId != null ? depId.hashCode() : 0);
        result = 31 * result + (chunks != null ? chunks.hashCode() : 0);
        result = 31 * result + (chunk != null ? chunk.hashCode() : 0);
        result = 31 * result + (chunkSize != null ? chunkSize.hashCode() : 0);
        result = 31 * result + (maxChunkSize != null ? maxChunkSize.hashCode() : 0);
        result = 31 * result + (completedChunks != null ? completedChunks.hashCode() : 0);
        return result;
    }
}
