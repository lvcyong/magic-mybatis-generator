package com.magic.hibernate.domain;

import javax.persistence.*;

/**
 * <br>Filename:    FsUserCapacity  <br>
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
@Table(name = "fs_user_capacity", schema = "ymfsdb", catalog = "")
@IdClass(FsUserCapacityPK.class)
public class FsUserCapacity {
    private String hydm;
    private String userId;
    private Long totalCapacity;
    private long usedCapacity;
    private long tmpUsedCapacity;

    @Id
    @Column(name = "hydm", nullable = false, length = 30)
    public String getHydm() {
        return hydm;
    }

    public void setHydm(String hydm) {
        this.hydm = hydm;
    }

    @Id
    @Column(name = "user_id", nullable = false, length = 30)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "total_capacity", nullable = true)
    public Long getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Long totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    @Basic
    @Column(name = "used_capacity", nullable = false)
    public long getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(long usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    @Basic
    @Column(name = "tmp_used_capacity", nullable = false)
    public long getTmpUsedCapacity() {
        return tmpUsedCapacity;
    }

    public void setTmpUsedCapacity(long tmpUsedCapacity) {
        this.tmpUsedCapacity = tmpUsedCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FsUserCapacity that = (FsUserCapacity) o;

        if (usedCapacity != that.usedCapacity) return false;
        if (tmpUsedCapacity != that.tmpUsedCapacity) return false;
        if (hydm != null ? !hydm.equals(that.hydm) : that.hydm != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (totalCapacity != null ? !totalCapacity.equals(that.totalCapacity) : that.totalCapacity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hydm != null ? hydm.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (totalCapacity != null ? totalCapacity.hashCode() : 0);
        result = 31 * result + (int) (usedCapacity ^ (usedCapacity >>> 32));
        result = 31 * result + (int) (tmpUsedCapacity ^ (tmpUsedCapacity >>> 32));
        return result;
    }
}
