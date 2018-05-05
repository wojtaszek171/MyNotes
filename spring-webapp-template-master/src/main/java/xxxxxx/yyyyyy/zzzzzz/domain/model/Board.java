package xxxxxx.yyyyyy.zzzzzz.domain.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "BOARD")
public class Board implements Serializable {

    /**
     * serial version id.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "BOARD_NAME", nullable = false)
    private String name;

    @Column(name = "BOARD_COLOR",  nullable = true, length = 64)
    private String color;

    @Column(name = "BOARD_BACKGROUND",  nullable = true, length = 64)
    @Lob
    private Blob background;

    @Column(name = "ID_USER",  nullable = false, length = 64)
    private Integer id_user;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Blob getBackground() {
        return background;
    }

    public void setBackground(Blob background) {
        this.background = background;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
