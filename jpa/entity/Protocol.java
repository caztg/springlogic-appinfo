package cn.springlogic.appinfo.jpa.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fitcooker.app.serializer.ServerPreFixSerializer;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/6/15.
 */

@Data
@Entity
public class Protocol {
    @Id
    @Column
    private Integer id;

    @Column
    private String position;

    @Column(name = "cover_img")
    private String coverImg;

    @Column
    private String title;

    @Column
    private String summary;

    @Column
    private String body;

    @Column(name = "create_time")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Transient
    private String url;

    @JsonSerialize(using = ServerPreFixSerializer.class)
    public String getUrl() {
        url = "/api/appinfo/protocol/" + this.id;
        return url;
    }
}
