package com.magic.hibernate.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <br>Filename:    FsFile  <br>
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
@Table(name = "fs_file", schema = "ymfsdb", catalog = "")
public class FsFile {
    private String id;
    private String fileName;
    private String groupName;
    private String filePath;
    private String fileExtName;
    private long fileLength;
    private String fileMd5;
    private String crc32;
    private String dirId;
    private String hydm;
    private String depId;
    private byte isDeleted;
    private String userCreate;
    private Timestamp gmtCreate;
    private String userModified;
    private Timestamp gmtModified;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "group_name", nullable = false, length = 16)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "file_path", nullable = false, length = 128)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
    @Column(name = "dep_id", nullable = true, length = 30)
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false)
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
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
    @Column(name = "user_modified", nullable = true, length = 30)
    public String getUserModified() {
        return userModified;
    }

    public void setUserModified(String userModified) {
        this.userModified = userModified;
    }

    @Basic
    @Column(name = "gmt_modified", nullable = true)
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FsFile fsFile = (FsFile) o;

        if (fileLength != fsFile.fileLength) return false;
        if (isDeleted != fsFile.isDeleted) return false;
        if (id != null ? !id.equals(fsFile.id) : fsFile.id != null) return false;
        if (fileName != null ? !fileName.equals(fsFile.fileName) : fsFile.fileName != null) return false;
        if (groupName != null ? !groupName.equals(fsFile.groupName) : fsFile.groupName != null) return false;
        if (filePath != null ? !filePath.equals(fsFile.filePath) : fsFile.filePath != null) return false;
        if (fileExtName != null ? !fileExtName.equals(fsFile.fileExtName) : fsFile.fileExtName != null) return false;
        if (fileMd5 != null ? !fileMd5.equals(fsFile.fileMd5) : fsFile.fileMd5 != null) return false;
        if (crc32 != null ? !crc32.equals(fsFile.crc32) : fsFile.crc32 != null) return false;
        if (dirId != null ? !dirId.equals(fsFile.dirId) : fsFile.dirId != null) return false;
        if (hydm != null ? !hydm.equals(fsFile.hydm) : fsFile.hydm != null) return false;
        if (depId != null ? !depId.equals(fsFile.depId) : fsFile.depId != null) return false;
        if (userCreate != null ? !userCreate.equals(fsFile.userCreate) : fsFile.userCreate != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(fsFile.gmtCreate) : fsFile.gmtCreate != null) return false;
        if (userModified != null ? !userModified.equals(fsFile.userModified) : fsFile.userModified != null)
            return false;
        if (gmtModified != null ? !gmtModified.equals(fsFile.gmtModified) : fsFile.gmtModified != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (fileExtName != null ? fileExtName.hashCode() : 0);
        result = 31 * result + (int) (fileLength ^ (fileLength >>> 32));
        result = 31 * result + (fileMd5 != null ? fileMd5.hashCode() : 0);
        result = 31 * result + (crc32 != null ? crc32.hashCode() : 0);
        result = 31 * result + (dirId != null ? dirId.hashCode() : 0);
        result = 31 * result + (hydm != null ? hydm.hashCode() : 0);
        result = 31 * result + (depId != null ? depId.hashCode() : 0);
        result = 31 * result + (int) isDeleted;
        result = 31 * result + (userCreate != null ? userCreate.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (userModified != null ? userModified.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        return result;
    }
}
