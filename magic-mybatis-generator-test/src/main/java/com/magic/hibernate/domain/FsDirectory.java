package com.magic.hibernate.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <br>Filename:    FsDirectory  <br>
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
@Table(name = "fs_directory", schema = "ymfsdb", catalog = "")
public class FsDirectory {
    private String id;
    private String dirName;
    private String hydm;
    private String fatherId;
    private byte level;
    private byte dirType;
    private String topId;
    private byte isDeleted;
    private String depId;
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
    @Column(name = "dir_name", nullable = false, length = 250)
    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
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
    @Column(name = "father_id", nullable = false, length = 36)
    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "dir_type", nullable = false)
    public byte getDirType() {
        return dirType;
    }

    public void setDirType(byte dirType) {
        this.dirType = dirType;
    }

    @Basic
    @Column(name = "top_id", nullable = false, length = 36)
    public String getTopId() {
        return topId;
    }

    public void setTopId(String topId) {
        this.topId = topId;
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
    @Column(name = "dep_id", nullable = true, length = 30)
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
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

        FsDirectory that = (FsDirectory) o;

        if (level != that.level) return false;
        if (dirType != that.dirType) return false;
        if (isDeleted != that.isDeleted) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dirName != null ? !dirName.equals(that.dirName) : that.dirName != null) return false;
        if (hydm != null ? !hydm.equals(that.hydm) : that.hydm != null) return false;
        if (fatherId != null ? !fatherId.equals(that.fatherId) : that.fatherId != null) return false;
        if (topId != null ? !topId.equals(that.topId) : that.topId != null) return false;
        if (depId != null ? !depId.equals(that.depId) : that.depId != null) return false;
        if (userCreate != null ? !userCreate.equals(that.userCreate) : that.userCreate != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (userModified != null ? !userModified.equals(that.userModified) : that.userModified != null) return false;
        if (gmtModified != null ? !gmtModified.equals(that.gmtModified) : that.gmtModified != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dirName != null ? dirName.hashCode() : 0);
        result = 31 * result + (hydm != null ? hydm.hashCode() : 0);
        result = 31 * result + (fatherId != null ? fatherId.hashCode() : 0);
        result = 31 * result + (int) level;
        result = 31 * result + (int) dirType;
        result = 31 * result + (topId != null ? topId.hashCode() : 0);
        result = 31 * result + (int) isDeleted;
        result = 31 * result + (depId != null ? depId.hashCode() : 0);
        result = 31 * result + (userCreate != null ? userCreate.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (userModified != null ? userModified.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        return result;
    }
}
